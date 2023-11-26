package org.group16.View;

import java.awt.Color;
import java.util.logging.Level;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import org.group16.Model.GameObjects.GameState;
import org.group16.Model.Level.LevelHandler;
import org.group16.Model.Observers.GameObserver;

public class LevelAndPauseLayer extends JLayeredPane implements GameObserver{
    private LevelPanel levelPanel;
    private PausePanel pausePanel;
    private LevelHandler levelHandler;
    public LevelAndPauseLayer(int x, int y, LevelPanel levelPanel, PausePanel pausePanel, LevelHandler levelHandler) {
        super();
        this.levelHandler = levelHandler;
        this.levelPanel = levelPanel;
        this.pausePanel = pausePanel;
        this.pausePanel.setBackground(Color.red);
        this.setBounds(0, 0, x, y);
        this.setLayout(null);
        levelPanel.setBounds(0, 0, x, y);
        pausePanel.setBounds(200, 100, 100, 100);
        //levelPanel.setOpaque(true);
        //pausePanel.setOpaque(true);
        this.add(levelPanel, JLayeredPane.DEFAULT_LAYER);
        this.add(pausePanel, JLayeredPane.PALETTE_LAYER);
    }
    @Override
    public void updateObserver() {

        if(levelHandler.getGameState() == GameState.PAUSED){
            // Make the pause panel visible when the game is paused
            //System.out.println("pausePanel visible");

            pausePanel.setVisible(true);
        } else {
            // Make the pause panel invisible when the game is not paused
            //System.out.println("pausePanel is not visible");
            pausePanel.setVisible(false);
            //levelPanel.setVisible(true);
        }
    }
    
}
