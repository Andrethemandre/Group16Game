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

    public static JButton createButton(String text, Dimension size) {
        JButton button = new JButton();
        button.setText(text);
        button.setPreferredSize(size);
        button.setMaximumSize(size);
        button.setAlignmentX(JButton.CENTER_ALIGNMENT);

        return button;
    }

        public static JButton createButton(String text, Dimension size, Font font) {
        JButton button = new JButton();
        button.setText(text);
        button.setPreferredSize(size);
        button.setMaximumSize(size);
        button.setAlignmentX(JButton.CENTER_ALIGNMENT);
        button.setFont(font);

        return button;
    }

    public static void addCenteredToButtonPanel(JPanel buttonPanel, JButton button, int widthSpacing, int heightSpacing) {
        button.setAlignmentX(JButton.CENTER_ALIGNMENT);
        buttonPanel.add(button);
        buttonPanel.add(Box.createRigidArea(new Dimension(widthSpacing, heightSpacing))); // Add space after button
    }

    public static JPanel createVerticalPanel(){
        JPanel verticalPanel = new JPanel();
        verticalPanel.setLayout(new BoxLayout(verticalPanel, BoxLayout.Y_AXIS));

        return verticalPanel;
    }

    public static JPanel createHorizontalPanel(){
        JPanel horizontalPanel = new JPanel();
        horizontalPanel.setLayout(new BoxLayout(horizontalPanel, BoxLayout.X_AXIS));

        return horizontalPanel;
    }

    public static void addCenteredButtonsToPanel(JButton[] buttons, JPanel buttonPanel) {
        for (JButton button : buttons) {
            ViewUtility.addCenteredToButtonPanel(buttonPanel, button,0,10);
        }
    }

    public static void addCenteredButtonsToPanel(JButton[] buttons, JPanel buttonPanel, int widthSpacing, int heightSpacing) {
        for (JButton button : buttons) {
            ViewUtility.addCenteredToButtonPanel(buttonPanel, button, widthSpacing, heightSpacing);
        }
    }

    public static JLabel createLabel(String text, Font font, int top, int left, int bottom, int right, float alignment){
        JLabel label = new JLabel(text,JLabel.CENTER);
        label.setFont(font);


        label.setBorder(BorderFactory.createEmptyBorder(top, left, bottom, right)); // Add padding 
        return label;
    }
}
