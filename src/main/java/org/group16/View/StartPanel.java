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

public class StartPanel extends GamePanel {
    private JLabel gameTitleLabel;
    private JButton playButton;
    private JButton loadGameButton;
    private JButton settingsButton;
    private JButton quitButton;
    private JPanel buttonPanel;

    public StartPanel(int x, int y) {
        super(x, y);
        initComponents();
    }

    private void initComponents(){
        this.setLayout(new BorderLayout()); 

        String labelText = "Game Title";
        Font labelFont = new Font("Arial", Font.BOLD, 30);

        loadTitle(labelText,labelFont);

        Dimension buttonSize = new Dimension(200, 50); // Set the preferred width to 200 and the preferred height to 50
        
        // Buttons in order of how they will appear in the menu
        JButton[] buttons = {
            playButton = ViewUtility.createMenuButton("Play", buttonSize),
            loadGameButton = ViewUtility.createMenuButton("Load Game", buttonSize),
            settingsButton = ViewUtility.createMenuButton("Settings", buttonSize),
            quitButton= ViewUtility.createMenuButton("Quit", buttonSize)
        };

        loadButtons(buttons);
    }

    private void loadTitle(String labelText, Font labelFont) {
        gameTitleLabel = new JLabel(labelText, JLabel.CENTER);
        gameTitleLabel.setFont(labelFont);
        gameTitleLabel.setBorder(BorderFactory.createEmptyBorder(25, 0, 0, 0)); // Add padding to pauseLabel
        this.add(gameTitleLabel, BorderLayout.NORTH);
    }

    private void loadButtons(JButton[] buttons) {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(Box.createVerticalGlue());
        
        for (JButton button : buttons) {
            ViewUtility.addCenteredToButtonPanel(buttonPanel, button,0,10);
        }
        
        buttonPanel.add(Box.createVerticalGlue());
        add(buttonPanel, BorderLayout.CENTER);
    }

    public JButton getPlayButton() {
        return playButton;
    }

    public JButton getLoadGameButton() {
        return loadGameButton;
    }

    public JButton getSettingsButton() {
        return settingsButton;
    }

    public JButton getQuitButton() {
        return quitButton;
    }
}