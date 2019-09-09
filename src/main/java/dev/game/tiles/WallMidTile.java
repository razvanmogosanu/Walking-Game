package dev.game.tiles;

import dev.game.gfx.Assets;

public class WallMidTile extends Tile {


    WallMidTile(int id) {
        super(Assets.wallMid, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}