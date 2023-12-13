package org.group16.Controller;

import org.group16.Model.LevelHandling.LevelHandler;
import org.group16.View.Panels.GamePanel;

abstract class GameController {
    private GamePanel gamePanel;
    private LevelHandler levelHandler;

    GameController(LevelHandler levelHandler, GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.levelHandler = levelHandler;
    }

    protected abstract void update();
}
