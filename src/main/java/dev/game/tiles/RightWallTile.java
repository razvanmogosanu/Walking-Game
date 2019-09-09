package dev.game.tiles;


import dev.game.gfx.Assets;

public class RightWallTile extends Tile {
    RightWallTile(int id) {
        super(Assets.rightWall,id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
