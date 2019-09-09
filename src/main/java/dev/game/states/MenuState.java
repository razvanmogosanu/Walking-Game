package dev.game.states;

import dev.game.Handler;
import dev.game.Launcher;
import dev.game.gfx.Assets;
import dev.game.ui.UIImageButton;
import dev.game.ui.UIManager;

import java.awt.*;

public class MenuState extends State {

    private UIManager uiManager;

    public UIManager getUiManager() {
        return uiManager;
    }

    public MenuState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUIManager(uiManager);

        /** START BUTTON */
        uiManager.addObject(new UIImageButton(Launcher.getScreenXSize() / 2 - 100, 300, 220, 80, Assets.playBtn, () -> {
            handler.getMouseManager().setUIManager(null);
            handler.getGame().gameState = new GameState(handler);
            State.setState(handler.getGame().gameState);
        }));

        /** RESUME BUTTON */
        uiManager.addObject(new UIImageButton(Launcher.getScreenXSize() / 2 - 100, 380, 220, 80, Assets.resumeBtn, () -> {
            if (handler.getGame().gameState == null) return;
            handler.getMouseManager().setUIManager(null);
            State.setState(handler.getGame().gameState);
        }));

        /** OPTIONS BUTTON */
        uiManager.addObject(new UIImageButton(Launcher.getScreenXSize() / 2 - 100, 460, 220, 80, Assets.optionsBtn, () -> {
            handler.getMouseManager().setUIManager(null);
            State.setState(new OptionsState(handler));
        }));

        /** EXIT BUTTON */
        uiManager.addObject(new UIImageButton(Launcher.getScreenXSize() / 2 - 80, 530, 220, 80, Assets.exitBtn, () -> System.exit(1)));
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
