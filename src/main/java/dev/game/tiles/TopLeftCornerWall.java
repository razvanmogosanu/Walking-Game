package dev.game.tiles;

import dev.game.gfx.Assets;

public class TopLeftCornerWall extends Tile {
    @Override
    public boolean isSolid() {
        return true;
    }

    TopLeftCornerWall( int id) {
        super(Assets.topLeftCornerWall, id);
    }
}
