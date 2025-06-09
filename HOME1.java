import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HOME2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HOME1 extends World
{

    /**
     * Constructor for objects of class HOME2.
     * 
     */
    public HOME1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
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
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        FileManager.muatData(); // <-- Penting untuk cek status terbaru
// Hanya buka level 2 jika level1 sudah selesai
if (GlobalData.levelTerselesaikan.contains("level1")) {
    level2 level2 = new level2();
    addObject(level2, 727, 361);
} else {
    Gembok gembok2 = new Gembok();
    addObject(gembok2, 727, 361);
}

// Hanya buka level 3 jika level1 DAN level2 sudah selesai
if (GlobalData.levelTerselesaikan.contains("level1") && GlobalData.levelTerselesaikan.contains("level2")) {
    level3 level3 = new level3();
    addObject(level3, 441, 55);
} else {
    Gembok gembok3 = new Gembok();
    addObject(gembok3, 441, 55);
}

        FileManager.simpanData();

        // Lanjutkan sesuai kebutuhan...
        BUY bUY = new BUY();
        addObject(bUY,112,73);

        KE_AWAL kE_AWAL = new KE_AWAL();
        addObject(kE_AWAL,871,31);
        level1 level1 = new level1();
        addObject(level1,135,530);
        LabelPoin labelPoin = new LabelPoin();
        addObject(labelPoin, 100, 30); // posisi sesuaikan

    }

}
