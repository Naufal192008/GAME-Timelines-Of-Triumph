import greenfoot.*;

public class keris extends Actor {
    private boolean sudahDibeli;

    public void act() {
        if (!sudahDibeli && Greenfoot.mouseClicked(this)) {
            if (GlobalData.poin >= 98) {
                GlobalData.poin -= 98;
                GlobalData.artefakDibeli.add("keris");
                FileManager.simpanData();
                sudahDibeli = true;
                setImage("CEKLIS (2).png"); // ganti tampilan
                Greenfoot.playSound("buy.mp3");
                System.out.println("Keris dibeli!");
            } else {
                Greenfoot.playSound("not-enough.mp3");
                System.out.println("Poin tidak cukup");
            }
        }
    }

    public void addedToWorld(World w) {
        if (GlobalData.artefakDibeli.contains("keris")) {
            sudahDibeli = true;
            setImage("CEKLIS (2).png");
        }
    }
}
