package org.group16.Model.GameObjects.Player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.group16.Model.GameObjects.Direction;
import org.group16.Model.LevelHandling.LevelHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    private LevelHandler levelHandler;
    private IPlayer player;

    @BeforeEach
    void setUp() {
        levelHandler = new LevelHandler();
        levelHandler.startGame();
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
        player.startJumping();
        levelHandler.update();
        assertTrue(player.getY() < startY);
    }
    @Test
    void testPlayerJumpAndMove() {
        int startX = player.getX();
        int startY = player.getY();
        player.startJumping();
        player.startMovingInDirection(Direction.RIGHT);
        levelHandler.update();
        assertTrue(player.getX() > startX && player.getY() < startY);
    }
    // This test depends on the level layout.
    @Test
    void testPlayerCantMoveOutOfBoundsToTheLeft() {
        player.startMovingInDirection(Direction.LEFT);
        levelHandler.update();
        levelHandler.update();
        levelHandler.update();
        levelHandler.update();
        assertEquals(0, player.getX());
    }
    @Test
    void testPlayerDirectionRight() {
        player.startMovingInDirection(Direction.RIGHT);
        player.update();
        assertTrue(player.getDirection() == Direction.RIGHT);
    }
    @Test
    void testPlayerDirectionLeft() {
        player.startMovingInDirection(Direction.LEFT);
        player.update();
        assertTrue(player.getDirection() == Direction.LEFT);
    }
    @Test 
    void testPlayerLastDirectionRight() {
        player.startMovingInDirection(Direction.RIGHT);
        player.update();
        player.stopMovingInDirection(Direction.RIGHT);
        player.update();
        assertTrue(player.getDirection() == Direction.RIGHT);
    }
    @Test
    void testPlayerLastDirectionLeft() {
        player.startMovingInDirection(Direction.LEFT);
        player.update();
        player.stopMovingInDirection(Direction.LEFT);
        player.update();
        assertTrue(player.getDirection() == Direction.LEFT);
    }
}
