package org.group16.Controller;

import org.group16.Model.Level.LevelHandler;
import org.group16.View.Panels.StartPanel;

class StartController extends GameController {
    private LevelHandler levelHandler;
    private StartPanel startPanel;
    
    StartController(LevelHandler levelHandler, StartPanel startPanel) {
        super(levelHandler, startPanel);
        this.levelHandler = levelHandler;
        this.startPanel = startPanel;

        initListeners();
    }
  
    @Override
    public void update() {}

    @Override
    protected void initListeners() {
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
}