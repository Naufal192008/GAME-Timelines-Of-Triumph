import greenfoot.*;

public class peluru_api4 extends Actor {
    private monster4 target;

    public peluru_api4(monster4 target) {
        this.target = target;
        setImage("menu (10).png");
    }

    public void act() {
        setLocation(getX() + 5, getY());
        if (isTouching(monster4.class)) {
            target.kurangiDarah(1);
            getWorld().removeObject(this);
        }
    }
}
