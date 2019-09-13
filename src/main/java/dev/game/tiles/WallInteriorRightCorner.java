package dev.game.tiles;

import dev.game.gfx.Assets;

public class WallInteriorRightCorner extends Tile {
    WallInteriorRightCorner(int id) {
        super(Assets.wallInteriorRightCorner, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
