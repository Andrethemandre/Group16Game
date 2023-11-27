package org.group16.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PausePanel extends GamePanel {
    private JLabel pauseLabel;
    private JButton resumeButton;
    private JButton restartButton;
    private JButton mainMenuButton;
    private JButton settingsButton;
    private JButton quitButton;

    public PausePanel(int x, int y) {
        super(x, y); // Explicitly invoke the constructor of the superclass
        initComponents();

    }
    private void initComponents(){
        this.setBackground(Color.GRAY);
        this.setLayout(new BorderLayout()); 
        String labelText = "Paused";
        Font labelFont = new Font("Arial", Font.BOLD, 30);

        loadTitle(labelText,labelFont);

        Dimension buttonSize = new Dimension(200, 50); // Set the preferred width to 200 and the preferred height to 50

        // Buttons in order of how they will appear in the menu
        JButton[] buttons = {
            resumeButton = ViewUtility.createMenuButton("Resume", buttonSize),
            restartButton = ViewUtility.createMenuButton("Restart", buttonSize),
            mainMenuButton = ViewUtility.createMenuButton("Main Menu", buttonSize),
            settingsButton = ViewUtility.createMenuButton("Settings", buttonSize),
            quitButton= ViewUtility.createMenuButton("Quit to desktop", buttonSize)
        };


        loadButtons(buttons);
    }

    private void loadTitle(String labelText, Font labelFont) {
        pauseLabel = new JLabel(labelText, JLabel.CENTER);
        pauseLabel.setFont(labelFont);
        pauseLabel.setBorder(BorderFactory.createEmptyBorder(25, 0, 0, 0)); // Add padding to pauseLabel
        this.add(pauseLabel, BorderLayout.NORTH);
    }

    private void loadButtons(JButton[] buttons) {     
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(Box.createVerticalGlue());
        
        for (JButton button : buttons) {
            ViewUtility.addCenteredToButtonPanel(buttonPanel, button, 0, 10);
        }

        buttonPanel.add(Box.createVerticalGlue());
        buttonPanel.setBackground(Color.GRAY);
        add(buttonPanel, BorderLayout.CENTER);
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
