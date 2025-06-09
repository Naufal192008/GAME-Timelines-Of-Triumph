import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class strat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class strat extends Actor
{
    /**
     * Act - do whatever the strat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.mouseClicked(this)){
             Greenfoot.playSound("buat_mulai.mp3"); 
            Greenfoot.setWorld(new NEXT2());
        }
    }
}
