package org.group16.Model.GameHandling;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.group16.Model.GameHandling.GameHandler;
import org.group16.Model.GameObjects.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameHandlerTest {
    private GameHandler gameHandler;

    @BeforeEach
    void setUp() {
        gameHandler = new GameHandler();
        gameHandler.startGame();
    }

    @Test
    void testLevelHandlerStartsWithFirstLevel() {
        assertTrue(gameHandler.getCurrentLevelNumber() == 1);
    }

    @Test
    void testLevelHandlerTogglePause() {
        gameHandler.togglePause();
        assertTrue(gameHandler.getGameState() == GameState.PAUSED);
    }

    @Test
    void testLevelHandlerTogglePauseTwice() {
        gameHandler.togglePause();
        gameHandler.togglePause();
        assertTrue(gameHandler.getGameState() == GameState.PLAYING);
    }

    @Test
    void testLevelHandlerStartsWithZeroAttempts() {
        assertTrue(gameHandler.getCurrentAttempts() == 0);
    }

    @Test
    void testLevelHandlerStartsWithZeroScore() {
        assertTrue(gameHandler.getCurrentScore() == 0);
    }
}
