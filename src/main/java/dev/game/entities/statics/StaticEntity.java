package dev.game.entities.statics;

import dev.game.Handler;
import dev.game.entities.Entity;

import java.awt.*;

public class StaticEntity extends Entity {
    public StaticEntity(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }
}
