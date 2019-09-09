package dev.game;

import java.awt.*;

public class Launcher {
    private static Toolkit tk = Toolkit.getDefaultToolkit();
    private final static int screenXSize = ((int) tk.getScreenSize().getWidth())
                            ,screenYSize = ((int) tk.getScreenSize().getHeight());

    public static void main(String[] args) {
        Game game = new Game("WalkingGame", screenXSize, screenYSize);
        game.start();
    }

    public static int getScreenXSize() {
        return screenXSize;
    }
    public static int getScreenYSize() {
        return screenYSize;
    }
}
