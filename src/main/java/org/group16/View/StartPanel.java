package org.group16.View;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

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
    private JPanel verticalButtonPanel;

    public StartPanel(int x, int y) {
        super(x, y);
        initComponents();
    }

    private void initComponents(){
        this.setLayout(new BorderLayout()); 

        String labelText = "Game Title";
        Font labelFont = new Font("Arial", Font.BOLD, 30);
        gameTitleLabel = ViewUtility.createCenteredMenuTitle(labelText, labelFont,25,0,0,0);
        add(gameTitleLabel, BorderLayout.NORTH);

        Dimension buttonSize = new Dimension(200, 50); // Set the preferred width to 200 and the preferred height to 50

        // Buttons in order of how they will appear in the menu
        JButton[] buttons = {
            playButton = ViewUtility.createMenuButton("Play", buttonSize),
            loadGameButton = ViewUtility.createMenuButton("Load Game", buttonSize),
            settingsButton = ViewUtility.createMenuButton("Settings", buttonSize),
            quitButton= ViewUtility.createMenuButton("Quit", buttonSize)
        };

        verticalButtonPanel = ViewUtility.createVerticalButtonPanel();
        ViewUtility.addCenteredButtonsToPanel(buttons, verticalButtonPanel);
        add(verticalButtonPanel, BorderLayout.CENTER);
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