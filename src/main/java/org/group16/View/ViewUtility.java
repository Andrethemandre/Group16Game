package org.group16.View;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ViewUtility {
    // Private constructor to prevent instantiation
    private ViewUtility() {};

    public static JButton createMenuButton(String text, Dimension size) {
        JButton button = new JButton();
        button.setText(text);
        button.setPreferredSize(size);
        button.setMaximumSize(size);
        button.setAlignmentX(JButton.CENTER_ALIGNMENT);

        return button;
    }

    public static void addCenteredToButtonPanel(JPanel buttonPanel, JButton button, int widthSpacing, int heightSpacing) {
        button.setAlignmentX(JButton.CENTER_ALIGNMENT);
        buttonPanel.add(button);
        buttonPanel.add(Box.createRigidArea(new Dimension(widthSpacing, heightSpacing))); // Add space after button
    }

    public static void createVerticalButtonPanel(){
        
    }
}
