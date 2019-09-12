package dev.game.tiles;


import dev.game.gfx.Assets;

public class WallLeft extends Tile {
    @Override
    public boolean isSolid() {
        return true;
    }

    WallLeft(int id) {
        super(Assets.wallLeft, id);
    }
}
