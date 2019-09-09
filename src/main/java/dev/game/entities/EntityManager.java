package dev.game.entities;

import dev.game.Handler;
import dev.game.entities.creatures.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class EntityManager {

    private Handler handler;
    private Player player;
    private ArrayList<Entity> entities;

    @SuppressWarnings("ComparatorMethodParameterNotUsed")
    private Comparator<Entity> renderSorter = (a, b) -> (a.getY() + a.getHeight() < b.getY() + b.getHeight()) ? -1 : 1;

    public EntityManager(Handler handler, Player player) {
        this.handler = handler;
        this.player = player;
        entities = new ArrayList<>();
        addEntity(player);
    }

    public void tick() {
        for (Entity e : entities) {
            e.tick();
        }
        entities.sort(renderSorter);
    }

    public void render(Graphics g) {
        for (Entity e : entities) {
            e.render(g);
        }
    }

    private void addEntity(Entity e) {
        entities.add(e);
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }
}