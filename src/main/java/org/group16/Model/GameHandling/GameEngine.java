package org.group16.Model.GameHandling;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.group16.Model.GameObjects.GameState;

public class GameEngine {
    private GameHandler gameHandler;
    // The delay (ms) corresponds to 60 updates a sec (hz) ?
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.

    private final int delay = 1000/60;
    private Timer timer = new Timer(delay, new TimerListener(this));
    
    public GameEngine(GameHandler gameHandler) {
        this.gameHandler = gameHandler;
    }

    public void update() {
        if(gameHandler.getGameState() == GameState.PAUSED){
            return;
        } 

        if(gameHandler.getGameState() == GameState.PLAYING){
            gameHandler.update();
        }

        gameHandler.notifyObservers();
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