package org.group16.Model.Level;

import org.group16.Model.GameObjects.GameState;

public class GameStateManager {
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
    }

    private void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void continueGame() {
        setGameState(GameState.LEVEL_SELECT);
    }
    public void newGame() {

        // Temporary due to lack of save system

        // setGameState(GameState.LEVEL_SELECT);
    }

    public void loadGame() {

    }

    public void goToMainMenu() {
        setGameState(GameState.START);
    }

    public void goToLevelSelect() {
        setGameState(GameState.LEVEL_SELECT);
    }

    public void startGame() {
        setGameState(GameState.PLAYING);
    }

    public GameState getGameState() {
        return gameState;
    }
}