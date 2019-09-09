package dev.game;

import dev.game.audio.Sound;
import dev.game.display.Display;
import dev.game.gfx.Assets;
import dev.game.gfx.GameCamera;
import dev.game.input.MouseManager;
import dev.game.states.GameState;
import dev.game.states.MenuState;
import dev.game.states.State;
import dev.game.input.KeyManager;
import dev.game.ui.UIManager;

import javax.sound.sampled.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.net.URL;

public class Game implements Runnable {
    private Display display;

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }

    private int width, height;
    private String title;

    private Thread thread;
    private boolean running = false;

    private BufferStrategy bs;
    private Graphics g;

    //STATES
    public GameState gameState;
    private MenuState menuState;

    //INPUT
    private KeyManager keyManager;
    private MouseManager mouseManager;

    //Camera

    private GameCamera gameCamera;
    //HANDLER

    private Handler handler;
    Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
        Sound sound = new Sound();
    }

    private void init() throws InterruptedException {
        Assets.init();

        Thread.sleep(100);
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);

        handler = new Handler(this);
        gameCamera = new GameCamera(handler, 0,0);

        menuState = new MenuState(handler);
        State.setState(menuState);
    }

    private void tick() {
        keyManager.tick();

        if(State.getCurrentState() != null){
            State.getCurrentState().tick();
        }
    }

    public void run(){
        try {
            init();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int fps = 60;
                double timePerTick = 1000000000 / fps;
                double delta = 0;
                long now;
                long lastTime = System.nanoTime();
                long timer = 0;
                int ticks = 0;

                while(running){
                    now = System.nanoTime();
                    delta += (now - lastTime) / timePerTick;
                    timer += now - lastTime;
                    lastTime = now;

                    if(delta >= 1){
                        tick();
                        render();
                        ticks++;
                        delta--;
                    }

            if(timer >= 1000000000){
                System.out.println("FPS: " + ticks);

                ticks = 0;
                timer = 0;
            }
        }

        stop();
    }

    public void render() {
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();

        g.clearRect(0,0, width, height);

        if (State.getCurrentState() != null)
            State.getCurrentState().render(g);

        bs.show();
        g.dispose();
    }

    synchronized void start(){
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    private synchronized void stop(){
        if(!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setMouseManager(MouseManager mouseManager) {
        this.mouseManager = mouseManager;
    }

    public MouseManager getMouseManager(){return mouseManager;}

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public GameCamera getGameCamera(){
        return gameCamera;
    }

    public MenuState getMenuState() {
        return menuState;
    }

    public UIManager getUiManager(){
        return menuState.getUiManager();
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public Graphics getG() {
        return g;
    }
}
