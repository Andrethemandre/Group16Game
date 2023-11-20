package org.group16.Controller;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import org.group16.Model.GameObjects.GameState;
import org.group16.Model.GameObjects.Player.Player;
import org.group16.Model.Level.LevelHandler;
import org.group16.View.GameWindow;

public class PlayerController implements KeyListener, MouseListener {

    private GameWindow mainWindow;
    private LevelHandler levelHandler;
    private Player currentPlayer;

    public PlayerController(LevelHandler levelHandler, GameWindow mainWindow){
        this.mainWindow = mainWindow;
        this.levelHandler = levelHandler;
        this.currentPlayer = levelHandler.getPlayer();

        mainWindow.addKeyListener(this);
        mainWindow.addMouseListener(this);
    }

    public void update(){
        currentPlayer = levelHandler.getPlayer();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // System.out.println("Key typed: " + e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // System.out.println("Key pressed: " + e.getKeyChar());

        switch(e.getKeyCode()) {
            // w for going up
            case KeyEvent.VK_W:
                if(levelHandler.getGameState() == GameState.PLAYING){
                    currentPlayer.setYDirection(-1);
                    currentPlayer.jump();
                }
                break;

            // a for going left
            case KeyEvent.VK_A:
                if(levelHandler.getGameState() == GameState.PLAYING){
                    currentPlayer.setXDirection(-1);
                    currentPlayer.move();
                }
                break;

            // s for going down
            case KeyEvent.VK_S: 
                //currentPlayer.move();
                break;

            // d for going right
            case KeyEvent.VK_D:
                if(levelHandler.getGameState() == GameState.PLAYING){
                    currentPlayer.setXDirection(1);
                    currentPlayer.move();
                }
                break; 
            
            case KeyEvent.VK_ESCAPE:
                if(levelHandler.getGameState() == GameState.PLAYING || levelHandler.getGameState() == GameState.PAUSED){          
                    levelHandler.togglePause();
                }
                break;
            }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // System.out.println("Key released: " + e.getKeyChar());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // System.out.println("mouseClicked");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // System.out.println("mousePressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // System.out.println("mouseReleased");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // System.out.println("mouseEntered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // System.out.println("mouseExited");
    }
  
}
