import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BUY here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BUY extends Actor
{
    /**
     * Act - do whatever the BUY wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new toko1());
        }
    }
}
