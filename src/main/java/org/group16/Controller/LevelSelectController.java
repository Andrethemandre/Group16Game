package org.group16.Controller;

import org.group16.Model.GameHandling.GameHandler;
import org.group16.View.Panels.LevelSelectorPanel;

class LevelSelectController extends GameController{
    private GameHandler gameHandler;
    private LevelSelectorPanel levelSelectorPanel;

    LevelSelectController(GameHandler gameHandler, LevelSelectorPanel levelSelectorPanel) {
        super(gameHandler, levelSelectorPanel);
        this.gameHandler = gameHandler;
        this.levelSelectorPanel = levelSelectorPanel;

        initListeners();
    }
    
    @Override
    protected void initListeners() {
        for (int i = 0; i < levelSelectorPanel.getLevelButtons().length; i++) {
            int levelNumber = i;

            levelSelectorPanel.getLevelButtons()[i].addActionListener(e -> {
                gameHandler.setSelectLevelNumber(levelNumber + 1);
                gameHandler.setCurrentLevelNumber(levelNumber + 1);
            });
        }

        levelSelectorPanel.getPlayButton().addActionListener(e -> {
            gameHandler.startGame();
        });

        levelSelectorPanel.getBackToMainMenuButton().addActionListener(e -> {
            gameHandler.goToMainMenu();
        });

        levelSelectorPanel.getLevelPageNextButton().addActionListener(e -> {
            gameHandler.nextLevelSelectPage();
        });

        levelSelectorPanel.getLevelPageBackButton().addActionListener(e -> {
            gameHandler.previousLevelSelectPage();
        });
    }

    @Override
    protected void update() {}
}
