package dev.game.tiles;

import dev.game.gfx.Assets;

public class BlankSpace extends Tile {
    BlankSpace(int id) {
        super(Assets.blankSpace, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
