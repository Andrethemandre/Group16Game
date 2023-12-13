package org.group16.Model.LevelHandling;

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
        // TODO: SAVE SYSTEM, continue the game depending on where the application was last left off 
        setGameState(GameState.LEVEL_SELECT);
    }
    public void newGame() {
        // TODO: SAVE SYSTEM
    }

    public void loadGame() {
        // TODO: SAVE SYSTEM
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