package org.group16.Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import org.group16.Model.Level.LevelHandler;
import org.group16.View.PausePanel;

public class PauseController extends GameController implements KeyListener{
    private PausePanel pausePanel;
    private LevelHandler levelHandler;

    public PauseController(LevelHandler levelHandler, PausePanel pausePanel) {
        super(levelHandler, pausePanel);

        this.pausePanel = pausePanel;
        this.levelHandler = levelHandler;

        pausePanel.getResumeButton().addActionListener(e -> {
            //System.out.println("resume button");
            levelHandler.togglePause();
        });

        pausePanel.getRestartButton().addActionListener(e -> {
            //System.out.println("restart button");
            levelHandler.restartGame();
        });

        pausePanel.getMainMenuButton().addActionListener(e -> {
            //System.out.println("main menu button");
            levelHandler.goToMainMenu();
        });

        pausePanel.getSettingsButton().addActionListener(e -> {
            //System.out.println("settings button");
        });

        pausePanel.getQuitButton().addActionListener(e -> {
            //System.out.println("quit button");
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
    }


    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }
}
