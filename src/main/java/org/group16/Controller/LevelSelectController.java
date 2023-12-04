package org.group16.Controller;

import org.group16.Model.Level.LevelHandler;
import org.group16.View.LevelSelectorPanel;

public class LevelSelectController extends GameController{

    public LevelSelectController(LevelHandler levelHandler, LevelSelectorPanel levelSelectorPanel) {
        super(levelHandler, levelSelectorPanel);

        for (int i = 0; i < levelSelectorPanel.getLevelButtons().length; i++) {
            int levelNumber = i;

            levelSelectorPanel.getLevelButtons()[i].addActionListener(e -> {
                levelHandler.setCurrentLevelNumber(levelNumber + 1);
                levelHandler.notifyObservers();
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
    protected void update() {
        // TODO Auto-generated method stub

    }
    
}
