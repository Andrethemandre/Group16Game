package org.group16.Controller;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.Player.Player;
import org.group16.Model.Level.Level;
import org.group16.Model.Level.LevelHandler;
import org.group16.View.GamePanel;
import org.group16.View.GameWindow;
import org.group16.View.LevelPanel;
import org.group16.View.Renderer;

public class PlayerController implements KeyListener, MouseListener {

    private GameWindow mainWindow;
    private LevelHandler levelHandler;
    private Player currentPlayer;
    // flag to only allow one jump per keypress
    private boolean wKeyHeldDown = false;

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
        System.out.println("Key pressed: " + e.getKeyChar());

        switch(e.getKeyCode()) {
            // w for going up
            case KeyEvent.VK_W:
                if (!wKeyHeldDown && !currentPlayer.isFalling()) {
                    currentPlayer.startJumping();
                    wKeyHeldDown = true;
                    System.out.println("Jumping");
                }
                break;

            // a for going left
            case KeyEvent.VK_A:
                currentPlayer.startMovingInDirection(Direction.LEFT);
                // currentPlayer.move();
                break;

            // s for going down
            case KeyEvent.VK_S: 
                //currentPlayer.move();
                break;

            // d for going right
            case KeyEvent.VK_D:
                currentPlayer.startMovingInDirection(Direction.RIGHT);
                // currentPlayer.move();
                break; 
            }
    }

    @Override
    public void keyReleased(KeyEvent e) {
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

        // TODO Auto-generated method stub
        // System.out.println("Key released: " + e.getKeyChar());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("mouseClicked");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("mousePressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("mouseReleased");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("mouseEntered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("mouseExited");
    }
  
}
