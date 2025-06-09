import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cara_win here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cara_win extends World
{

    /**
     * Constructor for objects of class Cara_win.
     * 
     */
    public Cara_win()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 600, 1); 
        prepare();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        KE_AWAL KE_AWAL = new KE_AWAL();
        addObject(KE_AWAL,637,69);
    }
}
