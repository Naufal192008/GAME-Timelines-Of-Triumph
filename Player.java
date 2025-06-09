import greenfoot.*;

public class Player extends Actor {
    private int hp = 3;
    private DarahPlayer darah;

    public Player() {
        setImage("menu (12).png");
        updateHPDisplay();
    }

    public Player(DarahPlayer darah) {
        this();
        this.darah = darah;
        this.darah.setHP(hp);
    }

    public void addedToWorld(World world) {
        if (darah == null) {
            darah = (DarahPlayer) world.getObjects(DarahPlayer.class).get(0);
        }
    }

    public void act() {
        checkHit();
        if (hp <= 0) {
            gameOver();
        }
    }

    public void checkHit() {
        if (isTouching(bola_lendir.class)) {
            removeTouching(bola_lendir.class);
            hp--;
            darah.setHP(hp);
            Greenfoot.delay(10);
        }
    }

    public void updateHPDisplay() {
        System.out.println("HP Player: " + hp);
    }

    public void gameOver() {
    World world = getWorld();
    world.showText("Game Over", world.getWidth() / 2, world.getHeight() / 2);
    
    TombolUlang ulang = new TombolUlang();
    world.addObject(ulang, world.getWidth() / 2, world.getHeight() / 2 + 50);

    
}


    public int getHP() {
        return hp;
    }

    public void setHP(int newHP) {
        hp = newHP;
    }
    
    
}
