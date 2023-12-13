package org.group16.Controller;

import java.util.HashMap;
import java.util.Map;

import org.group16.Model.GameHandling.GameHandler;
import org.group16.Model.GameObjects.GameState;
import org.group16.Model.Observers.GameObserver;
import org.group16.View.GameWindow;

public class GameControllerManager implements GameObserver {
    private GameHandler gameHandler;
    private Map<GameState, GameController> controllers;
    private GameController gameController;

    public GameControllerManager(GameHandler gameHandler, GameWindow mainWindow) {
        this.gameHandler = gameHandler;
        this.controllers = new HashMap<>();

        // Initialize the controllers for each game state
        controllers.put(GameState.START, new StartController(gameHandler, mainWindow.getStartPanel()));
        controllers.put(GameState.PLAYING, new PlayerController(gameHandler, mainWindow.getLevelPanel(), mainWindow));
        controllers.put(GameState.PAUSED, new PauseController(gameHandler, mainWindow.getPausePanel()));
        controllers.put(GameState.LEVEL_SELECT, new LevelSelectController(gameHandler, mainWindow.getLevelSelectPanel()));

        // Set gameController to the controller for the initial game state
        this.gameController = controllers.get(gameHandler.getGameState());
    }

    void updateGameController(GameState gameState) {
        gameController = controllers.get(gameState);
        gameController.update();
    }

    @Override
    public void updateObserver() {
        updateGameController(gameHandler.getGameState());
    }
}
