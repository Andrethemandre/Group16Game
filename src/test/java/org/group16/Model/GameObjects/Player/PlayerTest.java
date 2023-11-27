package org.group16.Model.GameObjects.Player;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.group16.Model.GameObjects.Direction;
import org.group16.Model.Level.LevelHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    private LevelHandler levelHandler;
    private Player player;

    @BeforeEach
    void setUp() {
        levelHandler = new LevelHandler();
        player = levelHandler.getPlayer();
    }

    @Test
    void testPlayerMoveRight() {
        int startX = player.getX();
        player.startMovingInDirection(Direction.RIGHT);
        levelHandler.update();
        assertTrue(player.getX() > startX);
    }
    @Test
    void testPlayerMoveLeft() {
        // Player starts at the left wall of the level so it can't move left right away.
        player.startMovingInDirection(Direction.RIGHT);
        levelHandler.update();
        player.stopMovingInDirection(Direction.RIGHT);
        int startX = player.getX();
        player.startMovingInDirection(Direction.LEFT);
        levelHandler.update();
        assertTrue(player.getX() < startX);
    }
    @Test
    void testPlayerJump() {
        int startY = player.getY();
        player.jump();
        levelHandler.update();
        assertTrue(player.getY() < startY);
    }
    @Test
    void testPlayerJumpTwice() {
        int startY = player.getY();
        player.jump();
        levelHandler.update();
        player.jump();
        levelHandler.update();
        assertTrue(player.getY() < startY);
    }
    @Test
    void testPlayerJumpAndMove() {
        int startX = player.getX();
        int startY = player.getY();
        player.jump();
        player.startMovingInDirection(Direction.RIGHT);
        levelHandler.update();
        assertTrue(player.getX() > startX && player.getY() < startY);
    }
    @Test
    void testPlayerCantMoveOutOfBoundsToTheLeft() {
        int startX = player.getX();
        player.startMovingInDirection(Direction.LEFT);
        levelHandler.update();
        assertTrue(player.getX() == startX);
    }
}
