import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class KE_AWAL here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KE_AWAL extends Actor
{
    /**
     * Act - do whatever the KE_AWAL wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {

        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new NEXT1());
        }
    }
}
