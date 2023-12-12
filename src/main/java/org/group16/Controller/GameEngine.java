package org.group16.Controller;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.group16.Model.GameObjects.GameState;
import org.group16.Model.LevelHandling.LevelHandler;
import org.group16.View.GameWindow;

public class GameEngine {
    private LevelHandler levelHandler;
    private GameControllerManager gameControllerManager;

    // The delay (ms) corresponds to 60 updates a sec (hz) ?
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.

    private final int delay = 1000/60;
    private Timer timer = new Timer(delay, new TimerListener(this));
    
    public GameEngine(LevelHandler levelHandler, GameWindow mainWindow) {
        this.levelHandler = levelHandler;
        this.gameControllerManager = new GameControllerManager(levelHandler, mainWindow);
    }

    public void update() {
        if(levelHandler.getGameState() == GameState.PAUSED){
            return;
        } 
        
        // Set gameController to the controller for the current game state
        gameControllerManager.updateGameController(levelHandler.getGameState());

        if(levelHandler.getGameState() == GameState.PLAYING){
            levelHandler.update();
        }

        levelHandler.notifyObservers();
    }

    public void start(){
        timer.start();
    }

    private class TimerListener implements ActionListener {
        private GameEngine engine;

        public TimerListener(GameEngine engine) {
            this.engine = engine;
        }

        public void actionPerformed(ActionEvent e){
            engine.update();
        }
    }
}