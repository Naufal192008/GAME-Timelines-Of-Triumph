import greenfoot.*;

public class TextInput extends Actor {
    private String input = "";

    public TextInput() {
        updateImage();
    }

    public void act() {
        String key = Greenfoot.getKey();
        if (key != null) {
            if (key.equals("backspace") && input.length() > 0) {
                input = input.substring(0, input.length() - 1);
            } else if (key.equals("enter")) {
                // biarkan kosong, pemrosesan dilakukan di world
            } else if (key.equals("space")) {
                input += " "; // tambahkan spasi asli
            } else if (key.length() == 1) {
                input += key;
            }
            updateImage();
        }
    }

    private void updateImage() {
        GreenfootImage img = new GreenfootImage("Jawaban: " + input, 24, Color.WHITE, new Color(0, 0, 0, 160));
        setImage(img);
    }

    public String getInput() {
        return input;
    }

    public void clearInput() {
        input = "";
        updateImage();
    }
}
