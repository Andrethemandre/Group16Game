package org.group16.Model.Level;

import java.util.ArrayList;
import java.util.List;

import org.group16.Model.GameObjects.GameState;
import org.group16.Model.Observers.GameObserver;

public class GameStateManager {
    private List<GameObserver> observers = new ArrayList<>();
    private GameState gameState;

    GameStateManager() {
        gameState = GameState.START;
    }

    public void togglePause() {
        if (gameState == GameState.PLAYING) {
            gameState = GameState.PAUSED;
        } 
        else if (gameState == GameState.PAUSED) {
            gameState = GameState.PLAYING;
        }

        notifyObservers();
    }

    private void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void continueGame() {
        setGameState(GameState.LEVEL_SELECT);
    }
    public void newGame() {
        // TODO: SAVE SYSTEM
        // Temporary due to lack of save system

        // setGameState(GameState.LEVEL_SELECT);
    }

    public void loadGame() {
        // TODO: SAVE SYSTEM
    }

    public void goToMainMenu() {
        setGameState(GameState.START);
        notifyObservers();
    }

    public void goToLevelSelect() {
        setGameState(GameState.LEVEL_SELECT);
        notifyObservers();
    }

    public void startGame() {
        setGameState(GameState.PLAYING);
        notifyObservers();
    }

    private void notifyObservers() {
        for (GameObserver o : observers) {
            o.updateObserver();
        }
    }

    public GameState getGameState() {
        return gameState;
    }
}