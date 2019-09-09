package dev.game.states;

import dev.game.Game;
import dev.game.Handler;

import java.awt.*;

public abstract class State {
    private static State currentState = null;

    public abstract void tick();

    public abstract void render(Graphics g);

    protected Game game;
    protected Handler handler;

    public State(Handler handler) {
        this.handler = handler;
    }

    public static State getCurrentState() {
        return currentState;
    }

    public static void setState(State state) {
        currentState = state;
    }


}
