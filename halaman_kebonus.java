import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootSound;

/**
 * Write a description of class halaman_kebonus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class halaman_kebonus extends World
{
private int timer =0;
private GreenfootSound sound; 
    /**
     * Constructor for objects of class halaman_kebonus.
     * 
     */
    public halaman_kebonus()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 600, 1);
        sound= new GreenfootSound("bonus.mp3");
        sound.play();
    }
     public void act() {
        timer++; // Tambah waktu setiap act cycle
        if (timer >= 5 * 50) { // 5 detik (60 act cycles = 1 detik)
            sound.stop();
            Greenfoot.setWorld(new halaman_LEVELBONUS());
        }
}
}
