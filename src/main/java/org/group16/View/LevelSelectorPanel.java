package org.group16.View;

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
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;

import org.group16.Model.GameObjects.GameState;
import org.group16.Model.Level.LevelHandler;
import org.group16.Model.Observers.GameObserver;

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
    private BufferedImage levelImage;
    private BufferedImage firstLevelImage;
    private BufferedImage secondLevelImage;
    private BufferedImage placeHolderImage;

    private JLabel highScoreLabel;

    private JLabel picLabel;

    private static final Dimension LARGE_BUTTON_SIZE = new Dimension(200, 28);
    private static final Dimension SMALL_BUTTON_SIZE = new Dimension(100, 28);
    private static final Font LABEL_FONT = new Font("Arial", Font.BOLD, 30);
    private static final Font BUTTON_FONT = new Font("Arial", Font.BOLD, 14);

    // for defualt set to level 1 display
    public LevelSelectorPanel(int x, int y, LevelHandler levelHandler) {
        super(x, y);
        this.levelHandler = levelHandler;

        try {
            placeHolderImage = ImageIO.read(getClass().getResourceAsStream("/images/level_select/placeholder_level_image.png"));
            firstLevelImage = ImageIO.read(getClass().getResourceAsStream("/images/level_select/level_1_image.png"));
            secondLevelImage = ImageIO.read(getClass().getResourceAsStream("/images/level_select/level_2_image.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        initComponents();
    }

    private void setLevelImage(int levelNumber){
        if(levelNumber == 1){
            picLabel.setIcon(new ImageIcon(firstLevelImage));
        }
        else if(levelNumber == 2){
            picLabel.setIcon(new ImageIcon(secondLevelImage));
        }
        else{
            picLabel.setIcon(new ImageIcon(placeHolderImage));
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

    private JPanel createLevelInfoPanel(){
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
        return ViewUtility.createLabel(labelText, LABEL_FONT, 14, 20, 0, 0, JLabel.CENTER);
    }
    
    private JLabel createLevelImageLabel() {
        //setLevelImage(levelHandler.getCurrentLevelNumber());
        picLabel = new JLabel(new ImageIcon(placeHolderImage));
        picLabel.setBorder(BorderFactory.createEmptyBorder(27, 20, 0, 0)); // Add padding
        return picLabel;
    }
    
    private JLabel createHighScoreLabel() {
        String labelText = "High Score: x";
        return ViewUtility.createLabel(labelText, LABEL_FONT, 15, 20, 0, 0, JLabel.LEFT);
    }
    
    private JPanel createLevelInfoNavigationPanel() {
        JPanel horizontalButtonPanel = ViewUtility.createHorizontalPanel();
        horizontalButtonPanel.setAlignmentX(JButton.CENTER_ALIGNMENT);
        horizontalButtonPanel.setBorder(BorderFactory.createEmptyBorder(100, 20, 0, 0)); // Add padding
        horizontalButtonPanel.setBackground(Color.LIGHT_GRAY);
    
        backToMainMenuButton = ViewUtility.createButton("Back to Main Menu", LARGE_BUTTON_SIZE);
        backToMainMenuButton.setFont(BUTTON_FONT);
        horizontalButtonPanel.add(backToMainMenuButton);
    
        horizontalButtonPanel.add(Box.createRigidArea(new Dimension(175, 0))); // Add space after button
    
        playButton = ViewUtility.createButton("Play", SMALL_BUTTON_SIZE);
        playButton.setFont(BUTTON_FONT);

        horizontalButtonPanel.add(playButton);
    
        return horizontalButtonPanel;
    }

    private void initLevelButtons(){
        levelButtons = new JButton[levelHandler.getTotalLevels()];

        for (int i = 0; i < levelButtons.length; i++) {
            levelButtons[i] = ViewUtility.createButton("Level " + (i+1), new Dimension(200, 55));
        }
    }
    
    private JPanel createLevelBrowseMenu(){
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
        levelBrowseMenu.add(navigationPanel,BorderLayout.SOUTH);
        return levelBrowseMenu;
    }

    private void initLevelSelectPanel(int currentPage){
        levelVerticalSelectPanel = ViewUtility.createVerticalPanel();
        levelVerticalSelectPanel.add(Box.createVerticalStrut(27));   
    
        int start = (currentPage - 1) * 4; // Calculate the starting index for the current page
        int end = Math.min(start + 4, levelButtons.length); // Calculate the ending index for the current page
    
        for (int i = start; i < end; i++) {
            levelVerticalSelectPanel.add(levelButtons[i]);
    
            if (i < end - 1) { // Don't add strut after the last button
                levelVerticalSelectPanel.add(Box.createVerticalStrut(15)); // Add 10px vertical gap
            }
        }
    }
    private void updateCurrentPageLabel(){
        int totalLevels = levelHandler.getTotalLevels();
        levelCurrentPageLabel.setText(levelHandler.getCurrentLevelSelectPage() + "/" +  (int) (totalLevels/4 + 1));
    }
    private JLabel createLevelCurrentPageLabel(){
        int totalLevels = levelHandler.getTotalLevels();
        String labelText = levelHandler.getCurrentLevelSelectPage() + "/" +  (int) (totalLevels/4 + 1);
        Font labelFont = new Font("Arial", Font.PLAIN, 14);

        return ViewUtility.createLabel(labelText, labelFont,0,0,0,0, JLabel.CENTER);
    }

    private JPanel createLevelBrowseNavigationPanel(){
        JPanel navigationPanel = ViewUtility.createHorizontalPanel();

        levelPageNextButton = ViewUtility.createButton("Next", new Dimension(60, 50));
        levelPageBackButton = ViewUtility.createButton("Back", new Dimension(60, 50));

        navigationPanel.setLayout(new BoxLayout(navigationPanel, BoxLayout.LINE_AXIS));
        navigationPanel.add(levelPageBackButton);
        navigationPanel.add(Box.createHorizontalGlue());

        Font labelFont3 = new Font("Arial", Font.PLAIN, 14);
        navigationPanel.add(levelCurrentPageLabel = createLevelCurrentPageLabel());
        navigationPanel.add(Box.createHorizontalGlue());

        navigationPanel.add(levelPageNextButton);

        navigationPanel.setBackground(Color.GRAY);
        navigationPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); // Add padding

        return navigationPanel;
    }

    private JLabel createTitle(){
        String labelText = "Level Select";
        Font labelFont = new Font("Arial", Font.BOLD, 30);

        return ViewUtility.createLabel(labelText, labelFont,14,0,0,0, JLabel.CENTER);
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

        levelVerticalSelectPanel.add(Box.createVerticalStrut(27));   
    
        int start = (currentPage - 1) * 4; // Calculate the starting index for the current page
        int end = Math.min(start + 4, levelButtons.length); // Calculate the ending index for the current page
    
        for (int i = start; i < end; i++) {
            levelVerticalSelectPanel.add(levelButtons[i]);
    
            if (i < end - 1) { // Don't add strut after the last button
                levelVerticalSelectPanel.add(Box.createVerticalStrut(15)); // Add 10px vertical gap
            }
        }

        levelVerticalSelectPanel.revalidate(); // Revalidate to apply changes
        levelVerticalSelectPanel.repaint(); // Repaint to apply changes
    }

    private void updateHighScoreLabel(int levelNumber) {
        if(levelNumber < levelHandler.getTotalLevels() + 1 && levelNumber > 0){
            int highScore = levelHandler.getLevelHighScore(levelNumber);
            highScoreLabel.setText("High Score: " + highScore);
        }
    }

    private void updateDisplay(){
        updateHighScoreLabel(levelHandler.getCurrentLevelNumber());
        setLevelImage(levelHandler.getCurrentLevelNumber());
        updateCurrentPageLabel();
        updateVisibleLevelButtons(levelHandler.getCurrentLevelSelectPage());
        levelSelectLabel.setText("Level " + levelHandler.getCurrentLevelNumber());
    }

    @Override
    public void updateObserver() {
        if(levelHandler.getGameState() == GameState.LEVEL_SELECT){
            updateDisplay();
            repaint();
        }
    }
}