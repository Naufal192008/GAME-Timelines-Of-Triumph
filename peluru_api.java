import greenfoot.*;

public class peluru_api extends Actor {
    private monster1 target;

    public peluru_api(monster1 target) {
        this.target = target;
        setImage("menu (10).png");
    }

    public void act() {
        setLocation(getX() + 5, getY());
        if (isTouching(monster1.class)) {
            target.kurangiDarah(1);
            getWorld().removeObject(this);
        }
    }
}
