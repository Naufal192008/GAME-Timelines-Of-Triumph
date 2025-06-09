import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class next12 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class next12 extends Actor
{
    /**
     * Act - do whatever the next12 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
             Greenfoot.playSound("next12.mp3"); 
            Greenfoot.setWorld(new next_cara_main());
        }
    }
}
