package dev.game.tiles;

import dev.game.gfx.Assets;

public class TopWallTile extends Tile {
    TopWallTile(int id) {
        super(Assets.topWall, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
