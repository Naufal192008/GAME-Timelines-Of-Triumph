import greenfoot.*;

public class TombolNext extends Actor {
    public TombolNext() {
        setImage("CEKLIS (11).png"); // Ganti dengan gambar tombolmu
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new halaman_LEVEL2());
        }
    }
}
