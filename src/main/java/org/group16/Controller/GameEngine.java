package org.group16.Controller;

import java.awt.Graphics;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import org.group16.Model.GameObjects.GameState;
import org.group16.Model.Level.LevelHandler;
import org.group16.View.GameWindow;
import org.group16.View.LevelPanel;
import org.group16.View.StartPanel;

public class GameEngine {
    private GameWindow mainWindow;
    private Map<GameState, GameController> controllers = new HashMap<>();
    private GameController gameController;
    private LevelHandler levelHandler;
    // The delay (ms) corresponds to 60 updates a sec (hz) ?
    private final int delay = 1000/60;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener(this));
    

    public GameEngine(LevelHandler levelHandler, GameWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.levelHandler = levelHandler;

        // Initialize the controllers for each game state
        controllers.put(GameState.START, new StartController(levelHandler, mainWindow.getStartPanel()));
        controllers.put(GameState.PLAYING, new PlayerController(levelHandler, mainWindow.getLevelPanel(), mainWindow));
        controllers.put(GameState.PAUSED, new PauseController(levelHandler, mainWindow.getPausePanel()));
        controllers.put(GameState.LEVELSELECT, new LevelSelectController(levelHandler, mainWindow.getLevelSelectPanel()));

        // Set gameController to the controller for the initial game state
        gameController = controllers.get(levelHandler.getGameState());
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
        
        // Set gameController to the controller for the current game state
        gameController = controllers.get(levelHandler.getGameState());
        gameController.update();

        if(levelHandler.getGameState() == GameState.PLAYING){
            levelHandler.update();
        }
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