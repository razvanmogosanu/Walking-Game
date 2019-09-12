package dev.game.tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {
    public static Tile[] tiles = new Tile[256];
    public static Tile blankSpace = new BlankSpace(0);
    public static Tile basicFloor = new BasicFloor(1);
    public static Tile wallMid = new WallMid(2);
    public static Tile wallLeft = new WallLeft(3);
    public static Tile wallRight = new WallRight(4);
    public static Tile wallBottomLeftCorner = new WallBottomLeftCorner(5);
    public static Tile wallBottomRightCorner = new WallBottomRightCorner(6);
    public static Tile wallTopLeftCorner = new WallTopLeftCorner(7);
    public static Tile wallTopRightCorner = new WallTopRightCorner(8);

    public static final int TILEWIDTH = 48, TILEHEIGHT = 48;

    private BufferedImage texture;
    private final int id;
    Tile(BufferedImage texture, int id) {
        this.texture = texture;
        this.id = id;

        tiles[id] = this;
    }

    public void tick(){

    }

    public void render(Graphics g, int x, int y){
        g.drawImage(texture, x, y,TILEWIDTH, TILEHEIGHT, null);
    }
    public boolean isSolid(){
        return false;
    }
}
