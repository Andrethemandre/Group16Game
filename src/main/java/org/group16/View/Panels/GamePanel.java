package org.group16.View.Panels;

import java.awt.Dimension;

import javax.swing.JPanel;

public abstract class GamePanel extends JPanel{
    GamePanel(int x, int y){
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(300, 300));
    }
}