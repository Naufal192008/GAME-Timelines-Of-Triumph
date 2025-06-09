import greenfoot.*;

public class TombolUlang extends Actor {
    public TombolUlang() {
        setImage("CEKLIS (10).png");
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new halaman_LEVEL1());
        }
    }
}
