import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gembok here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gembok extends Actor {
    public Gembok() {
        setImage("TOT (24).png"); // Tambahkan gambar gembok ke proyek
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.playSound("tidak_bisa.mp3");
        }
    }
}
