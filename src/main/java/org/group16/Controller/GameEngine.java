package org.group16.Controller;

import java.awt.Graphics;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import  org.group16.View.Renderer;

public class GameEngine {
    private Renderer renderer;
    private PlayerController playerController;
        
    public GameEngine(Renderer render) {
        this.playerController = new PlayerController();
        this.renderer = render;
    }

    // render the whole world
    public void render(Graphics g){
        renderer.render(g);
    }
    // start timer
    public void start(){

    }
}
