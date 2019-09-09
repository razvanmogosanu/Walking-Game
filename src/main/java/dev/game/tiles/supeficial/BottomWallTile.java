package dev.game.tiles.supeficial;

import dev.game.Handler;
import dev.game.entities.statics.StaticEntity;
import dev.game.gfx.Assets;
import dev.game.tiles.Tile;

import java.awt.*;

public class BottomWallTile extends StaticEntity {
    public BottomWallTile(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT + Tile.TILEHEIGHT / 4);

        bounds.x = 20;
        bounds.y = (int) (height / 1.5f);
        bounds.width = width - 40;
        bounds.height = (int) (height - height / 1.5f);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.wallMid, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }
}
