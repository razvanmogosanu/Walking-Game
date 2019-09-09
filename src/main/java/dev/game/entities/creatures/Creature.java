package dev.game.entities.creatures;

import dev.game.Handler;
import dev.game.entities.Entity;
import dev.game.tiles.Tile;

public abstract class Creature extends Entity {

    protected static final int DEFAULT_HEALTH = 10;
    protected static final float DEFAULT_SPEED = 3.0f;
    protected static final int DEFAULT_CREATURE_WIDTH = 64,
            DEFAULT_CREATURE_HEIGHT = 64;

    protected int health;
    protected float speed;
    protected float xMove, yMove;

    Creature(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        health = DEFAULT_HEALTH;
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }

    void move() {
        if (!checkEntityCollisions(xMove, 0f))
            moveX();
        if (!checkEntityCollisions(0f, yMove))
            moveY();
    }

    private void moveX() {
        /**Moving right */
        if (xMove > 0) {
            int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;

            if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
                    !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
                x += xMove;
            } else
                x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
        }
        /**Moving left */
        else if (xMove < 0) {
            int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;

            if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
                    !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
                x += xMove;
            } else
                x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
        }
    }

    public void moveY() {
        /**Moving up */
        if (yMove < 0) {
            int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;

            if (!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
                    !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
                y += yMove;
            } else
                y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
        }
        /**Moving down */
        else if (yMove > 0) {
            int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;

            if (!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
                    !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
                y += yMove;
            } else
                y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
        }
    }

    private boolean collisionWithTile(int x, int y) {
        return handler.getWorld().getTile(x, y).isSolid();
    }
}