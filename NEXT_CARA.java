import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NEXT_CARA here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NEXT_CARA extends Actor
{
    /**
     * Act - do whatever the NEXT_CARA wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new HOME1());
        }
    }
}
