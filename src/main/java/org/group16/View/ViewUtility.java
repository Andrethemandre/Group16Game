package org.group16.View;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
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

    public static JPanel createVerticalButtonPanel(){
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(Box.createVerticalGlue());

        return buttonPanel;
    }

    public static void addCenteredButtonsToPanel(JButton[] buttons, JPanel buttonPanel) {
        for (JButton button : buttons) {
            ViewUtility.addCenteredToButtonPanel(buttonPanel, button,0,10);
        }
        
        buttonPanel.add(Box.createVerticalGlue());
    }

    public static JLabel createCenteredMenuTitle(String text, Font font, int top, int left, int bottom, int right){
        JLabel label = new JLabel(text,JLabel.CENTER);
        label.setFont(font);
        label.setBorder(BorderFactory.createEmptyBorder(top, left, bottom, right)); // Add padding 
        return label;
    }
}
