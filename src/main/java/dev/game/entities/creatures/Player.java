package dev.game.entities.creatures;

import dev.game.Handler;
import dev.game.gfx.Animation;
import dev.game.gfx.Assets;
import dev.game.states.MenuState;
import dev.game.states.State;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature {
    private Animation animRight, animUp, animDown, animLeft, animStand;
    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

        bounds.x = 5;
        bounds.y = 32;
        bounds.width = 32;
        bounds.height = 32;

        //Animations
        animRight = new Animation(125, Assets.player_right);
        animUp = new Animation(125, Assets.player_up);
        animDown = new Animation(125, Assets.player_down);
        animLeft = new Animation(125, Assets.player_left);
        animStand = new Animation(750, Assets.player_stand);
    }
    @Override
    public void tick() {
        //Animations
        animRight.tick();
        animUp.tick();
        animDown.tick();
        animLeft.tick();
        animStand.tick();
        // Movement
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
    }

    private void getInput(){
        xMove = 0;
        yMove = 0;
        if(handler.getKeyManager().up || handler.getKeyManager().aUp)
            yMove = - speed;
        if(handler.getKeyManager().down || handler.getKeyManager().aDown)
            yMove = speed;
        if(handler.getKeyManager().right || handler.getKeyManager().aRight)
            xMove = speed;
        if(handler.getKeyManager().left || handler.getKeyManager().aLeft)
            xMove = - speed;
        if(handler.getKeyManager().esc) {
            State.setState(new MenuState(handler));
            //TODO try to use the old menustate object
            }
    }

    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(),(int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), 40, 64, null);
    }

    private int lastFrame = 0;
    private BufferedImage getCurrentAnimationFrame(){
        int UP = 1, DOWN = 2, RIGHT = 3, LEFT = 4;
        if(yMove < 0) {
            lastFrame = UP;
            return animUp.getCurrentFrame();
        }
        if(yMove > 0){
            lastFrame = DOWN;
            return animDown.getCurrentFrame();
        }
        if(xMove > 0) {
            lastFrame = RIGHT;
            return animRight.getCurrentFrame();
        }
        if(xMove < 0) {
            lastFrame = LEFT;
            return animLeft.getCurrentFrame();
        }

        if(lastFrame == 1) return animUp.getLastDirection();
        if(lastFrame == 2) return animDown.getLastDirection();
        if(lastFrame == 3) return animRight.getLastDirection();
        if(lastFrame == 4) return animLeft.getLastDirection();

        return animStand.getCurrentFrame();
    }
}
