package dev.game.gfx;

import java.awt.image.BufferedImage;

public class Assets {
    public static BufferedImage dirt,grass,stone;
    public static BufferedImage wallMid, blankSpace, wallLeft, wallLeftCorner, topWall, rightWall, bottomRightCorner, topLeftCornerWall;
    public static BufferedImage[] player_stand, player_right, player_left, player_up, player_down;
    public static BufferedImage[] playBtn, resumeBtn, exitBtn, optionsBtn;
    public static BufferedImage background,background2;
    public static BufferedImage NPC, NPC2;
    private static final int width = 16, height = 16;
    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/images1.png"));
        SpriteSheet second = new SpriteSheet(ImageLoader.loadImage("/textures/dungeontileset.png"));

        //BACKGROUND
        background = ImageLoader.loadImage("/textures/background.jpg");
        background2 = ImageLoader.loadImage("/textures/background.jpg");

        //MENU

        playBtn = new BufferedImage[2];
        playBtn[0] = sheet.crop(0, 16, 229, 72);
        playBtn[1] = sheet.crop(0, 88, 229, 72);

        resumeBtn = new BufferedImage[3];
        resumeBtn[0] = sheet.crop(0, 304, 220, 72);
        resumeBtn[1] = sheet.crop(0, 376, 220, 72);
        resumeBtn[2] = sheet.crop(0, 520+72,229,72 );

        optionsBtn = new BufferedImage[2];
        optionsBtn[0] = sheet.crop(0, 160, 220, 72);
        optionsBtn[1] = sheet.crop(0, 232, 220, 72);

        exitBtn = new BufferedImage[2];
        exitBtn[0] = sheet.crop(0, 376+72, 152, 72);
        exitBtn[1] = sheet.crop(0, 520, 152, 72);
        //IN GAME

        //statics
        stone = sheet.crop(0,0,width,height);
        grass = second.crop(32, 80,16,16);
        dirt = grass;

        /* STAND */
        player_stand = new BufferedImage[2];
        player_stand[0] = second.crop(128,135, 16, 24);
        player_stand[1] = second.crop(128,135, 16, 24);

        /* UP */
        player_up = new BufferedImage[6];
        player_up[0] = second.crop(128,199, 16, 24);
        player_up[1] = second.crop(128 + 16,199, 16, 24);
        player_up[2] = second.crop(128 + 16 + 16,199, 16, 24);
        player_up[3] = second.crop(128 + 16 + 16 + 16,199, 16, 24);
        player_up[4] = second.crop(128 + 16 + 16 + 16,199, 16, 24);
        player_up[5] = second.crop(128 + 16 + 16 + 16 + 16 ,199, 16, 24);

        /* DOWN */
        player_down = new BufferedImage[6];
        player_down[0] = second.crop(128,135, 16, 24);
        player_down[1] = second.crop(128 + 16,135, 16, 24);
        player_down[2] = second.crop(128 + 16 + 16,135, 16, 24);
        player_down[3] = second.crop(128 + 16 + 16 + 16,135, 16, 24);
        player_down[4] = second.crop(128 + 16 + 16 + 16,135, 16, 24);
        player_down[5] = second.crop(128 + 16 + 16 + 16 + 16 ,135, 16, 24);

        /* RIGHT */
        player_right = new BufferedImage[8];
        player_right[0] = second.crop(128,101,16,27);
        player_right[1] = second.crop(128 + 16,101, 16,27);
        player_right[2] = second.crop(128 + 16 + 16,101,16,27);
        player_right[3] = second.crop(128 + 16 + 16 + 16,101,16,27);
        player_right[4] = second.crop(128 + 16 + 16 + 16 + 16,101,16,27);
        player_right[5] = second.crop(128 + 16 + 16 + 16 + 16 + 16,101,16,27);
        player_right[6] = second.crop(128 + 16 + 16 + 16 + 16 + 16 + 16,101,16,27);
        player_right[7] = second.crop(128 + 16 + 16 + 16 + 16 + 16 + 16 + 16,101,16,27);

        /* LEFT */
        player_left = new BufferedImage[8];
        player_left[0] = second.crop(128,163,16,27);
        player_left[1] = second.crop(128 + 16,163, 16,27);
        player_left[2] = second.crop(128 + 16 + 16,163,16,27);
        player_left[3] = second.crop(128 + 16 + 16 + 16,163,16,27);
        player_left[4] = second.crop(128 + 16 + 16 + 16 + 16,163,16,27);
        player_left[5] = second.crop(128 + 16 + 16 + 16 + 16 + 16,163,16,27);
        player_left[6] = second.crop(128 + 16 + 16 + 16 + 16 + 16 + 16,163,16,27);
        player_left[7] = second.crop(128 + 16 + 16 + 16 + 16 + 16 + 16 + 16,163,16,27);


//        NPC = sheet.crop(2* width,4*height, width, height);
//        NPC2 = sheet.crop(width,5*height, width, height);

        //WALLS
        wallMid = second.crop(17,12,16,16);
        wallLeft = second.crop(0,185,16,16);
        wallLeftCorner = second.crop(0,202,16,16);
        blankSpace = second.crop(0,420, 16,16);
        topWall = second.crop(65,161,16, 16);
        rightWall = second.crop(12,185,16,16);
        bottomRightCorner = second.crop(39,202,16,16);
        topLeftCornerWall = second.crop(12, 162, 16, 16);
    }


}
