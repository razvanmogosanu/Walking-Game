package dev.game.gfx;

import java.awt.image.BufferedImage;

public class Assets {
    public static BufferedImage floorTile,blankSpace ;
    public static BufferedImage wallMid, wallLeft, wallLeftCorner, wallTop, wallRight,
            wallBottomRightCorner, wallTopLeftCorner, wallTopRightCorner, wallInteriorLeftCorner,
            wallInteriorRightCorner;
    public static BufferedImage[] player_right, player_left, player_up, player_down;
    public static BufferedImage[] newGameBtn, resumeBtn, exitBtn, optionsBtn;
    public static BufferedImage background;
    public static BufferedImage NPC, NPC2;

    private static void setButtons() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/buttons.png"));

        int buttonX = 0, buttonY = 0, buttonWidth = 220, buttonWidthExtended = 229,
                buttonWidthCompacted = 152, buttonHeight = 72;

        newGameBtn = new BufferedImage[2];
        optionsBtn = new BufferedImage[2];
        exitBtn = new BufferedImage[2];
        resumeBtn = new BufferedImage[3];

        int it = 0;
        setFrames(newGameBtn, sheet, buttonX, buttonY, buttonWidthExtended, buttonHeight, false);
        it += newGameBtn.length;
        setFrames(optionsBtn, sheet, buttonX, buttonY + it*buttonHeight, buttonWidth, buttonHeight, false);
        it += optionsBtn.length;
        setFrames(resumeBtn, sheet, buttonX, buttonY + it*buttonHeight, buttonWidth, buttonHeight, false);
        it += resumeBtn.length;
        setFrames(exitBtn, sheet, buttonX, buttonY + it*buttonHeight, buttonWidthCompacted, buttonHeight, false);
    }

    private static void setFrames(BufferedImage []images, SpriteSheet spriteSheet, int playerX, int playerY, int width, int height, boolean XorY) {
        int i = 0, n = images.length;
        while (i++ < n)
            images[i - 1] = (XorY)
                    ? spriteSheet.crop(playerX + (i - 1) *width, playerY, width, height)
                    : spriteSheet.crop(playerX, playerY + (i - 1) *height, width, height);
    }

    private static void setPlayerMovements(SpriteSheet dungeonTileset) {
        int playerX = 128;
        int playerDownY = 135, playerUpY = 196, playerRightY = 107, playerLeftY = 168;
        int width = 16, height = 24;

        player_up =new BufferedImage[6];
        player_down = new BufferedImage[6];
        player_right = new BufferedImage[8];
        player_left = new BufferedImage[8];

        setFrames(player_up, dungeonTileset,playerX ,playerUpY, width, height,true );
        setFrames(player_down, dungeonTileset,playerX, playerDownY, width, height, true);
        setFrames(player_right, dungeonTileset,playerX, playerRightY, width, height, true);
        setFrames(player_left, dungeonTileset,playerX, playerLeftY, width, height, true);
    }

    public static void init(){
        SpriteSheet dungeonTileset = new SpriteSheet(ImageLoader.loadImage("/textures/dungeontileset.png"));
        background = ImageLoader.loadImage("/textures/background.jpg");
        setButtons();
                            /** IN GAME */

        floorTile = dungeonTileset.crop(32, 80,16,16);

        setPlayerMovements(dungeonTileset);

//        NPC = sheet.crop(2* width,4*height, width, height);
//        NPC2 = sheet.crop(width,5*height, width, height);

        int width = 16, height = 16;
        //WALLS
        wallMid = dungeonTileset.crop(17,12, width, height);
        wallLeft = dungeonTileset.crop(0,177, width, height);
        wallLeftCorner = dungeonTileset.crop(0,202, width, height);
        blankSpace = dungeonTileset.crop(0,420, width, height);
        wallTop = dungeonTileset.crop(65,161, width, height);
        wallRight = dungeonTileset.crop(12,185, width, height);
        wallBottomRightCorner = dungeonTileset.crop(39,202, width, height);
        wallTopLeftCorner = dungeonTileset.crop(0, 162, width, height);
        wallTopRightCorner = dungeonTileset.crop(39, 162, width, height);
        wallInteriorLeftCorner = dungeonTileset.crop(16, 496, width,height);
        wallInteriorRightCorner = dungeonTileset.crop(16 + width, 496, width, height);
    }
}