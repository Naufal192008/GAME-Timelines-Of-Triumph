import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class next_cara_main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class next_cara_main extends World
{

    /**
     * Constructor for objects of class next_cara_main.
     * 
     */
    public next_cara_main()
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
        nextkesebelummulai nextkesebelummulai = new nextkesebelummulai();
        addObject(nextkesebelummulai,811,534);
    }
}
