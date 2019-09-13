package dev.game.tiles;

import dev.game.gfx.Assets;

public class WallBottomLeftCorner extends Tile {
    WallBottomLeftCorner(int id) {
        super(Assets.wallLeftCorner, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
