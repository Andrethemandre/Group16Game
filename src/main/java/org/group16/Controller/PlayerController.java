package org.group16.Controller;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.GameState;
import org.group16.Model.GameObjects.Player.Player;
import org.group16.Model.Level.LevelHandler;
import org.group16.View.GameWindow;
import org.group16.View.Panels.LevelPanel;

class PlayerController extends GameController implements KeyListener{
    private LevelPanel levelPanel;
    private LevelHandler levelHandler;
    private Player currentPlayer;
    private GameWindow mainWindow;
    // flag to only allow one jump per keypress
    private boolean wKeyHeldDown = false;

    PlayerController(LevelHandler levelHandler, LevelPanel levelPanel, GameWindow mainWindow){
        super(levelHandler, levelPanel);
        this.levelHandler = levelHandler;
        this.levelPanel = levelPanel;
        this.currentPlayer = levelHandler.getPlayer();
        mainWindow.addKeyListener(this);

        levelPanel.getPauseButton().addActionListener(e -> {
            currentPlayer.startMovingInDirection(Direction.NONE);
            if(levelHandler.getGameState() == GameState.PLAYING){     
                levelHandler.togglePause();
            }
            mainWindow.requestFocusInWindow();
        });
    }

    public void update(){
        currentPlayer = levelHandler.getPlayer();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            // w for going up
            case KeyEvent.VK_W:  
                if(levelHandler.getGameState() == GameState.PLAYING){
                    if (!wKeyHeldDown && !currentPlayer.isFalling()) {
                    currentPlayer.startJumping();
                    wKeyHeldDown = true;
                    }
                }   
                break;

            // a for going left
            case KeyEvent.VK_A:

                if(levelHandler.getGameState() == GameState.PLAYING){
                    currentPlayer.startMovingInDirection(Direction.LEFT);
                }

                break;

            // s for going down
            case KeyEvent.VK_S: 
                break;

            // d for going right
            case KeyEvent.VK_D:

                if(levelHandler.getGameState() == GameState.PLAYING){
                    currentPlayer.startMovingInDirection(Direction.RIGHT);
                }
                break;

            case KeyEvent.VK_ESCAPE:
                currentPlayer.startMovingInDirection(Direction.NONE);
                if(levelHandler.getGameState() == GameState.PLAYING || levelHandler.getGameState() == GameState.PAUSED){       
                    levelHandler.togglePause();
                }
                break;
            
            //k to use power upp
            case KeyEvent.VK_K:
                if(levelHandler.getGameState() == GameState.PLAYING){
                    levelHandler.usePowerUp();
                }
                break;
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        if(levelHandler.getGameState() == GameState.PLAYING){
            switch (e.getKeyCode()) {
                case KeyEvent.VK_W:
                    wKeyHeldDown = false;
                    break;
                case KeyEvent.VK_A:
                    currentPlayer.stopMovingInDirection(Direction.LEFT);
                    break;
                case KeyEvent.VK_D:
                    currentPlayer.stopMovingInDirection(Direction.RIGHT);
                    break;
            }
        }
    }
}