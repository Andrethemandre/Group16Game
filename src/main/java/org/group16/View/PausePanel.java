package org.group16.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import org.group16.Model.GameObjects.GameState;
import org.group16.Model.GameObjects.Player.Player;

public class PausePanel extends GamePanel {

    public PausePanel(int x, int y) {
        super(x, y); // Explicitly invoke the constructor of the superclass
        this.setBackground(Color.RED);
        //TODO Auto-generated constructor stub
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }


}
