import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class next_sebelum_mulai here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class next_sebelum_mulai extends World
{

    /**
     * Constructor for objects of class next_sebelum_mulai.
     * 
     */
    public next_sebelum_mulai()
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

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        NEXT_CARA nEXT_CARA = new NEXT_CARA();
        addObject(nEXT_CARA,93,225);
    }
}
