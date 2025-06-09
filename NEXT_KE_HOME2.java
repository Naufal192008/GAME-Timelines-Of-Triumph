import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NEXT_KE_HOME2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NEXT_KE_HOME2 extends World
{

    /**
     * Constructor for objects of class NEXT_KE_HOME2.
     * 
     */
    public NEXT_KE_HOME2()
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
        KE_HOME kE_HOME = new KE_HOME();
        addObject(kE_HOME,870,43);
    }
}
