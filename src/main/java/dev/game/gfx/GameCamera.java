package dev.game.gfx;

import dev.game.Handler;
import dev.game.entities.Entity;

public class GameCamera {
    private Handler handler;
    private float xOffset, yOffset;


    public GameCamera(Handler handler, float xOffset, float yOffset) {
        this.handler = handler;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public void centerOnEntity(Entity entity) {
        xOffset = entity.getX() - handler.getWidth() / 2 + (entity.getWidth() >> 1);
        yOffset = entity.getY() - handler.getHeight() / 2 + (entity.getHeight() >> 1);
//        checkBlankSpace();
    }

//    private void checkBlankSpace() {
//        if (xOffset < 0) {
//            xOffset = 0;
//        } else if (xOffset > handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth())
//            xOffset = handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth();
//
//        if (yOffset < 0) {
//            yOffset = 0;
//        } else if (yOffset > handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight()) {
//            yOffset = handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight();
//        }
//    }

    public float getxOffset() {
        return xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }
}