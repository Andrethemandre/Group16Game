package org.group16;

import org.group16.Controller.GameControllerManager;
import org.group16.Model.LevelHandling.LevelHandler;
import org.group16.View.GameWindow;

public class GameApp {
    public static void main(String[] args) {
        // Setup model
        LevelHandler levelHandler = new LevelHandler();

        // Setup view
        GameWindow mainWindow = new GameWindow("King Blöb's Adventure", levelHandler);
        levelHandler.addObserver(mainWindow);

        // Setup controller
        GameControllerManager gameControllerManager = new GameControllerManager(levelHandler, mainWindow);
        levelHandler.addObserver(gameControllerManager);
    }
}