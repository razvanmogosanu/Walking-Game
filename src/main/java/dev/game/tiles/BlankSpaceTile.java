package dev.game.tiles;

import dev.game.gfx.Assets;

public class BlankSpaceTile extends Tile {
    BlankSpaceTile(int id) {
        super(Assets.blankSpace, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
