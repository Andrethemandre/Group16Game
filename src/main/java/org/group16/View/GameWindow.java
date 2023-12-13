package org.group16.View;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.group16.Model.GameObjects.GameState;
import org.group16.Model.LevelHandling.LevelHandler;
import org.group16.Model.Observers.GameObserver;
import org.group16.View.Panels.LevelLayer;
import org.group16.Model.Utility.Settings;
import org.group16.View.Panels.LevelPanel;
import org.group16.View.Panels.LevelSelectorPanel;
import org.group16.View.Panels.PausePanel;
import org.group16.View.Panels.StartPanel;

public class GameWindow extends JFrame implements GameObserver{
    // Offsets makes it display correctly
    private static final int WINDOW_OFFSET_X = 14;
    private static final int WINDOW_OFFSET_Y = 38;

    private static final int X = Settings.GAME_WIDTH + WINDOW_OFFSET_X;
    private static final int Y = Settings.GAME_HEIGHT + WINDOW_OFFSET_Y;

    // mainScreen that changes depending on type of panel 
    private CardLayout mainScreen;
    private LevelHandler levelHandler;
    private StartPanel startPanel;
    private LevelPanel levelPanel;
    private LevelSelectorPanel levelSelectorPanel;

    private PausePanel pausePanel;
    private LevelLayer levelLayer;
    private JPanel cards;

    public GameWindow(String windowName, LevelHandler levelHandler){
        this.levelHandler = levelHandler;

        this.startPanel = new StartPanel(X, Y, levelHandler);
        this.levelPanel = new LevelPanel(X, Y, levelHandler);
        this.pausePanel = new PausePanel(X,Y);
        this.levelSelectorPanel = new LevelSelectorPanel(X,Y, levelHandler);
        this.levelLayer = new LevelLayer(X, Y, levelPanel, pausePanel, levelHandler);

        this.levelHandler.addObserver(startPanel);
        this.levelHandler.addObserver(levelLayer);
        this.levelHandler.addObserver(levelSelectorPanel);

        this.mainScreen = new CardLayout();
        this.cards = new JPanel(mainScreen);

        cards.add(startPanel, "START");
        cards.add(levelLayer, "PLAYING");
        cards.add(levelSelectorPanel, "LEVEL_SELECT");

        initComponents(windowName);
        levelLayer.setBounds(getBounds());
        this.requestFocusInWindow();
        this.setResizable(false);
    }

    // Sets everything in place and fits everything
    private void initComponents(String title) {    
        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.setVisible(true);
        this.add(cards);
        this.setFocusable(true);

        levelPanel.setPreferredSize(getPreferredSize());
        startPanel.setPreferredSize(getPreferredSize());

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public StartPanel getStartPanel(){
        return startPanel;
    }

    public PausePanel getPausePanel(){
        return pausePanel;
    }

    public LevelPanel getLevelPanel(){
        return levelPanel;
    }

    public LevelSelectorPanel getLevelSelectPanel(){
        return levelSelectorPanel;
    }

    public CardLayout getMainScreen(){
         return mainScreen;
    }

    @Override
    public void updateObserver() {
        if(levelHandler.getGameState() == GameState.START){
            mainScreen.show(cards, "START");
        } 
        else if(levelHandler.getGameState() == GameState.PLAYING){
            mainScreen.show(cards, "PLAYING");
        }
        else if(levelHandler.getGameState() == GameState.LEVEL_SELECT){
            mainScreen.show(cards, "LEVEL_SELECT");
        }

        repaint();
    }
}