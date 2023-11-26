package org.group16.View;
import java.awt.Graphics;

import javax.swing.JButton;

import org.group16.Model.GameObjects.Player.Player;

public class StartPanel extends GamePanel {
    private JButton playButton;
    public StartPanel(int x, int y) {
        super(x, y);
        loadButtons();
    }

    private void loadButtons() {
        playButton = new JButton();
        playButton.setText("Play");
        this.add(playButton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public JButton getPlayButton() {
        return playButton;
    }
    
}
