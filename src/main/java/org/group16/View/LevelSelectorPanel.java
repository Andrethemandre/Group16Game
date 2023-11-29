package org.group16.View;

import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import org.group16.Model.Level.Level;
import org.group16.Model.Level.LevelHandler;

public class LevelSelectorPanel extends GamePanel {
    private LevelHandler levelHandler;

    private JLabel levelSelectTitle;
    private JLabel levelLabel;
    private JButton playButton;
    private JButton backToMainMenuButton;

    private JButton[] levelButtons;
    private JPanel verticalButtonPanel;
    
    public LevelSelectorPanel(int x, int y, LevelHandler levelHandler) {
        super(x, y);
        this.levelHandler = levelHandler;
        initComponents();
    }

    public JButton[] getLevelButtons() {
        return levelButtons;
    }

    private void initComponents() {
        //levelSelectTitle = ViewUtility.createCenteredMenuTitle("Level Select", 30, 0, 0, 0);
        setLayout(new BorderLayout());
        Dimension buttonSize = new Dimension(200, 50);

        levelButtons = new JButton[levelHandler.getLevels().size()];
        int i = 0;

        for (Map.Entry<Integer, Level> entry : levelHandler.getLevels().entrySet()) {
            Integer levelNumber = entry.getKey();
            Level level = entry.getValue();

            levelButtons[i] = ViewUtility.createMenuButton("Level " + levelNumber, buttonSize);
            i++;
        }

        verticalButtonPanel = ViewUtility.createVerticalButtonPanel();
        ViewUtility.addCenteredButtonsToPanel(levelButtons, verticalButtonPanel);
        verticalButtonPanel.setBackground(Color.GRAY);
        add(verticalButtonPanel, BorderLayout.CENTER);

        // setBackground(Color.GRAY);
        // setLayout(new BorderLayout()); 

        // String labelText = "Paused";
        // Font labelFont = new Font("Arial", Font.BOLD, 30);

        // pauseLabel = ViewUtility.createCenteredMenuTitle(labelText, labelFont,25,0,0,0);
        // add(pauseLabel, BorderLayout.NORTH);

        // Dimension buttonSize = new Dimension(200, 50); // Set the preferred width to 200 and the preferred height to 50

        // // Buttons in order of how they will appear in the menu
        // JButton[] buttons = {
        //     resumeButton = ViewUtility.createMenuButton("Resume", buttonSize),
        //     restartButton = ViewUtility.createMenuButton("Restart", buttonSize),
        //     mainMenuButton = ViewUtility.createMenuButton("Main Menu", buttonSize),
        //     settingsButton = ViewUtility.createMenuButton("Settings", buttonSize),
        //     quitButton= ViewUtility.createMenuButton("Quit to desktop", buttonSize)
        // };

        // verticalButtonPanel = ViewUtility.createVerticalButtonPanel();
        // ViewUtility.addCenteredButtonsToPanel(buttons, verticalButtonPanel);
        // verticalButtonPanel.setBackground(Color.GRAY);
        // add(verticalButtonPanel, BorderLayout.CENTER);
    }
}