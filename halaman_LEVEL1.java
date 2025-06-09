import greenfoot.*;
import java.util.*;

public class halaman_LEVEL1 extends World {
    private LabelSoal labelSoal;
    private Player player;
    private monster1 monster;
    private TextInput textInput;

    private String[] semuaPertanyaan = {
        "Siapa proklamator Indonesia?", "Kapan Indonesia merdeka?", "Apa ibu kota Indonesia?",
        "Siapa presiden pertama Indonesia?", "Apa lagu kebangsaan Indonesia?", "Siapa wakil presiden pertama Indonesia?",
        "Apa warna bendera Indonesia?", "Apa dasar negara Indonesia?", "Siapa pahlawan dari Aceh?", "Apa nama teks proklamasi?"
    };

    private String[] semuaJawaban = {
        "Soekarno", "17 Agustus 1945", "Jakarta", "Soekarno", "Indonesia Raya", "Moh Hatta",
        "Merah Putih", "Pancasila", "Cut Nyak Dien", "Teks Proklamasi"
    };

    private List<Integer> soalTerpilih = new ArrayList<>();
    private int soalIndex = 0;
    private int timerSoal = 3600;
    private boolean sedangMenjawab = false;
    private DarahPlayer darahPlayer;
    private DarahMonster darahMonsterBar;
    private int nyawaPlayer = 3;
    private int nyawaMonster = 3;

    public halaman_LEVEL1() {
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
            showText("", getWidth() / 2, getHeight() / 2 - 50);
            showText("", getWidth() / 2, getHeight() / 2);

            labelSoal = new LabelSoal(semuaPertanyaan[idx]);
            addObject(labelSoal, getWidth() / 2, getHeight() / 2);
            textInput.clearInput();
            sedangMenjawab = true;
            timerSoal = 3600;
        } else {
            showText("Level Selesai!", getWidth() / 2, getHeight() / 2 - 50);
            addObject(new TombolNext(), getWidth() / 2, getHeight() / 2 + 20);
        }
    }

    private void prosesJawaban(String input) {
        sedangMenjawab = false;
        int idx = soalTerpilih.get(soalIndex);
        String jawabanBenar = semuaJawaban[idx];

        showText("", getWidth() / 2, getHeight() / 2);
        showText("", getWidth() / 2, getHeight() / 2 - 50);
if (input.equalsIgnoreCase(jawabanBenar)) {
    // 1. Sembunyikan player utama
    player.setImage((GreenfootImage) null);

    // 2. Tambahkan animasi serang
    Playerserang1 serang = new Playerserang1();
    addObject(serang, player.getX(), player.getY());

    // 3. Tambahkan peluru bersamaan
    peluru_api peluru = new peluru_api(monster);
    addObject(peluru, player.getX(), player.getY());

    // 4. Delay agar animasi serang dan peluru terlihat dulu
    Greenfoot.delay(20);

    // 5. Hapus animasi serang, munculkan kembali player biasa
    removeObject(serang);
    player.setImage("menu (12).png");

    // 6. Update nyawa monster dan cek kemenangan
    nyawaMonster--;
    darahMonsterBar.setHP(nyawaMonster);
    Greenfoot.playSound("betul1.mp3");

    if (nyawaMonster <= 0) {
        removeObject(monster);
        showText("Kamu Menang!", getWidth() / 2, getHeight() / 2 - 50);
        GlobalData.tambahPoin(150);
        GlobalData.selesaikanLevel("level1");
        addObject(new TombolNext(), getWidth() / 2, getHeight() / 2 + 20);
        return;
    }
}



        soalIndex++;
        Greenfoot.delay(40);
        tampilkanPertanyaan();
    }

    public void nextLevel() {
        Greenfoot.setWorld(new halaman_LEVEL2());
    }

    private void showVSImage() {
        VS vs = new VS();
        addObject(vs, getWidth() / 2, 50);
    }

    private void prepare() {
        player = new Player();
        addObject(player, 316, 340);

        monster = new monster1();
        addObject(monster, 500, 263);

        KE_HOME kE_HOME = new KE_HOME();
        addObject(kE_HOME, 870, 35);
    }
}
