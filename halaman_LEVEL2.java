import greenfoot.*;
import java.util.*;

public class halaman_LEVEL2 extends World {
    private LabelSoal labelSoal;

    private Player player;
    private monster2 monster;
    private TextInput textInput;

    private String[] semuaPertanyaan = {
            "Siapa tokoh dari Minangkabau yang berperan dalam Kongres Pemuda II?",
            "Apa nama kerajaan tertua di Indonesia?",
            "Tahun berapa VOC dibubarkan?",
            "Di mana tempat ditemukannya Prasasti Yupa?",
            "Siapa pendiri Kerajaan Singasari?",
            "Apa isi utama Sumpah Palapa Gajah Mada?",
            "Kerajaan Sriwijaya terkenal dalam bidang apa?",
            "Siapa yang menulis buku 'Indonesia Menggugat'?",
            "Perjanjian Linggarjati terjadi antara Indonesia dan negara mana?",
            "Apa nama organisasi pemuda yang dibentuk tahun 1927 oleh Soekarno?",
            "Apa tujuan utama Politik Etis?",
            "Siapa yang memproklamasikan kemerdekaan RI selain Soekarno?",
            "Siapa penulis teks proklamasi?",
            "Kerajaan Majapahit mencapai puncak kejayaan pada masa siapa?",
            "Apa nama kerajaan Islam pertama di Indonesia?",
            "Apa isi Trikora yang dicanangkan Soekarno?",
            "Apa nama kelompok perlawanan terhadap VOC di Makassar?",
            "Apa nama pahlawan wanita dari Aceh?",
            "Siapa tokoh pejuang diplomasi Indonesia di PBB?",
            "Apa nama kerajaan bercorak Hindu di Jawa Barat?"
        };

    private String[] semuaJawaban = {
            "Mohammad Yamin",
            "Kutai",
            "1799",
            "Kalimantan Timur",
            "Ken Arok",
            "Menyatukan Nusantara",
            "Maritim dan perdagangan",
            "Soekarno",
            "Belanda",
            "PNI",
            "Membalas budi kepada rakyat Indonesia",
            "Mohammad Hatta",
            "Soekarno",
            "Hayam Wuruk",
            "Samudra Pasai",
            "Mengembalikan Irian Barat ke pangkuan RI",
            "Perlawanan Sultan Hasanuddin",
            "Cut Nyak Dhien",
            "Agus Salim",
            "Tarumanegara"
        };

    private List<Integer> soalTerpilih = new ArrayList<>();
    private int soalIndex = 0;
    private int timerSoal = 3600;
    private boolean sedangMenjawab = false;
    private DarahPlayer darahPlayer;
    private DarahMonster darahMonsterBar;
    private int nyawaPlayer = 3;
    private int nyawaMonster = 3;

    public halaman_LEVEL2() {
        super(900, 600, 1);
         BGMPlayer.playLoop();
        darahPlayer = new DarahPlayer();
        addObject(darahPlayer, 100, 50);
        darahMonsterBar = new DarahMonster();
        addObject(darahMonsterBar, 800, 50);

           showVSImage();
    prepare(); // <-- Panggil prepare() di atas

    textInput = new TextInput();
    addObject(textInput, getWidth() / 2, getHeight() / 2 + 50);

    acakPertanyaan();
    tampilkanPertanyaan();

    }
    public void nextLevel() {
        Greenfoot.setWorld(new halaman_LEVEL3());
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
            timerSoal = 3600;
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
            Playerserang1 serang = new Playerserang1();
            addObject(serang, player.getX(), player.getY());
            Greenfoot.delay(20);
            removeObject(serang);
            addObject(new peluru_api2(monster), player.getX(), player.getY());

            nyawaMonster--;
            darahMonsterBar.setHP(nyawaMonster);
            Greenfoot.playSound("betul1.mp3");

            if (nyawaMonster <= 0) {
                removeObject(monster);
                showText("Kamu Menang!", getWidth() / 2, getHeight() / 2 - 50);
                GlobalData.tambahPoin(150);
                GlobalData.selesaikanLevel("level2"); // ✅ FIXED: sebelumnya "level3"
                
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


    public void nextLevel2() {
        Greenfoot.setWorld(new halaman_LEVEL3()); // <-- Jika kamu sudah buat LEVEL3
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
   private void prepare() {
    monster = new monster2(); // ← pakai field monster yang sudah dibuat
    addObject(monster, 529, 356);

    player = new Player(); // ← pakai field player
    addObject(player, 303, 350);

    KE_HOME kE_HOME = new KE_HOME();
    addObject(kE_HOME, 865, 38);

    KE_AWAL kE_AWAL = new KE_AWAL();
    addObject(kE_AWAL, 33, 41);
}

}
