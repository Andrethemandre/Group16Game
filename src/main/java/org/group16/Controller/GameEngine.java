package org.group16.Controller;

import java.awt.Graphics;

import  org.group16.View.Renderer;

public class GameEngine {
    private Renderer renderer;
    private PlayerController playerController;
    
    public void setRenderer(Renderer renderer){
        this.renderer = renderer;
    }

    // render the whole world
    public void render(Graphics g){
        renderer.render(g);
    }
    
}
