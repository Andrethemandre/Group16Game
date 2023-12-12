package org.group16.Controller;

import org.group16.Model.LevelHandling.LevelHandler;
import org.group16.View.Panels.LevelSelectorPanel;

class LevelSelectController extends GameController{
    private LevelHandler levelHandler;
    private LevelSelectorPanel levelSelectorPanel;

    LevelSelectController(LevelHandler levelHandler, LevelSelectorPanel levelSelectorPanel) {
        super(levelHandler, levelSelectorPanel);
        this.levelHandler = levelHandler;
        this.levelSelectorPanel = levelSelectorPanel;

        initListeners();
    }
    
    @Override
    protected void initListeners() {
        for (int i = 0; i < levelSelectorPanel.getLevelButtons().length; i++) {
            int levelNumber = i;

            levelSelectorPanel.getLevelButtons()[i].addActionListener(e -> {
                levelHandler.setSelectLevelNumber(levelNumber + 1);
                levelHandler.setCurrentLevelNumber(levelNumber + 1);
            });
        }

        levelSelectorPanel.getPlayButton().addActionListener(e -> {
            levelHandler.startGame();
        });

        levelSelectorPanel.getBackToMainMenuButton().addActionListener(e -> {
            levelHandler.goToMainMenu();
        });

        levelSelectorPanel.getLevelPageNextButton().addActionListener(e -> {
            levelHandler.nextLevelSelectPage();
        });

        levelSelectorPanel.getLevelPageBackButton().addActionListener(e -> {
            levelHandler.previousLevelSelectPage();
        });
    }

    @Override
    protected void update() {}
}
