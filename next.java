import greenfoot.*;

public class next extends Actor {
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            World w = getWorld();
            if (w instanceof halaman_LEVEL1) {
                Greenfoot.setWorld(new halaman_LEVEL2());
            } else if (w instanceof halaman_LEVEL2) {
                Greenfoot.setWorld(new halaman_LEVEL3());
            } else if (w instanceof halaman_LEVEL3) {
                // jika ada level 4, lanjutkan di sini
                Greenfoot.setWorld(new halaman_LEVEL4());
            }
        }
    }
}

