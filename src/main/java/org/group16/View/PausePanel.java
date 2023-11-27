package org.group16.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PausePanel extends GamePanel {
    private JLabel pauseLabel;
    private JButton resumeButton;
    private JButton restartButton;
    private JButton mainMenuButton;
    private JButton settingsButton;
    private JButton quitButton;

    public PausePanel(int x, int y) {
        super(x, y); // Explicitly invoke the constructor of the superclass
        this.setBackground(Color.GRAY);
        this.setLayout(new BorderLayout()); 
        loadButtons();
    }

    private void loadButtons() {
        Dimension buttonSize = new Dimension(200, 50); // Set the preferred width to 200 and the preferred height to 50

        pauseLabel = new JLabel("Paused", JLabel.CENTER);

        pauseLabel.setFont(new Font("Arial", Font.BOLD, 30));
        pauseLabel.setBorder(BorderFactory.createEmptyBorder(25, 0, 0, 0)); // Add padding to pauseLabel
        this.add(pauseLabel, BorderLayout.NORTH);

        resumeButton = new JButton();
        resumeButton.setText("Resume");
        resumeButton.setPreferredSize(buttonSize);

        restartButton = new JButton();
        restartButton.setText("Restart");
        restartButton.setPreferredSize(buttonSize);

        mainMenuButton = new JButton();
        mainMenuButton.setText("Main Menu");
        mainMenuButton.setPreferredSize(buttonSize);

        settingsButton = new JButton();
        settingsButton.setText("Settings");
        settingsButton.setPreferredSize(buttonSize);


        quitButton = new JButton();
        quitButton.setText("Quit to desktop");
        quitButton.setPreferredSize(buttonSize);


        resumeButton.setMaximumSize(buttonSize);
        restartButton.setMaximumSize(buttonSize);
        mainMenuButton.setMaximumSize(buttonSize);
        settingsButton.setMaximumSize(buttonSize);
        quitButton.setMaximumSize(buttonSize);


        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(Box.createVerticalGlue());

        resumeButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        buttonPanel.add(resumeButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add space after button

        restartButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        buttonPanel.add(restartButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add space after button

        mainMenuButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        buttonPanel.add(mainMenuButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add space after button

        settingsButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        buttonPanel.add(settingsButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add space after button

        quitButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        buttonPanel.add(quitButton);

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
