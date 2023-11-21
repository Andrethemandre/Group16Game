package org.group16.Controller;

import java.awt.Graphics;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.group16.Model.GameObjects.GameState;
import org.group16.Model.Level.LevelHandler;
import org.group16.View.GamePanel;
import org.group16.View.GameWindow;

public class GameEngine {
    private GameWindow mainWindow;
    private PlayerController playerController;
    private LevelHandler levelHandler;
    // The delay (ms) corresponds to 60 updates a sec (hz) ?
    private final int delay = 1000/60;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener(this));
    

    public GameEngine(LevelHandler levelHandler, GameWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.levelHandler = levelHandler;
        this.playerController = new PlayerController(levelHandler, mainWindow);
    }

    // start timer
    public void start(){
        timer.start();
    }

    // update stuff
    public void update() {
        if(levelHandler.getPauseState() == GameState.PAUSED){
            return;
        }
      
        playerController.update();
        levelHandler.update();
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
