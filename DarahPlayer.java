import greenfoot.*;

public class DarahPlayer extends Actor {
    private GreenfootImage[] gambarDarah = {
        new GreenfootImage("menu (44).png"),
        new GreenfootImage("menu (43).png"),
        new GreenfootImage("menu (42).png"),
        new GreenfootImage("menu (41).png")
    };
    private int hp = 3;

    public DarahPlayer() {
        setImage(gambarDarah[hp]);
    }

    public void setHP(int nyawa) {
        hp = nyawa;
        if (hp < 0) hp = 0;
        setImage(gambarDarah[hp]);
    }

    public int getHP() {
        return hp;
    }
}
