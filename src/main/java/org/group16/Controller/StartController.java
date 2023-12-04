package org.group16.Controller;

import org.group16.Model.Level.LevelHandler;
import org.group16.View.StartPanel;

class StartController extends GameController {

    StartController(LevelHandler levelHandler, StartPanel startPanel) {
        super(levelHandler, startPanel);

        startPanel.getPlayButton().addActionListener(e -> {
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