package org.group16.View.Panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.group16.View.Utility.UserInterfaceUtility;

public class PausePanel extends GamePanel{
    private JLabel pauseLabel;
    private JButton resumeButton;
    private JButton restartButton;
    private JButton levelSelectButton;
    private JButton mainMenuButton;
    private JButton settingsButton;
    private JButton quitButton;
    private JPanel verticalButtonPanel;
    private Font pauseTitleFont;

    public PausePanel(int x, int y) {
        super(x, y); 
        initCustomFont();
        initComponents();
    }

    private void initCustomFont(){
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/Grand9K Pixel.ttf"));
            pauseTitleFont = font.deriveFont(36f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JButton getLevelSelectButton(){
        return levelSelectButton;
    }

    private void initComponents(){
        setBackground(Color.GRAY);
        setLayout(new BorderLayout()); 

        String labelText = "Paused";

        pauseLabel = UserInterfaceUtility.createLabel(labelText, pauseTitleFont,0,0,0,0, JLabel.CENTER);
        add(pauseLabel, BorderLayout.NORTH);

        Dimension buttonSize = new Dimension(200, 28); // Set the preferred width to 200 and the preferred height to 50
        Font font = new Font(null, Font.PLAIN, 12);
        
        // Buttons in order of how they will appear in the menu
        JButton[] buttons = {
            resumeButton = UserInterfaceUtility.createButton("Resume", buttonSize, font, JButton.CENTER_ALIGNMENT),
            restartButton = UserInterfaceUtility.createButton("Restart", buttonSize, font, JButton.CENTER_ALIGNMENT),
            levelSelectButton = UserInterfaceUtility.createButton("Level Select", buttonSize, font, JButton.CENTER_ALIGNMENT),
            mainMenuButton = UserInterfaceUtility.createButton("Main Menu", buttonSize, font, JButton.CENTER_ALIGNMENT),
            settingsButton = UserInterfaceUtility.createButton("Settings", buttonSize, font, JButton.CENTER_ALIGNMENT),
            quitButton= UserInterfaceUtility.createButton("Quit to desktop", buttonSize, font, JButton.CENTER_ALIGNMENT)
        };

        verticalButtonPanel = UserInterfaceUtility.createVerticalPanel();
        verticalButtonPanel.add(Box.createVerticalGlue());
        UserInterfaceUtility.addCenteredButtonsToPanel(buttons, verticalButtonPanel, 0, 30);
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

    @Override
    public void updateObserver() {}
}