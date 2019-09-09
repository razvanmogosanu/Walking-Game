package dev.game.states;

import dev.game.Handler;
import dev.game.worlds.World;

import java.awt.*;

public class GameState extends State {

    private World world;

    GameState(Handler handler){
        super(handler);
        world = new World(handler, "worlds/world1.txt");
        handler.setWorld(world);
    }

    @Override
    public void tick() {
        world.tick();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
    }

}