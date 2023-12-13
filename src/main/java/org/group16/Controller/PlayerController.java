package org.group16.Controller;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import org.group16.Model.GameHandling.GameHandler;
import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.GameState;
import org.group16.Model.GameObjects.Player.IPlayer;
import org.group16.View.GameWindow;
import org.group16.View.Panels.LevelPanel;

class PlayerController extends GameController implements KeyListener{
    private LevelPanel levelPanel;
    private GameHandler gameHandler;
    private IPlayer currentPlayer;
    private GameWindow mainWindow;
    // flag to only allow one jump per keypress
    private boolean wKeyHeldDown = false;

    PlayerController(GameHandler gameHandler, LevelPanel levelPanel, GameWindow mainWindow){
        super(gameHandler, levelPanel);
        this.gameHandler = gameHandler;
        this.levelPanel = levelPanel;
        this.mainWindow = mainWindow;
        this.currentPlayer = gameHandler.getPlayer();

        mainWindow.addKeyListener(this);
        initListeners();
    }

    @Override
    protected void initListeners(){
        levelPanel.getPauseButton().addActionListener(e -> {
            currentPlayer.startMovingInDirection(Direction.NONE);
            if(gameHandler.getGameState() == GameState.PLAYING){     
                gameHandler.togglePause();
            }
            mainWindow.requestFocusInWindow();
        });
    }

    public void update(){
        currentPlayer = gameHandler.getPlayer();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            // W for going up
            case KeyEvent.VK_W:  
                if(gameHandler.getGameState() == GameState.PLAYING){
                    if (!wKeyHeldDown && !currentPlayer.isFalling()) {
                    currentPlayer.startJumping();
                    wKeyHeldDown = true;
                    }
                }   
                break;
            // A for going left
            case KeyEvent.VK_A:

                if(gameHandler.getGameState() == GameState.PLAYING){
                    currentPlayer.startMovingInDirection(Direction.LEFT);
                }
                break;
            // S for going down
            case KeyEvent.VK_S: 
                break;
            // D for going right
            case KeyEvent.VK_D:

                if(gameHandler.getGameState() == GameState.PLAYING){
                    currentPlayer.startMovingInDirection(Direction.RIGHT);
                }
                break;
            // ESC for pausing
            case KeyEvent.VK_ESCAPE:
                currentPlayer.startMovingInDirection(Direction.NONE);
                if(gameHandler.getGameState() == GameState.PLAYING || gameHandler.getGameState() == GameState.PAUSED){       
                    gameHandler.togglePause();
                }
                break;    
            // K to use powerup
            case KeyEvent.VK_K:
                if(gameHandler.getGameState() == GameState.PLAYING){
                    gameHandler.usePowerUp();
                }
                break;
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        if(gameHandler.getGameState() == GameState.PLAYING){
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