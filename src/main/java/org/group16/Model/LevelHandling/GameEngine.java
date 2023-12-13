package org.group16.Model.LevelHandling;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.group16.Model.GameObjects.GameState;

public class GameEngine {
    private LevelHandler levelHandler;
    // The delay (ms) corresponds to 60 updates a sec (hz) ?
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.

    private final int delay = 1000/60;
    private Timer timer = new Timer(delay, new TimerListener(this));
    
    public GameEngine(LevelHandler levelHandler) {
        this.levelHandler = levelHandler;
    }

    public void update() {
        if(levelHandler.getGameState() == GameState.PAUSED){
            return;
        } 

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