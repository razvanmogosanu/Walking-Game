package dev.game.tiles;

import dev.game.gfx.Assets;

public class WallInteriorLeftCorner extends Tile {
    WallInteriorLeftCorner(int id) {
        super(Assets.wallInteriorLeftCorner, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}