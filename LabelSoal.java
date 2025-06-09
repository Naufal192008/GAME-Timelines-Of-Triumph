import greenfoot.*;
import java.util.ArrayList;

public class LabelSoal extends Actor {
    private static final int MAX_WIDTH = 300;
    private static final int FONT_SIZE = 24;

    public LabelSoal(String text) {
        GreenfootImage image = buatGambarMultiline(text);
        setImage(image);
    }

    private GreenfootImage buatGambarMultiline(String text) {
        Font font = new Font("Arial", true, false, FONT_SIZE);

        String[] words = text.split(" ");
        ArrayList<String> lines = new ArrayList<>();
        String currentLine = "";

        for (String word : words) {
            String testLine = currentLine.isEmpty() ? word : currentLine + " " + word;
            GreenfootImage testImage = new GreenfootImage(testLine, FONT_SIZE, Color.WHITE, new greenfoot.Color(0, 0, 0, 0));
            if (testImage.getWidth() > MAX_WIDTH) {
                lines.add(currentLine);
                currentLine = word;
            } else {
                currentLine = testLine;
            }
        }
        lines.add(currentLine); // baris terakhir

        int lineHeight = new GreenfootImage("A", FONT_SIZE, Color.WHITE, new greenfoot.Color(0, 0, 0, 0)).getHeight();
        GreenfootImage image = new GreenfootImage(MAX_WIDTH, lineHeight * lines.size());
        image.setColor(new greenfoot.Color(0, 0, 0, 160)); // background transparan
        image.fill();

        for (int i = 0; i < lines.size(); i++) {
            GreenfootImage lineImage = new GreenfootImage(lines.get(i), FONT_SIZE, Color.WHITE, new greenfoot.Color(0, 0, 0, 0));
            image.drawImage(lineImage, 10, i * lineHeight);
        }

        return image;
    }
}
