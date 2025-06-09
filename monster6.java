import greenfoot.*;

public class monster6 extends Actor {
    private int darah = 3;
    private DarahMonster darahMonster;

    public monster6() {
        // constructor default
    }

    public monster6(DarahMonster darahMonster) {
        this.darahMonster = darahMonster;
        this.darahMonster.setHP(darah);
    }

    public void addedToWorld (World world) {
        if (darahMonster == null) {
            darahMonster = (DarahMonster) world.getObjects(DarahMonster.class).get(0);
            darahMonster.setHP(darah);
        }
    }

    public void act() {
        if (darah <= 0) {
            getWorld().removeObject(this);
        }
    }

    public void kurangiDarah(int jumlah) {
        darah -= jumlah;
        if (darahMonster != null) {
            darahMonster.setHP(darah);
        }
    }

    public int getDarah() {
        return darah;
    }
}
