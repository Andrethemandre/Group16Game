package org.group16.Controller;

import org.group16.Model.GameHandling.GameHandler;
import org.group16.View.Panels.StartPanel;

class StartController extends GameController {
    private GameHandler gameHandler;
    private StartPanel startPanel;
    
    StartController(GameHandler gameHandler, StartPanel startPanel) {
        super(gameHandler, startPanel);
        this.gameHandler = gameHandler;
        this.startPanel = startPanel;

        initListeners();
    }
  
    @Override
    public void update() {}

    @Override
    protected void initListeners() {
        startPanel.getContinueButton().addActionListener(e -> {
            gameHandler.continueGame();
        });
        
        startPanel.getNewGameButton().addActionListener(e -> {
            gameHandler.newGame();
        });

        startPanel.getLoadGameButton().addActionListener(e -> {
            gameHandler.loadGame();
        });

        startPanel.getQuitButton().addActionListener(e -> {
            System.exit(0);
        });
    } 
}