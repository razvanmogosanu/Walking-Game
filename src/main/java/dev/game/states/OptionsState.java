package dev.game.states;

import dev.game.Handler;
import dev.game.Launcher;
import dev.game.gfx.Assets;
import dev.game.ui.UIImageButton;
import dev.game.ui.UIManager;

import java.awt.*;

public class OptionsState extends State {
    private UIManager uiManager;

    OptionsState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUIManager(uiManager);


        uiManager.addObject(new UIImageButton(handler,435, 250, 160, 68, Assets.resumeBtn, () -> {
            handler.getMouseManager().setUIManager(null);
            State.setState(new MenuState(handler));
        }));
    }

    @Override
    public void tick() {
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.background, 0, 0, Launcher.getScreenXSize(), Launcher.getScreenYSize(), null);
        uiManager.render(g);
    }

}
