package org.group16.View;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import org.group16.Model.GameObjects.GameState;
import org.group16.Model.Level.FirstLevel;
import org.group16.Model.Level.LevelHandler;
import org.group16.Model.Observers.GameObserver;

public class GameWindow extends JFrame implements GameObserver{
    // Offsets makes it display correctly
    // The y one makes since because it accounts for the
    // top of the window, however I don't know why
    // an X offset would be needed, maybe we
    // did some wrong calculation?
    private static final int WINDOW_OFFSET_X = 16;
    private static final int WINDOW_OFFSET_Y = 40;

    private static final int X = 720 + WINDOW_OFFSET_X;
    private static final int Y = 480 + WINDOW_OFFSET_Y;

    // mainScreen that changes depending on type of panel (for now it is just a screen of a level)
    private GamePanel mainScreen;
    private LevelHandler levelHandler;
    private StartPanel startPanel;
    private LevelPanel levelPanel;

    private PausePanel pausePanel;
    private JLayeredPane layeredPane;
    private LevelAndPauseLayer levelAndPauseLayer;
    private CardLayout cardLayout;
    private JPanel cards;

    public GameWindow(String windowName, LevelHandler levelHandler){
        this.levelHandler = levelHandler;
        this.startPanel = new StartPanel(X, Y);

        this.levelPanel = new LevelPanel(X, Y, levelHandler);
        this.pausePanel = new PausePanel(X,Y);
        this.levelAndPauseLayer = new LevelAndPauseLayer(X, Y, levelPanel, pausePanel, levelHandler);
        this.levelHandler.addObserver(levelAndPauseLayer);
        // this.layeredPane = new JLayeredPane();
        // layeredPane.add(levelPanel, JLayeredPane.DEFAULT_LAYER);
        // layeredPane.add(startPanel, JLayeredPane.PALETTE_LAYER);

        this.mainScreen = startPanel;

        this.cardLayout = new CardLayout();
        this.cards = new JPanel(cardLayout);

        cards.add(startPanel, "START");
        cards.add(levelAndPauseLayer, "PLAYING");
        //cards.add(layeredPane, "PLAYING");


        //this.mainScreen = new LevelPanel(X, Y, levelHandler);

        initComponents(windowName);
        levelAndPauseLayer.setBounds(getBounds());
        this.requestFocusInWindow();
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

    public GamePanel getMainScreen(){
        return mainScreen;
    }

    // Sets everything in place and fits everything
    private void initComponents(String title) {    
        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.setVisible(true);
        this.add(cards);
        this.setFocusable(true);
        mainScreen.setPreferredSize(getPreferredSize());

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


    @Override
    public void updateObserver() {
        if(levelHandler.getGameState() == GameState.START){
            cardLayout.show(cards, "START");
        } 
        else if(levelHandler.getGameState() == GameState.PLAYING){
            cardLayout.show(cards, "PLAYING");
        }

        repaint();
    }

}