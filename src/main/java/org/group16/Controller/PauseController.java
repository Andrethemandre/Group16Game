package org.group16.Controller;

import org.group16.Model.GameHandling.GameHandler;
import org.group16.View.Panels.PausePanel;

class PauseController extends GameController{
    private PausePanel pausePanel;
    private GameHandler gameHandler;

    PauseController(GameHandler gameHandler, PausePanel pausePanel) {
        super(gameHandler, pausePanel);
        this.pausePanel = pausePanel;
        this.gameHandler = gameHandler;
        
        initListeners();
    }

    @Override
    protected void initListeners() {
        pausePanel.getResumeButton().addActionListener(e -> {
            gameHandler.togglePause();
        });

        pausePanel.getRestartButton().addActionListener(e -> {
            gameHandler.restartGame();
        });

        pausePanel.getLevelSelectButton().addActionListener(e -> {
            gameHandler.goToLevelSelect();
        });

        pausePanel.getMainMenuButton().addActionListener(e -> {
            gameHandler.goToMainMenu();
        });

        pausePanel.getSettingsButton().addActionListener(e -> {
        });

        pausePanel.getQuitButton().addActionListener(e -> {
            System.exit(0);
        });
    }

    @Override
    public void update() {}
}
