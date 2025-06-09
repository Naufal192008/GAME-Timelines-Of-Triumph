import greenfoot.*;

public class BGMPlayer {
    private static GreenfootSound bgm = new GreenfootSound("GAME.mp3"); // Ganti sesuai file kamu
    private static boolean isPlaying = false;

    public static void playLoop() {
        if (!isPlaying) {
            bgm.setVolume(100); // Atur volume
            bgm.playLoop();
            isPlaying = true;
        }
    }

    public static void stop() {
        bgm.stop();
        isPlaying = false;
    }

    public static void pause() {
        bgm.pause();
    }

    public static void resume() {
        if (isPlaying) {
            bgm.playLoop();
        }
    }
}
