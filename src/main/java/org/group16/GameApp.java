package org.group16;

import org.group16.Controller.GameControllerManager;
import org.group16.Model.GameHandling.GameHandler;
import org.group16.View.GameWindow;

public class GameApp {
    public static void main(String[] args) {
        // Setup model
        GameHandler gameHandler = new GameHandler();

        // Setup view
        GameWindow mainWindow = new GameWindow("King Blöb's Adventure", gameHandler);
        gameHandler.addObserver(mainWindow);

        // Setup controller
        GameControllerManager gameControllerManager = new GameControllerManager(gameHandler, mainWindow);
        gameHandler.addObserver(gameControllerManager);
    }
}