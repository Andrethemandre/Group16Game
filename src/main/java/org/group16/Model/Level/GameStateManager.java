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

    // public void startGame() {
    //     setLevel(1);

    //     totalPauseTime = 0;
    //     pauseStartTime = 0;
    //     levelAttempts = 0;
    //     score = 0;
    //     levelStartTime = System.currentTimeMillis();
    // }


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
    private void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void loadGame() {
        setGameState(GameState.LEVELSELECT);

        for (GameObserver o : observers) {
            o.updateObserver();
        }
    }

    public void goToMainMenu() {
        setGameState(GameState.START);
        notifyObservers();
    }

    private void notifyObservers() {
        for (GameObserver o : observers) {
            o.updateObserver();
        }
    }
}