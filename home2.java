import greenfoot.*;

public class home2 extends World {
    public home2() {
        super(900, 600, 1);
          BGMPlayer.playLoop();
        prepare();
    }
      public void started() {
        BGMPlayer.resume();
    }

    public void stopped() {
        BGMPlayer.pause();
    }

    private void prepare() {
        // Tambahkan LEVEL4 jika level3 selesai
        if (GlobalData.levelTerselesaikan.contains("level3")) {
            addObject(new LEVEL4(), 550, 500);
        } else {
            addObject(new Gembok(), 550, 500);
        }

        // Tambahkan LEVEL5 jika level4 selesai
        if (GlobalData.levelTerselesaikan.contains("level4")) {
            addObject(new LEVEL5(), 700, 500);
        } else {
            addObject(new Gembok(), 700, 500);
        }

        // Tambahkan LEVELBONUS jika level5 selesai
        if (GlobalData.levelTerselesaikan.contains("level5")) {
            addObject(new LEVEL_BONUS(), 850, 500);
        } else {
            addObject(new Gembok(), 850, 500);
        }

        // Tombol ke halaman awal
        addObject(new KE_HOME(), 870, 35);
        BUY bUY = new BUY();
        addObject(bUY,115,75);
    }
}
