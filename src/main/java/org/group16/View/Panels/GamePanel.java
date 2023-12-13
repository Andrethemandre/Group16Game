package org.group16.View.Panels;

import java.awt.Dimension;

import javax.swing.JPanel;

import org.group16.Model.Observers.GameObserver;

public abstract class GamePanel extends JPanel implements GameObserver{
    GamePanel(int x, int y){
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(720, 448));
    }
}