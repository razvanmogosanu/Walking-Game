package dev.game.tiles;


import dev.game.gfx.Assets;

public class WallBottomRightCorner extends Tile {
    @Override
    public boolean isSolid() {
        return true;
    }

    WallBottomRightCorner(int id) {
        super(Assets.wallBottomRightCorner, id);
    }
}
