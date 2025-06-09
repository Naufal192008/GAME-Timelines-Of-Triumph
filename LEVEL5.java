import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LEVEL5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LEVEL5 extends Actor
{
    /**
     * Act - do whatever the LEVEL5 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new halaman_LEVEL5());
        }
    }
}
