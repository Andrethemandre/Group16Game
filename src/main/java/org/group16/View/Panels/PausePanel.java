package org.group16.View.Panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.group16.View.ViewUtility;

public class PausePanel extends GamePanel {
    private JLabel pauseLabel;
    private JButton resumeButton;
    private JButton restartButton;
    private JButton levelSelectButton;
    private JButton mainMenuButton;
    private JButton settingsButton;
    private JButton quitButton;
    private JPanel verticalButtonPanel;

    public PausePanel(int x, int y) {
        super(x, y); 
        initComponents();

    }

    public JButton getLevelSelectButton(){
        return levelSelectButton;
    }

    private void initComponents(){
        setBackground(Color.GRAY);
        setLayout(new BorderLayout()); 

        String labelText = "Paused";
        Font labelFont = new Font("Arial", Font.BOLD, 30);

        pauseLabel = ViewUtility.createLabel(labelText, labelFont,25,0,0,0, JLabel.CENTER);
        add(pauseLabel, BorderLayout.NORTH);

        Dimension buttonSize = new Dimension(200, 50); // Set the preferred width to 200 and the preferred height to 50

        // Buttons in order of how they will appear in the menu
        JButton[] buttons = {
            resumeButton = ViewUtility.createButton("Resume", buttonSize),
            restartButton = ViewUtility.createButton("Restart", buttonSize),
            levelSelectButton = ViewUtility.createButton("Level Select", buttonSize),
            mainMenuButton = ViewUtility.createButton("Main Menu", buttonSize),
            settingsButton = ViewUtility.createButton("Settings", buttonSize),
            quitButton= ViewUtility.createButton("Quit to desktop", buttonSize)
        };

        verticalButtonPanel = ViewUtility.createVerticalPanel();
        verticalButtonPanel.add(Box.createVerticalGlue());
        ViewUtility.addCenteredButtonsToPanel(buttons, verticalButtonPanel);
        verticalButtonPanel.add(Box.createVerticalGlue());
        verticalButtonPanel.setBackground(Color.GRAY);
        add(verticalButtonPanel, BorderLayout.CENTER);
    }

    public JButton getResumeButton() {
        return resumeButton;
    }

    public JButton getRestartButton() {
        return restartButton;
    }

    public JButton getMainMenuButton() {
        return mainMenuButton;
    }

    public JButton getSettingsButton() {
        return settingsButton;
    }

    public JButton getQuitButton() {
        return quitButton;
    }
}