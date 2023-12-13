package org.group16.Model.GameObjects.Blocks;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.group16.Model.GameObjects.Direction;
import org.junit.jupiter.api.Test;

public class MovableBlockTest {
    private MovableBlock movableBlock;

    @Test
    void testInitializeMovableBlockLeft() {
        movableBlock = new MovableBlock(10, 10, 128800, Direction.LEFT, Direction.NONE);
        int startX = movableBlock.getX();
        movableBlock.update();
        assertTrue(movableBlock.getX() < startX);
    }

    @Test
    void testInitializeMovableBlockRight() {
        movableBlock = new MovableBlock(10, 10, 128800, Direction.RIGHT, Direction.NONE);
        int startX = movableBlock.getX();
        movableBlock.update();
        assertTrue(movableBlock.getX() > startX);
    }

    @Test
    void testInitializeMovableBlockUp() {
        movableBlock = new MovableBlock(10, 10, 128800, Direction.NONE, Direction.UP);
        int startY = movableBlock.getY();
        movableBlock.update();
        assertTrue(movableBlock.getY() < startY);
    }

    @Test
    void testInitializeMovableBlockDown() {
        movableBlock = new MovableBlock(10, 10, 128800, Direction.NONE, Direction.DOWN);
        int startY = movableBlock.getY();
        movableBlock.update();
        assertTrue(movableBlock.getY() > startY);
    }

    @Test
    void testInitializeMovableBlockLeftUp() {
        movableBlock = new MovableBlock(10, 10, 128800, Direction.LEFT, Direction.UP);
        int startX = movableBlock.getX();
        int startY = movableBlock.getY();
        movableBlock.update();
        assertTrue(movableBlock.getX() < startX && movableBlock.getY() < startY);
    }

    @Test
    void testInitializeMovableBlockLeftDown() {
        movableBlock = new MovableBlock(10, 10, 128800, Direction.LEFT, Direction.DOWN);
        int startX = movableBlock.getX();
        int startY = movableBlock.getY();
        movableBlock.update();
        assertTrue(movableBlock.getX() < startX && movableBlock.getY() > startY);
    }

    @Test
    void testInitializeMovableBlockRightUp() {
        movableBlock = new MovableBlock(10, 10, 128800, Direction.RIGHT, Direction.UP);
        int startX = movableBlock.getX();
        int startY = movableBlock.getY();
        movableBlock.update();
        assertTrue(movableBlock.getX() > startX && movableBlock.getY() < startY);
    }

    @Test
    void testInitializeMovableBlockRightDown() {
        movableBlock = new MovableBlock(10, 10, 128800, Direction.RIGHT, Direction.DOWN);
        int startX = movableBlock.getX();
        int startY = movableBlock.getY();
        movableBlock.update();
        assertTrue(movableBlock.getX() > startX && movableBlock.getY() > startY);
    }
}
