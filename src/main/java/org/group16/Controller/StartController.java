package org.group16.Controller;

import org.group16.Model.Level.LevelHandler;
import org.group16.View.Panels.StartPanel;

class StartController extends GameController {

    StartController(LevelHandler levelHandler, StartPanel startPanel) {
        super(levelHandler, startPanel);
        startPanel.getContinueButton().addActionListener(e -> {
            levelHandler.continueGame();
        });
        
        startPanel.getNewGameButton().addActionListener(e -> {
            levelHandler.newGame();
        });

        startPanel.getLoadGameButton().addActionListener(e -> {
            levelHandler.loadGame();
        });

        startPanel.getQuitButton().addActionListener(e -> {
            System.exit(0);
        });
    }
  
    @Override
    protected void update() {
        // TODO Auto-generated method stub
    }
    
}