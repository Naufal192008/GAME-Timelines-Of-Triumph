import greenfoot.*;

public class LabelPoin extends Actor {
    public LabelPoin() {
        update();
    }

    public void update() {
        setImage(new GreenfootImage("Poin: " + GlobalData.poin, 30, Color.WHITE, new Color(0, 0, 0, 128)));
    }
}
