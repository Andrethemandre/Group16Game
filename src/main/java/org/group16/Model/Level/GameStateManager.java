package org.group16.Model.Level;

import java.util.ArrayList;
import java.util.List;

import org.group16.Model.GameObjects.GameState;
import org.group16.Model.Observers.GameObserver;

public class GameStateManager {
    private List<GameObserver> observers = new ArrayList<>();
    private GameState gameState;
    private long pauseStartTime;
    private long totalPauseTime;


    GameStateManager() {
        gameState = GameState.START;
    }


    public void togglePause() {
        if (gameState == GameState.PLAYING) {
            pauseStartTime = System.currentTimeMillis();
            gameState = GameState.PAUSED;
        } else if (gameState == GameState.PAUSED) {
            totalPauseTime += System.currentTimeMillis() - pauseStartTime;
            gameState = GameState.PLAYING;
        }

        notifyObservers();
    }

    private void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void newGame() {
        // TODO: SAVE SYSTEM
        // Temporary due to lack of save system

        setGameState(GameState.LEVELSELECT);
    }

    public void loadGame() {
        // TODO: SAVE SYSTEM
    }

    public void goToMainMenu() {
        setGameState(GameState.START);
        notifyObservers();
    }

    public void goToLevelSelect() {
        setGameState(GameState.LEVELSELECT);
        notifyObservers();
    }

    public void startGame() {
        setGameState(GameState.PLAYING);
        notifyObservers();
    }

    // Implement a function that increments for every level attempt


    // public void restartGame() {
    //     setLevel(currentLevelNumber);

    //     totalPauseTime = 0;
    //     pauseStartTime = 0;
    //     levelAttempts = 0;
    //     score = 0;
    //     levelStartTime = System.currentTimeMillis();

    //     for (GameObserver o : observers) {
    //         o.updateObserver();
    //     }
    // }

    private void notifyObservers() {
        for (GameObserver o : observers) {
            o.updateObserver();
        }
    }


    public GameState getGameState() {
        return gameState;
    }
}