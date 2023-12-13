package org.group16.Controller;

import org.group16.Model.GameHandling.GameHandler;
import org.group16.View.Panels.GamePanel;

abstract class GameController {
    private GamePanel gamePanel;
    private GameHandler gameHandler;

    GameController(GameHandler gameHandler, GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.gameHandler = gameHandler;
    }

    protected abstract void update();
    
    protected abstract void initListeners();
}
