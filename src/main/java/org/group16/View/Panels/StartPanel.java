package org.group16.View.Panels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.group16.View.Utility.UserInterfaceUtility;

public class StartPanel extends GamePanel {
    private JLabel firstGameTitleLabelRow;
    private JLabel secondGameTitleLabelRow;
    private JButton continueButton;
    private JButton newGameButton;
    private JButton loadGameButton;
    private JButton settingsButton;
    private JButton quitButton;
    private JPanel verticalButtonPanel;
    private Font gameTitleFont;
    
    private BufferedImage backgroundImage;

    public StartPanel(int x, int y) {
        super(x, y);
        initFont(); 
        initImages();
        initComponents();
    }

    private void initComponents(){
        this.setLayout(new BorderLayout()); 
        JPanel textPanel = UserInterfaceUtility.createVerticalPanel();
        String firstLabelText = "King Blöb's";

        firstGameTitleLabelRow = UserInterfaceUtility.createLabel(firstLabelText, gameTitleFont, 25, 230, 0, 0, JLabel.CENTER);
        textPanel.add(firstGameTitleLabelRow);

        String secondLabelText = "Adventure";
        secondGameTitleLabelRow = UserInterfaceUtility.createLabel(secondLabelText, gameTitleFont, 0, 225, 0, 0, JLabel.CENTER);
        textPanel.add(secondGameTitleLabelRow);
        textPanel.setOpaque(false);
        add(textPanel, BorderLayout.NORTH);

        Dimension buttonSize = new Dimension(200, 28); // Set the preferred width to 200 and the preferred height to 50
        Font font = new Font(null, Font.PLAIN, 12);

        // Buttons in order of how they will appear in the menu
        JButton[] buttons = {
            continueButton = UserInterfaceUtility.createButton("Continue", buttonSize, font),
            newGameButton = UserInterfaceUtility.createButton("New Game", buttonSize, font),
            loadGameButton = UserInterfaceUtility.createButton("Load Game", buttonSize, font),
            settingsButton = UserInterfaceUtility.createButton("Settings", buttonSize, font),
            quitButton= UserInterfaceUtility.createButton("Quit", buttonSize, font)
        };

        verticalButtonPanel = UserInterfaceUtility.createVerticalPanel();
        verticalButtonPanel.add(Box.createVerticalGlue());
        UserInterfaceUtility.addCenteredButtonsToPanel(buttons, verticalButtonPanel,0,30);
        verticalButtonPanel.add(Box.createVerticalGlue());
        verticalButtonPanel.setOpaque(false);
        add(verticalButtonPanel, BorderLayout.CENTER);
    }

    /**
    * This method is called each time the panel updates/refreshes/repaints itself
    */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBackground(g);
    }

    private void drawBackground(Graphics g) {
        g.drawImage(backgroundImage, 0, 0, this);
    }

    private void initFont(){
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/Grand9K Pixel.ttf"));
            gameTitleFont = font.deriveFont(48f);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initImages(){
         try {
            backgroundImage = ImageIO.read(getClass().getResourceAsStream("/images/sprites/background.png"));
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JButton getContinueButton() {
        return continueButton;
    }

    public JButton getNewGameButton() {
        return newGameButton;
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
