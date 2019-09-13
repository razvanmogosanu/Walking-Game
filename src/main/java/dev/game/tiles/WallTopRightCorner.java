package dev.game.tiles;

import dev.game.gfx.Assets;

public class WallTopRightCorner extends Tile {
    WallTopRightCorner(int id) {
        super(Assets.wallTopRightCorner, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
