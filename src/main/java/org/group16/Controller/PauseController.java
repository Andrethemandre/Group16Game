package org.group16.Controller;

import org.group16.Model.Level.LevelHandler;
import org.group16.View.PausePanel;

class PauseController extends GameController{
    private PausePanel pausePanel;
    private LevelHandler levelHandler;

    PauseController(LevelHandler levelHandler, PausePanel pausePanel) {
        super(levelHandler, pausePanel);

        this.pausePanel = pausePanel;
        this.levelHandler = levelHandler;

        pausePanel.getResumeButton().addActionListener(e -> {
            levelHandler.togglePause();
        });

        pausePanel.getRestartButton().addActionListener(e -> {
            levelHandler.restartGame();
        });

        pausePanel.getLevelSelectButton().addActionListener(e -> {
            levelHandler.goToLevelSelect();
        });

        pausePanel.getMainMenuButton().addActionListener(e -> {
            levelHandler.goToMainMenu();
        });

        pausePanel.getSettingsButton().addActionListener(e -> {
        });

        pausePanel.getQuitButton().addActionListener(e -> {
            System.exit(0);
        });
    }

    @Override
    protected void update() {
        // TODO Auto-generated method stub
    }
}
