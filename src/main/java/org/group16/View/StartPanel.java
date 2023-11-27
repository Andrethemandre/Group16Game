package org.group16.View;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.group16.Model.GameObjects.Player.Player;

public class StartPanel extends GamePanel {
    private JLabel gameTitleLabel;
    private JButton playButton;
    private JButton loadGameButton;
    private JButton settingsButton;
    private JButton quitButton;

    public StartPanel(int x, int y) {
        super(x, y);
        this.setLayout(new BorderLayout()); 
        loadButtons();
    }

    private void loadButtons() {
        Dimension buttonSize = new Dimension(200, 50); // Set the preferred width to 200 and the preferred height to 50
        gameTitleLabel = new JLabel("Game Title", JLabel.CENTER);
        gameTitleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        gameTitleLabel.setBorder(BorderFactory.createEmptyBorder(25, 0, 0, 0)); // Add padding to pauseLabel
        this.add(gameTitleLabel, BorderLayout.NORTH);

        playButton = new JButton();
        playButton.setText("Play");
        playButton.setPreferredSize(buttonSize);
        this.add(playButton);

        loadGameButton = new JButton();
        loadGameButton.setText("Load Game");
        loadGameButton.setPreferredSize(buttonSize);
        this.add(loadGameButton);

        settingsButton = new JButton();
        settingsButton.setText("Settings");
        settingsButton.setPreferredSize(buttonSize);
        this.add(settingsButton);

        quitButton = new JButton();
        quitButton.setText("Quit");
        quitButton.setPreferredSize(buttonSize);
        this.add(quitButton);

        playButton.setMaximumSize(buttonSize);
        loadGameButton.setMaximumSize(buttonSize);
        settingsButton.setMaximumSize(buttonSize);
        quitButton.setMaximumSize(buttonSize);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(Box.createVerticalGlue());

        playButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        buttonPanel.add(playButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add space after button

        loadGameButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        buttonPanel.add(loadGameButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add space after button

        settingsButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        buttonPanel.add(settingsButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add space after button

        quitButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        buttonPanel.add(quitButton);

        buttonPanel.add(Box.createVerticalGlue());

        //buttonPanel.setBackground(Color.GRAY);
        add(buttonPanel, BorderLayout.CENTER);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public JButton getPlayButton() {
        return playButton;
    }

    public JButton getQuitButton() {
        return quitButton;
    }
    
}