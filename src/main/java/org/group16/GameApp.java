package org.group16;

import org.group16.Controller.GameEngine;
import org.group16.Controller.PlayerController;
import org.group16.View.GameWindow;

public class GameApp {
    public static void main(String[] args) {
        GameWindow mainWindow = new GameWindow("Projectgroup 16 game");

        GameEngine gameEngine = new GameEngine(mainWindow);
        // start the timer
        gameEngine.start();
        if(gameEngine.checkIfTimerRun()){
            System.out.println("timer on");
        }
    }
}