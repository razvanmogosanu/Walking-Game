package dev.game.tiles;

import dev.game.gfx.Assets;

public class WallMid extends Tile {


    WallMid(int id) {
        super(Assets.wallMid, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}