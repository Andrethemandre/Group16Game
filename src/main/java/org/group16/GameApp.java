package org.group16;

import org.group16.Controller.GameEngine;
import org.group16.Model.Level.LevelHandler;
import org.group16.View.GameWindow;

public class GameApp {
    public static void main(String[] args) {
        // Setup model
        LevelHandler levelHandler = new LevelHandler();

        // Setup view
        GameWindow mainWindow = new GameWindow("Projectgroup 16 game", levelHandler);
        levelHandler.addObserver(mainWindow);

        // Setup controller
        GameEngine gameEngine = new GameEngine(levelHandler, mainWindow);
        
        // Start the timer
        gameEngine.start();
    }
}