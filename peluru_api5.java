import greenfoot.*;

public class peluru_api5 extends Actor {
    private monster5 target;

    public peluru_api5(monster5 target) {
        this.target = target;
        setImage("menu (10).png");
    }

    public void act() {
        setLocation(getX() + 5, getY());
        if (isTouching(monster5.class)) {
            target.kurangiDarah(1);
            getWorld().removeObject(this);
        }
    }
}
