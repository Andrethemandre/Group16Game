package org.group16.Controller;

import org.group16.Model.Level.LevelHandler;
import org.group16.View.GamePanel;
import org.group16.View.LevelSelectorPanel;

public class LevelSelectController extends GameController{

    public LevelSelectController(LevelHandler levelHandler, LevelSelectorPanel levelSelectorPanel) {
        super(levelHandler, levelSelectorPanel);

        for (int i = 0; i < levelSelectorPanel.getLevelButtons().length; i++) {
            int levelNumber = i;

            levelSelectorPanel.getLevelButtons()[i].addActionListener(e -> {
                levelHandler.setLevel(levelNumber + 1);
            });
        }
    }

    @Override
    protected void update() {
        // TODO Auto-generated method stub

    }
    
}
