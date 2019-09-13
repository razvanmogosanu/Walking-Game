package dev.game.tiles;

import dev.game.gfx.Assets;

public class WallTopLeftCorner extends Tile {
    WallTopLeftCorner(int id) {
        super(Assets.wallTopLeftCorner, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
