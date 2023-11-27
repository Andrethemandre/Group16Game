package org.group16.Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.GameState;
import org.group16.Model.Level.LevelHandler;
import org.group16.View.PausePanel;
import org.group16.View.StartPanel;

public class PausePanelController extends GameController implements KeyListener{
    private PausePanel pausePanel;
    private LevelHandler levelHandler;
    public PausePanelController(LevelHandler levelHandler, PausePanel pausePanel) {
        super(levelHandler, pausePanel);

        this.pausePanel = pausePanel;
        this.levelHandler = levelHandler;

        pausePanel.getResumeButton().addActionListener(e -> {
            System.out.println("resume button");
            levelHandler.togglePause();
        });

        pausePanel.getRestartButton().addActionListener(e -> {
            levelHandler.restartGame();
        });

        pausePanel.getMainMenuButton().addActionListener(e -> {
            levelHandler.goToMainMenu();
        });

        // pausePanel.getSettingsButton().addActionListener(e -> {
        //     levelHandler.goToSettings();
        // });

        pausePanel.getQuitButton().addActionListener(e -> {
            System.out.println("quit button");
            System.exit(0);
        });
    }

    
    @Override
    protected void update() {
        // TODO Auto-generated method stub

    }


    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }


    @Override
    public void keyPressed(KeyEvent e) {
        // // TODO Auto-generated method stub
        // System.out.println("pause panel");
        // switch(e.getKeyCode()) {
        //     case KeyEvent.VK_ESCAPE:
        //         levelHandler.togglePause();
        //         break;
        // }
    }


    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }
}
