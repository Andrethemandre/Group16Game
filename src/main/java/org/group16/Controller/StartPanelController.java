package org.group16.Controller;

import org.group16.Model.Level.LevelHandler;
import org.group16.View.GameWindow;
import org.group16.View.StartPanel;

public class StartPanelController extends GameController {

    public StartPanelController(LevelHandler levelHandler, StartPanel startPanel) {
        super(levelHandler, startPanel);

        startPanel.getPlayButton().addActionListener(e -> {
            levelHandler.startGame();
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