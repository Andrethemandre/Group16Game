package org.group16.View.Panels;

import java.awt.Color;

import javax.swing.JLayeredPane;

import org.group16.Model.GameObjects.GameState;
import org.group16.Model.LevelHandling.LevelHandler;
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
        
        this.pausePanel.setBackground(Color.gray);
        this.setBounds(0, 0, x, y);
        this.setLayout(null);

        levelPanel.setBounds(0, 0, x, y);
        levelPanel.setLayout(null);

        // PausePanel positioning
        int pausePanelWidth = 400;
        int pausePanelHeight = 400;
        int pausePanelX = (x - pausePanelWidth) / 2;
        int pausePanelY = (y - pausePanelHeight) / 2;

        pausePanel.setBounds(pausePanelX, pausePanelY, pausePanelWidth, pausePanelHeight);

        this.add(levelPanel, JLayeredPane.DEFAULT_LAYER);
        this.add(pausePanel, JLayeredPane.PALETTE_LAYER);
    }
    @Override
    public void updateObserver() {
        if(levelHandler.getGameState() == GameState.PAUSED){
            pausePanel.setVisible(true);
        } else {
            pausePanel.setVisible(false);
        }

        levelPanel.updateObserver();
    }
}
