package org.group16.Controller;

import java.util.HashMap;
import java.util.Map;

import org.group16.Model.GameObjects.GameState;
import org.group16.Model.Level.LevelHandler;
import org.group16.View.GameWindow;

public class GameControllerManager {
    private Map<GameState, GameController> controllers;
    private GameController gameController;

    public GameControllerManager(LevelHandler levelHandler, GameWindow mainWindow) {
        controllers = new HashMap<>();

        // Initialize the controllers for each game state
        controllers.put(GameState.START, new StartController(levelHandler, mainWindow.getStartPanel()));
        controllers.put(GameState.PLAYING, new PlayerController(levelHandler, mainWindow.getLevelPanel(), mainWindow));
        controllers.put(GameState.PAUSED, new PauseController(levelHandler, mainWindow.getPausePanel()));
        controllers.put(GameState.LEVEL_SELECT, new LevelSelectController(levelHandler, mainWindow.getLevelSelectPanel()));

        // Set gameController to the controller for the initial game state
        gameController = controllers.get(levelHandler.getGameState());
    }

    public void updateGameController(GameState gameState) {
        gameController = controllers.get(gameState);
        gameController.update();
    }
}
