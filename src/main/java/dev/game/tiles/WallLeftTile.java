package dev.game.tiles;


import dev.game.gfx.Assets;

public class WallLeftTile extends Tile {
    @Override
    public boolean isSolid() {
        return true;
    }

    WallLeftTile(int id) {
        super(Assets.wallLeft, id);
    }
}
