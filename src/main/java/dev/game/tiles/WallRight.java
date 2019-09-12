package dev.game.tiles;


import dev.game.gfx.Assets;

public class WallRight extends Tile {
    WallRight(int id) {
        super(Assets.wallRight,id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
