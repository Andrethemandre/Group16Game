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

import org.group16.Model.GameObjects.GameState;
import org.group16.Model.Level.LevelHandler;
import org.group16.Model.Observers.GameObserver;
import org.group16.View.ViewUtility;

public class LevelSelectorPanel extends GamePanel implements GameObserver {
    private LevelHandler levelHandler;

    private JLabel levelSelectTitle;
    private JLabel levelLabel;
    private JButton playButton;
    private JButton backToMainMenuButton;

    private JButton[] levelButtons;
    private JButton[] difficultyButtons;
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

    private Font currentSelectedLevelFont;
    private Font levelSelectTitleFont;

    private JLabel highScoreLabel;

    private JLabel picLabel;

    private static final Dimension LARGE_BUTTON_SIZE = new Dimension(200, 28);
    private static final Dimension SMALL_BUTTON_SIZE = new Dimension(100, 28);
    private static final Font LABEL_FONT = new Font("Arial", Font.BOLD, 24);
    private static final Font BUTTON_FONT = new Font("Arial", Font.BOLD, 14);

    // for defualt set to level 1 display
    public LevelSelectorPanel(int x, int y, LevelHandler levelHandler) {
        super(x, y);
        this.levelHandler = levelHandler;

        initFont();
        initImages();
        initComponents();
    }

    private void initFont(){
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/ARCADECLASSIC.TTF"));
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

    private void initComponents() {
        setLayout(new BorderLayout());
        initLevelButtons();
        JPanel levelBrowseMenu = createLevelBrowseMenu();
        JPanel levelInfoPanel = createLevelInfoPanel();
        
        add(levelBrowseMenu, BorderLayout.WEST);
        add(levelInfoPanel, BorderLayout.CENTER);
    }

    public JButton[] getLevelButtons() {
        return levelButtons;
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
        return ViewUtility.createLabel(labelText, currentSelectedLevelFont, 14, 20, 0, 0, JLabel.CENTER);
    }

    private JLabel createLevelImageLabel() {
        picLabel = new JLabel(new ImageIcon(placeHolderImage));
        picLabel.setBorder(BorderFactory.createEmptyBorder(27, 20, 0, 0)); 
        return picLabel;
    }

    private JLabel createHighScoreLabel() {
        String labelText = "High Score: x";
        return ViewUtility.createLabel(labelText, new Font("Arial", Font.BOLD, 20), 15, 20, 0, 0, JLabel.LEFT);
    }

    private JPanel createLevelInfoNavigationPanel() {
        Font font = new Font(null, Font.PLAIN, 12);
        JPanel horizontalButtonPanel = ViewUtility.createHorizontalPanel();
        horizontalButtonPanel.setAlignmentX(JButton.CENTER_ALIGNMENT);
        horizontalButtonPanel.setBorder(BorderFactory.createEmptyBorder(125, 20, 0, 0)); 
        horizontalButtonPanel.setBackground(Color.LIGHT_GRAY);

        backToMainMenuButton = ViewUtility.createButton("Back to Main Menu", LARGE_BUTTON_SIZE, font);
        backToMainMenuButton.setFont(BUTTON_FONT);
        horizontalButtonPanel.add(backToMainMenuButton);

        horizontalButtonPanel.add(Box.createRigidArea(new Dimension(175, 0)));

        playButton = ViewUtility.createButton("Play", SMALL_BUTTON_SIZE, font);
        playButton.setFont(BUTTON_FONT);

        horizontalButtonPanel.add(playButton);

        return horizontalButtonPanel;
    }

    private void initLevelButtons() {
        levelButtons = new JButton[levelHandler.getTotalLevels()];
        Font font = new Font(null, Font.PLAIN, 20);
        for (int i = 0; i < levelButtons.length; i++) {
           
            levelButtons[i] = ViewUtility.createButton("Level " + (i + 1), new Dimension(175, 55), font);
        }
    }

    private JPanel createLevelBrowseMenu() {
        JPanel levelBrowseMenu = new JPanel();
        levelBrowseMenu.setLayout(new BorderLayout());

        levelSelectLabel = createTitle();
        levelBrowseMenu.add(levelSelectLabel, BorderLayout.NORTH);

        initLevelSelectPanel(1);

        JPanel navigationPanel = createLevelBrowseNavigationPanel();

        levelVerticalSelectPanel.setBackground(Color.GRAY);
        levelBrowseMenu.setBackground(Color.GRAY);
        levelBrowseMenu.add(levelVerticalSelectPanel, BorderLayout.CENTER);
        navigationPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 60, 0)); // Add padding
        levelBrowseMenu.add(navigationPanel, BorderLayout.SOUTH);

