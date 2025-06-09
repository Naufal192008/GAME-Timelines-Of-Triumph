import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class VS here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VS extends Actor
{
     private int timer = 60; 
     /**
     * Act - do whatever the VS wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     public VS() {
        setImage("menu (24).png"); // Pastikan file "vs.png" ada di folder images
    }
    public void act()
    {
        // Add your action code here.
        timer--;
        if(timer <=0){
            getWorld().removeObject(this);
        }
    }
}
