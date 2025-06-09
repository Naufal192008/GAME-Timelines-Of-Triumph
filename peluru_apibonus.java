import greenfoot.*;

public class peluru_apibonus extends Actor {
    private monster6 target;

    public peluru_apibonus(monster6 target) {
        this.target = target;
        setImage("menu (10).png");
    }

    public void act() {
        setLocation(getX() + 5, getY());
        if (isTouching(monster6.class)) {
            target.kurangiDarah(1);
            getWorld().removeObject(this);
        }
    }
}
