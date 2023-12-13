package org.group16.Model.GameObjects.Player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.group16.Model.GameHandling.GameHandler;
import org.group16.Model.GameObjects.Direction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    private GameHandler gameHandler;
    private IPlayer player;

    @BeforeEach
    void setUp() {
        gameHandler = new GameHandler();
        gameHandler.startGame();
        player = gameHandler.getPlayer();
    }

    @Test
    void testPlayerMoveRight() {
        int startX = player.getX();
        player.startMovingInDirection(Direction.RIGHT);
        gameHandler.update();
        assertTrue(player.getX() > startX);
    }
    @Test
    void testPlayerMoveLeft() {
        // Player starts at the left wall of the level so it can't move left right away.
        player.startMovingInDirection(Direction.RIGHT);
        gameHandler.update();
        player.stopMovingInDirection(Direction.RIGHT);
        int startX = player.getX();
        player.startMovingInDirection(Direction.LEFT);
        gameHandler.update();
        assertTrue(player.getX() < startX);
    }
    @Test
    void testPlayerJump() {
        int startY = player.getY();
        player.startJumping();
        gameHandler.update();
        assertTrue(player.getY() < startY);
    }
    @Test
    void testPlayerJumpAndMove() {
        int startX = player.getX();
        int startY = player.getY();
        player.startJumping();
        player.startMovingInDirection(Direction.RIGHT);
        gameHandler.update();
        assertTrue(player.getX() > startX && player.getY() < startY);
    }
    // This test depends on the level layout.
    @Test
    void testPlayerCantMoveOutOfBoundsToTheLeft() {
        player.startMovingInDirection(Direction.LEFT);
        gameHandler.update();
        gameHandler.update();
        gameHandler.update();
        gameHandler.update();
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
