package org.group16.Controller;

import java.util.HashMap;
import java.util.Map;

import org.group16.Model.GameObjects.GameState;
import org.group16.Model.LevelHandling.LevelHandler;
import org.group16.Model.Observers.GameObserver;
import org.group16.View.GameWindow;

public class GameControllerManager implements GameObserver {
    private LevelHandler levelHandler;
    private Map<GameState, GameController> controllers;
    private GameController gameController;

    public GameControllerManager(LevelHandler levelHandler, GameWindow mainWindow) {
        this.levelHandler = levelHandler;
        this.controllers = new HashMap<>();

        // Initialize the controllers for each game state
        controllers.put(GameState.START, new StartController(levelHandler, mainWindow.getStartPanel()));
        controllers.put(GameState.PLAYING, new PlayerController(levelHandler, mainWindow.getLevelPanel(), mainWindow));
        controllers.put(GameState.PAUSED, new PauseController(levelHandler, mainWindow.getPausePanel()));
        controllers.put(GameState.LEVEL_SELECT, new LevelSelectController(levelHandler, mainWindow.getLevelSelectPanel()));

        // Set gameController to the controller for the initial game state
        this.gameController = controllers.get(levelHandler.getGameState());
    }

    void updateGameController(GameState gameState) {
        gameController = controllers.get(gameState);
        gameController.update();
    }

    @Override
    public void updateObserver() {
        updateGameController(levelHandler.getGameState());
    }
}
