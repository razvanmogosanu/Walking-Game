package dev.game.tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {
    //STATIC STUFFS HERE
    public static Tile[] tiles = new Tile[256];
    public static Tile blankSpace = new BlankSpaceTile(0);
    public static Tile grassTile = new GrassTile(1);
    public static Tile dirtTile = new DirtTile(2);
    public static Tile rockTile = new RockTile(3);
    public static Tile wallMidTile = new WallMidTile(4);
    public static Tile wallLeft = new WallLeftTile(5);
    public static Tile wallLeftCorner = new WallLeftCorner(6);
    public static Tile topWall = new TopWallTile(7);
    public static Tile rightWall = new RightWallTile(8);
    public static Tile bottomRigihtCornerWall = new BottomRightWallCornerTile(9);
    public static Tile topLeftCornerWall = new TopLeftCornerWall(10);
    //class

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
    public int getId() {
        return id;
    }
    public boolean isSolid(){
        return false;
    }
}
