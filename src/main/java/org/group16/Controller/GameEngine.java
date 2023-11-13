package org.group16.Controller;

import java.awt.Graphics;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.group16.Model.Level.LevelHandler;
import org.group16.View.GamePanel;
import org.group16.View.GameWindow;
import  org.group16.View.Renderer;

public class GameEngine {
    private GameWindow mainWindow;
    private PlayerController playerController;
    private LevelHandler levelHandler;
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
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

    public boolean checkIfTimerRun(){
        return timer.isRunning();
    }
    // update stuff
    public void update() {
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
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
