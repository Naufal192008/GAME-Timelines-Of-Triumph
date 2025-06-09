import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NEXT1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NEXT1 extends World
{

    /**
     * Constructor for objects of class NEXT1.
     * 
     */
    public NEXT1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 600, 1); 

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
        strat strat = new strat();
        addObject(strat,433,481);
        perintah perintah = new perintah();
        addObject(perintah,148,56);
    }
}
