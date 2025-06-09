import greenfoot.*;

public class bola_lendir extends Actor {
    private Player target;

    public bola_lendir(Player target) {
        this.target = target;
        setImage("menu (34).png");
    }

    public void act() {
        setLocation(getX() - 5, getY());
        if (isTouching(Player.class)) {
            target.setHP(target.getHP() - 1);
            getWorld().removeObject(this);
        }
    }
}