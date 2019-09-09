package dev.game.tiles;


import dev.game.gfx.Assets;

public class BottomRightWallCornerTile extends Tile {
    @Override
    public boolean isSolid() {
        return true;
    }

    BottomRightWallCornerTile(int id) {
        super(Assets.bottomRightCorner, id);
    }
}
