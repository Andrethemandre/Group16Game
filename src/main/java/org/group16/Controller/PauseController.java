package org.group16.Controller;

import org.group16.Model.LevelHandling.LevelHandler;
import org.group16.View.Panels.PausePanel;

class PauseController extends GameController{
    private PausePanel pausePanel;
    private LevelHandler levelHandler;

    PauseController(LevelHandler levelHandler, PausePanel pausePanel) {
        super(levelHandler, pausePanel);
        this.pausePanel = pausePanel;
        this.levelHandler = levelHandler;
        
        initListeners();
    }

    @Override
    protected void initListeners() {
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
    public void update() {}
}
