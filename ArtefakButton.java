import greenfoot.*;

public class ArtefakButton extends Actor {
    private final String nama;
    private final GreenfootImage imageAsli;
    private final GreenfootImage imageCeklis;

    public ArtefakButton(String nama, String gambar) {
        if (nama == null || gambar == null) {
            throw new IllegalArgumentException("Nama dan gambar tidak boleh null");
        }
        
        this.nama = nama.trim().toLowerCase();
        this.imageAsli = new GreenfootImage(gambar);
        this.imageCeklis = new GreenfootImage("menu (27).png");
        updateGambar();
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            handleClick();
        }
    }

    private void handleClick() {
        if (GlobalData.beliArtefak(nama)) {
            onPembelianBerhasil();
        } else {
            Greenfoot.playSound("eror.mp3");
        }
    }

    private void onPembelianBerhasil() {
        updateGambar();
        Greenfoot.playSound("BELI (27).mp3");
        
        if (GlobalData.semuaArtefakDibeli()) {
            Greenfoot.delay(20);
            Greenfoot.setWorld(new Cara_win());
        }
    }

    private void updateGambar() {
        setImage(GlobalData.artefakDibeli.contains(nama) ? imageCeklis : imageAsli);
    }
}