package dev.game.ui;

import dev.game.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UIImageButton extends UIObject {

    private BufferedImage[] images;
    private ClickListener clicker;
    private Handler handler;
    public UIImageButton(Handler handler, float x, float y, int width, int height, BufferedImage[] images, ClickListener clicker) {
        super(x, y, width, height);
        this.handler = handler;
        this.images = images;
        this.clicker = clicker;
    }

    @Override
    public void tick() {}

    @Override
    public void render(Graphics g) {
        if (handler.getGame().gameState == null && images.length > 2)
            g.drawImage(images[2] , (int) x, (int) y, width, height, null);
        else if(hovering){
            g.drawImage(images[1] , (int) x, (int) y, width, height, null);
        }
        else
            g.drawImage(images[0], (int) (x), (int) y, width, height, null);
    }

    @Override
    public void onClick() {
        clicker.onClick();
    }

}