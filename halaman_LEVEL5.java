import greenfoot.*;
import java.util.*;

public class halaman_LEVEL5 extends World {
    private LabelSoal labelSoal;

    private Player player;
    private monster5 monster;
    private TextInput textInput;

    private String[] semuaPertanyaan = {
            "Apa nama perjanjian yang menyebabkan Maluku dikuasai Portugis pada abad ke-16?",
            "Siapa tokoh yang memimpin Perang Padri setelah Tuanku Nan Renceh?",
            "Apa fungsi utama Cultuurstelsel bagi Belanda?",
            "Siapa tokoh penting di balik pembentukan BPUPKI?",
            "Apa isi pokok Piagam Jakarta yang kemudian diubah?",
            "Apa nama pasukan elite Belanda yang ditugaskan memadamkan perlawanan rakyat?",
            "Apa latar belakang utama Peristiwa Bandung Lautan Api?",
            "Apa isi utama Resolusi Jihad oleh Hasyim Asy’ari tahun 1945?",
            "Apa peran utama Sutan Sjahrir saat awal kemerdekaan?",
            "Siapa pemimpin perlawanan rakyat Bali terhadap Belanda pada abad ke-19?",
            "Organisasi internasional apa yang pertama kali mengakui kedaulatan Indonesia?",
            "Apa arti penting pertempuran Medan Area bagi Indonesia?",
            "Apa tujuan pembentukan Panitia Sembilan?",
            "Siapa tokoh yang dikenal dengan julukan 'Bapak Koperasi Indonesia'?",
            "Apa nama organisasi yang didirikan Belanda untuk menggantikan PETA dan Heiho?",
            "Apa nama sistem pertanian yang merugikan petani Indonesia selain tanam paksa?",
            "Apa nama kelompok yang berperan menyusun RUU Dasar 1945?",
            "Siapa tokoh penting dari Ambon yang berjuang melalui jalur diplomasi?",
            "Siapa pemimpin pemberontakan DI/TII di Jawa Barat?",
            "Apa nama organisasi pelajar yang aktif dalam revolusi fisik?"
        };

    private String[] semuaJawaban = {
            "Perjanjian Saragosa",
            "Tuanku Imam Bonjol",
            "Menambah kas negara Belanda",
            "Letjen Kumakichi Harada",
            "\"Kewajiban menjalankan syariat Islam bagi pemeluknya\"",
            "KNIL",
            "Menghindari pendudukan Sekutu dan NICA",
            "Wajib hukumnya membela tanah air",
            "Perdana Menteri pertama RI",
            "I Gusti Ketut Jelantik",
            "Liga Arab",
            "Menunjukkan semangat mempertahankan kemerdekaan di Sumatra",
            "Merumuskan dasar negara",
            "Mohammad Hatta",
            "KNIL",
            "Sistem sewa tanah",
            "Panitia Perancang Undang-Undang Dasar",
            "Dr. Johannes Leimena",
            "Kartosuwiryo",
            "TRIP"
        };

    private List<Integer> soalTerpilih = new ArrayList<>();
    private int soalIndex = 0;
    private int timerSoal = 1800;
    private boolean sedangMenjawab = false;
    private DarahPlayer darahPlayer;
    private DarahMonster darahMonsterBar;
    private int nyawaPlayer = 3;
    private int nyawaMonster = 3;

    public halaman_LEVEL5() {
        super(900, 600, 1);
         BGMPlayer.playLoop();
        darahPlayer = new DarahPlayer();
        addObject(darahPlayer, 100, 50);
        darahMonsterBar = new DarahMonster();
        addObject(darahMonsterBar, 800, 50);

        showVSImage();

        textInput = new TextInput();
        addObject(textInput, getWidth() / 2, getHeight() / 2 + 50);

        acakPertanyaan();
        tampilkanPertanyaan(); 
        prepare();
    }
      public void started() {
        BGMPlayer.resume();
    }

    public void stopped() {
        BGMPlayer.pause();
    }
    public void act() {
        if (sedangMenjawab) {
            timerSoal--;
            showText("Waktu: " + (timerSoal / 60) + " detik", getWidth() / 2, getHeight() / 2 - 50);

            if (Greenfoot.isKeyDown("enter")) {
                prosesJawaban(textInput.getInput());
            }

            if (timerSoal <= 0) {
                prosesJawaban("");
            }
        }
    }

    private void acakPertanyaan() {
        Random rand = new Random();
        while (soalTerpilih.size() < 5) {
            int idx = rand.nextInt(semuaPertanyaan.length);
            if (!soalTerpilih.contains(idx)) {
                soalTerpilih.add(idx);
            }
        }
    }

    private void tampilkanPertanyaan() {
        if (labelSoal != null) {
            removeObject(labelSoal);
        }

        if (soalIndex < soalTerpilih.size()) {
            int idx = soalTerpilih.get(soalIndex);
            labelSoal = new LabelSoal(semuaPertanyaan[idx]);
            addObject(labelSoal, getWidth() / 2, getHeight() / 2);
            textInput.clearInput();
            sedangMenjawab = true;
            timerSoal = 1800;
        } else {
            showText("Level Selesai!", getWidth() / 2, getHeight() / 2 - 50);
            addObject(new next(), getWidth() / 2, getHeight() / 2 + 20);
        }
    }

    private void prosesJawaban(String input) {
        sedangMenjawab = false;
        int idx = soalTerpilih.get(soalIndex);
        String jawabanBenar = semuaJawaban[idx];

        showText("", getWidth() / 2, getHeight() / 2);
        showText("", getWidth() / 2, getHeight() / 2 - 50);

        if (input.equalsIgnoreCase(jawabanBenar)) {
            addObject(new peluru_api5(monster), player.getX(), player.getY());
            nyawaMonster--;
            darahMonsterBar.setHP(nyawaMonster);
            Greenfoot.playSound("betul1.mp3");

            if (nyawaMonster <= 0) {
                removeObject(monster);
                showText("Kamu Menang!", getWidth() / 2, getHeight() / 2 - 50);
                GlobalData.tambahPoin(150);
                addObject(new next(), getWidth() / 2, getHeight() / 2 + 20);
                return;
            }
        } else {
            addObject(new bola_lendir(player), monster.getX(), monster.getY());
            nyawaPlayer--;
            darahPlayer.setHP(nyawaPlayer);
            Greenfoot.playSound("salah (1).mp3");

            if (nyawaPlayer <= 0) {
                showText("Game Over", getWidth() / 2, getHeight() / 2 - 50);
                addObject(new TombolUlang(), getWidth() / 2, getHeight() / 2 + 20);
                return;
            }
        }

        soalIndex++;
        Greenfoot.delay(40);
        tampilkanPertanyaan();
    }

    private void showVSImage() {
        VS vs = new VS();
        addObject(vs, getWidth() / 2, 50);
    }


    public void nextLevel() {
        Greenfoot.setWorld(new halaman_kebonus()); // <-- Jika kamu sudah buat LEVEL3
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        player = new Player();
        addObject(player, 347, 346);
        monster = new monster5();
        addObject(monster,478,465);
        addObject(new KE_AWAL(), 42, 41);
        addObject(new KE_HOME(), 870, 39);
        
    }
}
