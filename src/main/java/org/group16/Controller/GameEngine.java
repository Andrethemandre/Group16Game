package org.group16.Controller;

import java.awt.Graphics;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.group16.View.GamePanel;
import org.group16.View.GameWindow;
import  org.group16.View.Renderer;

public class GameEngine {
    private GameWindow mainWindow;
    private PlayerController playerController;
        
    public GameEngine(GameWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.playerController = new PlayerController(mainWindow);
    }


    // start timer
    public void start(){

    }
}
