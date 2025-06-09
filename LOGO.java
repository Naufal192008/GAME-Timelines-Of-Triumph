import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LOGO here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LOGO extends World
{
    private int timer = 0;
    private GreenfootSound sound;

    /**
     * Constructor for objects of class LOGO.
     * 
     */
    public LOGO()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 600, 1); 
        BGMPlayer.playLoop();
        sound= new GreenfootSound("logo.mp3");
        sound.play();
    }
     public void started() {
        BGMPlayer.resume();
    }

    public void stopped() {
        BGMPlayer.pause();
    }
     public void act() {
        timer++; // Tambah waktu setiap act cycle
        if (timer >= 10 * 10) { // 5 detik (60 act cycles = 1 detik)
            sound.stop();
            Greenfoot.setWorld(new NEXT1());
        }
}
}