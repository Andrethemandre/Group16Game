package org.group16.View.Panels;

import javax.imageio.ImageIO;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import org.group16.Model.GameHandling.GameHandler;
import org.group16.Model.GameObjects.GameState;
import org.group16.Model.Observers.GameObserver;
import org.group16.View.Utility.UserInterfaceUtility;

public class LevelSelectorPanel extends GamePanel implements GameObserver {
    private GameHandler gameHandler;

    private JLabel levelSelectTitle;
    private JButton playButton;
    private JButton backToMainMenuButton;

    private JButton[] levelButtons;
    private JPanel levelVerticalSelectPanel;
    private JLabel levelSelectLabel;
    private JButton levelPageNextButton;
    private JButton levelPageBackButton;
    private JLabel levelCurrentPageLabel;

    private BufferedImage firstLevelImage;
    private BufferedImage secondLevelImage;
    private BufferedImage thirdLevelImage;
    private BufferedImage fourthLevelImage;
    private BufferedImage fifthLevelImage;
    private BufferedImage sixthLevelImage;
    private BufferedImage seventhLevelImage;
    private BufferedImage eighthLevelImage;
    private BufferedImage ninthLevelImage;
    private BufferedImage tenthLevelImage;
    private BufferedImage placeHolderImage;
    private BufferedImage leftBrowseIconImage;
    private BufferedImage rightBrowseIconImage;



    private JLabel highScoreLabel;
    private JLabel picLabel;

    private Font currentSelectedLevelFont;
    private Font levelSelectTitleFont;
    private static final Font regularButtonFont = new Font("Arial", Font.PLAIN, 12);
    private static final Font levelButtonFont = new Font("Arial", Font.PLAIN, 20);

    // for default set to level 1 display
    public LevelSelectorPanel(int x, int y, GameHandler gameHandler) {
        super(x, y);
        this.gameHandler = gameHandler;

        initCustomFont();
        initImages();
        initComponents();
    }

