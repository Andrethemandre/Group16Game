package org.group16.Model.LevelHandling;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.group16.Model.GameObjects.GameState;
import org.group16.Model.LevelHandling.LevelHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LevelHandlerTest {
    private LevelHandler levelHandler;

    @BeforeEach
    void setUp() {
        levelHandler = new LevelHandler();
        levelHandler.startGame();
    }

    @Test
    void testLevelHandlerStartsWithFirstLevel() {
        assertTrue(levelHandler.getCurrentLevelNumber() == 1);
    }

    @Test
    void testLevelHandlerTogglePause() {
        levelHandler.togglePause();
        assertTrue(levelHandler.getGameState() == GameState.PAUSED);
    }

    @Test
    void testLevelHandlerTogglePauseTwice() {
        levelHandler.togglePause();
        levelHandler.togglePause();
        assertTrue(levelHandler.getGameState() == GameState.PLAYING);
    }

    @Test
    void testLevelHandlerStartsWithZeroAttempts() {
        assertTrue(levelHandler.getCurrentAttempts() == 0);
    }

    @Test
    void testLevelHandlerStartsWithZeroScore() {
        assertTrue(levelHandler.getCurrentScore() == 0);
    }
}
