package dev.game.tiles;

import dev.game.gfx.Assets;

public class WallLeftCorner extends Tile {
    WallLeftCorner(int id) {
        super(Assets.wallLeftCorner, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
