package org.group16.View.Panels;

import java.awt.Color;

import javax.swing.JLayeredPane;

import org.group16.Model.GameHandling.GameHandler;
import org.group16.Model.GameObjects.GameState;
import org.group16.Model.Observers.GameObserver;

public class LevelLayer extends JLayeredPane implements GameObserver{
    private LevelPanel levelPanel;
    private PausePanel pausePanel;
    private GameHandler gameHandler;

    public LevelLayer(int x, int y, LevelPanel levelPanel, PausePanel pausePanel, GameHandler gameHandler) {
        super();
        this.gameHandler = gameHandler;
        this.levelPanel = levelPanel;
        this.pausePanel = pausePanel;
        this.pausePanel.setBackground(Color.gray);

        this.setBounds(0, 0, x, y);

        levelPanel.setBounds(0, 0, x, y);

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
        if(gameHandler.getGameState() == GameState.PAUSED){
            pausePanel.setVisible(true);
        } else {
            pausePanel.setVisible(false);
        }

        levelPanel.updateObserver();
    }
}