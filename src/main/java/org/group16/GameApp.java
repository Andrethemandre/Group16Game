package org.group16;

import org.group16.Controller.GameEngine;
import org.group16.Controller.PlayerController;
import org.group16.Model.Level.LevelHandler;
import org.group16.View.GameWindow;

public class GameApp {
    public static void main(String[] args) {
        LevelHandler levelHandler = new LevelHandler();
        GameWindow mainWindow = new GameWindow("Projectgroup 16 game", levelHandler);
        levelHandler.addObserver(mainWindow);

        GameEngine gameEngine = new GameEngine(levelHandler, mainWindow);
        
        // start the timer
        gameEngine.start();

    }
}