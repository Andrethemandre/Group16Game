package org.group16.Controller;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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

    public PlayerController(LevelHandler levelHandler, GameWindow mainWindow){
        this.mainWindow = mainWindow;
        this.levelHandler = levelHandler;
        this.currentPlayer = levelHandler.getPlayer();
        mainWindow.addKeyListener(this);
        mainWindow.addMouseListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Key typed: " + e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Key pressed: " + e.getKeyChar());

        switch(e.getKeyCode()) {
            // w for going up
            case KeyEvent.VK_W:
                currentPlayer.setYDirection(-1);
                currentPlayer.jump();
                break;

            // a for going left
            case KeyEvent.VK_A:
                currentPlayer.setXDirection(-1);
                currentPlayer.move();
                break;

            // s for going down
            case KeyEvent.VK_S: 
                //currentPlayer.move();
                break;

            // d for going right
            case KeyEvent.VK_D:
                currentPlayer.setXDirection(1);
                currentPlayer.move();
                break; 
            }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        System.out.println("Key released: " + e.getKeyChar());
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
