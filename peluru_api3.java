import greenfoot.*;

public class peluru_api3 extends Actor {
    private monster3 target;

    public peluru_api3(monster3 target) {
        this.target = target;
        setImage("menu (10).png");
    }

    public void act() {
        setLocation(getX() + 5, getY());
        if (isTouching(monster3.class)) {
            target.kurangiDarah(1);
            getWorld().removeObject(this);
        }
    }
}