        return levelBrowseMenu;
    }

    private void initLevelSelectPanel(int currentPage) {
        levelVerticalSelectPanel = ViewUtility.createVerticalPanel();
        
        levelVerticalSelectPanel.add(Box.createRigidArea(new Dimension(0, 27)));

        levelVerticalSelectPanel.setPreferredSize(new Dimension(200, levelVerticalSelectPanel.getPreferredSize().height));
        int start = (currentPage - 1) * 4; // Calculate the starting index for the current page
        int end = Math.min(start + 4, levelButtons.length); // Calculate the ending index for the current page

        for (int i = start; i < end; i++) {
            levelVerticalSelectPanel.add(levelButtons[i]);

            if (i < end - 1) { // Don't add strut after the last button
                levelVerticalSelectPanel.add(Box.createRigidArea(new Dimension(0, 15)));
            }
        }
    }

    private void updateCurrentPageLabel() {
        int totalLevels = levelHandler.getTotalLevels();
        levelCurrentPageLabel.setText(levelHandler.getCurrentLevelSelectPage() + "/" + (int) (totalLevels / 4 + 1));
    }

    private JLabel createLevelCurrentPageLabel() {
        int totalLevels = levelHandler.getTotalLevels();
        String labelText = levelHandler.getCurrentLevelSelectPage() + "/" + (int) (totalLevels / 4 + 1);
        Font labelFont = new Font("Arial", Font.PLAIN, 20);

        return ViewUtility.createLabel(labelText, labelFont, 0, 0, 0, 0, JLabel.CENTER);
    }

    private JPanel createLevelBrowseNavigationPanel() {
        JPanel navigationPanel = ViewUtility.createHorizontalPanel();

        levelPageNextButton = ViewUtility.createButton("", new Dimension(40, 40));
        levelPageNextButton.setIcon(new ImageIcon(rightBrowseIconImage));
        levelPageNextButton.setBorderPainted(false);
        levelPageNextButton.setContentAreaFilled(false);
        levelPageNextButton.setFocusPainted(false);
        levelPageNextButton.setOpaque(false);
        levelPageNextButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        levelPageBackButton = ViewUtility.createButton("", new Dimension(40, 40));
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

        return ViewUtility.createLabel(labelText, levelSelectTitleFont, 14, 0, 0, 0, JLabel.CENTER);
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
        if (levelNumber < levelHandler.getTotalLevels() + 1 && levelNumber > 0) {
            int highScore = levelHandler.getLevelHighScore(levelNumber);
            highScoreLabel.setText("High Score: " + highScore);
        }
    }

    private void updateDisplay() {
        updateHighScoreLabel(levelHandler.getCurrentSelectedLevelNumber());
        setLevelImage(levelHandler.getCurrentSelectedLevelNumber());
        updateCurrentPageLabel();
        updateVisibleLevelButtons(levelHandler.getCurrentLevelSelectPage());
        levelSelectLabel.setText("Level " + levelHandler.getCurrentSelectedLevelNumber());
    }

    @Override
    public void updateObserver() {
        if (levelHandler.getGameState() == GameState.LEVEL_SELECT) {
            updateDisplay();
        }
    }
}