package org.group16.Model.Level;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.group16.Model.GameObjects.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LevelHandlerTest {
    private LevelHandler levelHandler;

    @BeforeEach
    void setUp() {
        levelHandler = new LevelHandler();
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

    // Currently fails because a test value is used in LevelHandler instead of zero.
    @Test
    void testLevelHandlerStartsWithZeroScore() {
        assertTrue(levelHandler.getScore() == 0);
    }
}
