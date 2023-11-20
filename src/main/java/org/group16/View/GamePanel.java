package org.group16.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public abstract class GamePanel extends JPanel{
    public GamePanel(int x, int y){
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(300, 300));
    }
}