    private void initCustomFont(){
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/Grand9K Pixel.ttf"));
            currentSelectedLevelFont = font.deriveFont(24f);
            levelSelectTitleFont = font.deriveFont(24f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initImages(){
        try {
            placeHolderImage = ImageIO
                    .read(getClass().getResourceAsStream("/images/level_select/placeholder_level_image.png"));
            firstLevelImage = ImageIO.read(getClass().getResourceAsStream("/images/level_select/level_1_image.png"));
            secondLevelImage = ImageIO.read(getClass().getResourceAsStream("/images/level_select/level_2_image.png"));
            thirdLevelImage = ImageIO.read(getClass().getResourceAsStream("/images/level_select/level_3_image.png"));
            fourthLevelImage = ImageIO.read(getClass().getResourceAsStream("/images/level_select/level_4_image.png"));
            fifthLevelImage = ImageIO.read(getClass().getResourceAsStream("/images/level_select/level_5_image.png"));
            sixthLevelImage = ImageIO.read(getClass().getResourceAsStream("/images/level_select/level_6_image.png"));
            seventhLevelImage = ImageIO.read(getClass().getResourceAsStream("/images/level_select/level_7_image.png"));
            eighthLevelImage = ImageIO.read(getClass().getResourceAsStream("/images/level_select/level_8_image.png"));
            ninthLevelImage = ImageIO.read(getClass().getResourceAsStream("/images/level_select/level_9_image.png"));
            tenthLevelImage = ImageIO.read(getClass().getResourceAsStream("/images/level_select/level_10_image.png"));
            leftBrowseIconImage = ImageIO.read(getClass().getResourceAsStream("/images/level_select/left_browse_icon.png"));
            rightBrowseIconImage = ImageIO.read(getClass().getResourceAsStream("/images/level_select/right_browse_icon.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        initLevelButtons();
        JPanel levelBrowseMenu = createLevelBrowseMenu();
        JPanel levelInfoPanel = createLevelInfoPanel();
        
        add(levelBrowseMenu, BorderLayout.WEST);
        add(levelInfoPanel, BorderLayout.CENTER);
    }

    private void initLevelButtons() {
        levelButtons = new JButton[gameHandler.getTotalLevels()];

        for (int i = 0; i < levelButtons.length; i++) {
           
            levelButtons[i] = UserInterfaceUtility.createButton("Level " + (i + 1), new Dimension(175, 55), levelButtonFont, JButton.CENTER_ALIGNMENT);
        }
    }

    private void initLevelSelectPanel(int currentPage) {
        levelVerticalSelectPanel = UserInterfaceUtility.createVerticalPanel();
        
        levelVerticalSelectPanel.add(Box.createRigidArea(new Dimension(0, 27)));

        levelVerticalSelectPanel.setPreferredSize(new Dimension(200, levelVerticalSelectPanel.getPreferredSize().height));

        // Calculate the starting and ending index for the current page
        int start = (currentPage - 1) * 4; 
        int end = Math.min(start + 4, levelButtons.length);

        for (int i = start; i < end; i++) {
            levelVerticalSelectPanel.add(levelButtons[i]);

            if (i < end - 1) { // Don't add strut after the last button
                levelVerticalSelectPanel.add(Box.createRigidArea(new Dimension(0, 15)));
            }
        }
    }

    private void setLevelImage(int levelNumber) {
        int imageWidth = 474;
        int imageHeight = 195;
        Image resizedImage = null;

        switch (levelNumber) {
            case 1:
                resizedImage = firstLevelImage.getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
                picLabel.setIcon(new ImageIcon(resizedImage));
                break;
            case 2:
                resizedImage = secondLevelImage.getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
                picLabel.setIcon(new ImageIcon(resizedImage));
                break;
            case 3:
                resizedImage = thirdLevelImage.getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
                picLabel.setIcon(new ImageIcon(resizedImage));
                break;
            case 4:
                resizedImage = fourthLevelImage.getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
                picLabel.setIcon(new ImageIcon(resizedImage));
                break;
            case 5:
                resizedImage = fifthLevelImage.getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
                picLabel.setIcon(new ImageIcon(resizedImage));
                break;
            case 6:
                resizedImage = sixthLevelImage.getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
                picLabel.setIcon(new ImageIcon(resizedImage));
                break;
            case 7:
                resizedImage = seventhLevelImage.getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
                picLabel.setIcon(new ImageIcon(resizedImage));
                break;
            case 8:
                resizedImage = eighthLevelImage.getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
                picLabel.setIcon(new ImageIcon(resizedImage));
                break;
            case 9:
                resizedImage = ninthLevelImage.getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
                picLabel.setIcon(new ImageIcon(resizedImage));
                break;
            case 10:
                resizedImage = tenthLevelImage.getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
                picLabel.setIcon(new ImageIcon(resizedImage));
                break;
            default:
                resizedImage = placeHolderImage.getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
                picLabel.setIcon(new ImageIcon(resizedImage));
                break;
        }
    }

    private JPanel createLevelInfoPanel() {
        JPanel levelInfoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        levelInfoPanel.setBackground(Color.LIGHT_GRAY);
        levelSelectLabel = createCurrentSelectedLevelLabel();
        highScoreLabel = createHighScoreLabel();

        levelInfoPanel.add(levelSelectLabel);
        levelInfoPanel.add(createLevelImageLabel());
        levelInfoPanel.add(highScoreLabel);
        levelInfoPanel.add(createLevelInfoNavigationPanel());

        return levelInfoPanel;
    }

    private JLabel createCurrentSelectedLevelLabel() {
        String labelText = "Level x";
        return UserInterfaceUtility.createLabel(labelText, currentSelectedLevelFont, 14, 20, 0, 0, JLabel.CENTER);
    }

    private JLabel createLevelImageLabel() {
        picLabel = new JLabel(new ImageIcon(placeHolderImage));
        picLabel.setBorder(BorderFactory.createEmptyBorder(27, 20, 0, 0)); 
        return picLabel;
    }

    private JLabel createHighScoreLabel() {
        String labelText = "High Score: x";
        return UserInterfaceUtility.createLabel(labelText, new Font("Arial", Font.BOLD, 20), 15, 20, 0, 0, JLabel.LEFT);
    }

    private JPanel createLevelInfoNavigationPanel() {
        JPanel horizontalButtonPanel = UserInterfaceUtility.createHorizontalPanel();
        horizontalButtonPanel.setAlignmentX(JButton.CENTER_ALIGNMENT);
        horizontalButtonPanel.setBorder(BorderFactory.createEmptyBorder(110, 20, 0, 0)); 
        horizontalButtonPanel.setBackground(Color.LIGHT_GRAY);

        backToMainMenuButton = UserInterfaceUtility.createButton("Back to Main Menu", new Dimension(140, 28), regularButtonFont);
        horizontalButtonPanel.add(backToMainMenuButton);

        horizontalButtonPanel.add(Box.createRigidArea(new Dimension(175, 0)));
        playButton = UserInterfaceUtility.createButton("Play", new Dimension(100, 28), regularButtonFont);

        horizontalButtonPanel.add(playButton);

        return horizontalButtonPanel;
    }

    private JPanel createLevelBrowseMenu() {
        JPanel levelBrowseMenu = new JPanel();
        levelBrowseMenu.setLayout(new BorderLayout());

        levelSelectTitle = createTitle();
        levelBrowseMenu.add(levelSelectTitle, BorderLayout.NORTH);

        initLevelSelectPanel(1);

        JPanel navigationPanel = createLevelBrowseNavigationPanel();

        levelVerticalSelectPanel.setBackground(Color.GRAY);
        levelBrowseMenu.setBackground(Color.GRAY);
        levelBrowseMenu.add(levelVerticalSelectPanel, BorderLayout.CENTER);

        navigationPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 60, 0)); 
        levelBrowseMenu.add(navigationPanel, BorderLayout.SOUTH);

        return levelBrowseMenu;
    }

    private JLabel createLevelCurrentPageLabel() {
        int totalLevels = gameHandler.getTotalLevels();
        String labelText = gameHandler.getCurrentLevelSelectPage() + "/" + (int) (totalLevels / 4 + 1);
        Font labelFont = new Font("Arial", Font.PLAIN, 20);

        return UserInterfaceUtility.createLabel(labelText, labelFont, 0, 0, 0, 0, JLabel.CENTER);
    }

    private JPanel createLevelBrowseNavigationPanel() {
        JPanel navigationPanel = UserInterfaceUtility.createHorizontalPanel();

        levelPageNextButton = UserInterfaceUtility.createButton("", new Dimension(40, 40));
        levelPageNextButton.setIcon(new ImageIcon(rightBrowseIconImage));
        levelPageNextButton.setBorderPainted(false);
        levelPageNextButton.setContentAreaFilled(false);
        levelPageNextButton.setFocusPainted(false);
        levelPageNextButton.setOpaque(false);
        levelPageNextButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        levelPageBackButton = UserInterfaceUtility.createButton("", new Dimension(40, 40));
        levelPageBackButton.setIcon(new ImageIcon(leftBrowseIconImage));
        levelPageBackButton.setBorderPainted(false);
        levelPageBackButton.setContentAreaFilled(false);
        levelPageBackButton.setFocusPainted(false);
        levelPageBackButton.setOpaque(false);
        levelPageBackButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        navigationPanel.setLayout(new BoxLayout(navigationPanel, BoxLayout.LINE_AXIS));
        navigationPanel.add(Box.createRigidArea(new Dimension(12, 0)));

        navigationPanel.add(levelPageBackButton);
        navigationPanel.add(Box.createHorizontalGlue());
        
        navigationPanel.add(levelCurrentPageLabel = createLevelCurrentPageLabel());

        navigationPanel.add(Box.createHorizontalGlue());

        navigationPanel.add(levelPageNextButton);
        navigationPanel.add(Box.createRigidArea(new Dimension(12, 0)));

        navigationPanel.setBackground(Color.GRAY);
        navigationPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); 

        return navigationPanel;
    }

    private JLabel createTitle() {
        String labelText = "Level Select";

        return UserInterfaceUtility.createLabel(labelText, levelSelectTitleFont, 14, 0, 0, 0, JLabel.CENTER);
    }

    public JButton[] getLevelButtons() {
        return levelButtons;
    }

    public JButton getPlayButton() {
        return playButton;
    }

    public JButton getBackToMainMenuButton() {
        return backToMainMenuButton;
    }

    public JButton getLevelPageNextButton() {
        return levelPageNextButton;
    }

    public JButton getLevelPageBackButton() {
        return levelPageBackButton;
    }

    private void updateCurrentPageLabel() {
        int totalLevels = gameHandler.getTotalLevels();
        levelCurrentPageLabel.setText(gameHandler.getCurrentLevelSelectPage() + "/" + (int) (totalLevels / 4 + 1));
    }

    private void updateVisibleLevelButtons(int currentPage) {
        levelVerticalSelectPanel.removeAll(); // Remove all existing components

        levelVerticalSelectPanel.add(Box.createRigidArea(new Dimension(0, 27)));

        int start = (currentPage - 1) * 4; // Calculate the starting index for the current page
        int end = Math.min(start + 4, levelButtons.length); // Calculate the ending index for the current page

        for (int i = start; i < end; i++) {
            levelVerticalSelectPanel.add(levelButtons[i]);

            if (i < levelButtons.length - 1) { // Don't add strut after the last button in the array
                levelVerticalSelectPanel.add(Box.createRigidArea(new Dimension(0, 15)));
            }
        }

        levelVerticalSelectPanel.revalidate(); // Revalidate to apply changes
        levelVerticalSelectPanel.repaint(); // Repaint to apply changes
    }

    private void updateHighScoreLabel(int levelNumber) {
        if (levelNumber < gameHandler.getTotalLevels() + 1 && levelNumber > 0) {
            int highScore = gameHandler.getLevelHighScore(levelNumber);
            highScoreLabel.setText("High Score: " + highScore);
        }
    }

    private void updateDisplay() {
        updateHighScoreLabel(gameHandler.getCurrentSelectedLevelNumber());
        setLevelImage(gameHandler.getCurrentSelectedLevelNumber());
        updateCurrentPageLabel();
        updateVisibleLevelButtons(gameHandler.getCurrentLevelSelectPage());
        levelSelectLabel.setText("Level " + gameHandler.getCurrentSelectedLevelNumber());
    }

    @Override
    public void updateObserver() {
        if (gameHandler.getGameState() == GameState.LEVEL_SELECT) {
            updateDisplay();
        }
    }
}