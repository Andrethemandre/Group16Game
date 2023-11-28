package org.group16.Model.GameObjects.Enemy;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.group16.Model.GameObjects.Direction;
import org.junit.jupiter.api.Test;

public class FlyingEnemyTest {
    private FlyingEnemy flyingEnemy;

    @Test
    void testInitializeEnemyLeft() {
        flyingEnemy = new FlyingEnemy(10, 10, Direction.LEFT, Direction.NONE, 128800);
        int startX = flyingEnemy.getX();
        flyingEnemy.update();
        assertTrue(flyingEnemy.getX() < startX);
    }

    @Test
    void testInitializeEnemyRight() {
        flyingEnemy = new FlyingEnemy(10, 10, Direction.RIGHT, Direction.NONE, 128800);
        int startX = flyingEnemy.getX();
        flyingEnemy.update();
        assertTrue(flyingEnemy.getX() > startX);
    }

    @Test
    void testInitializeEnemyUp() {
        flyingEnemy = new FlyingEnemy(10, 10, Direction.NONE, Direction.UP, 128800);
        int startY = flyingEnemy.getY();
        flyingEnemy.update();
        assertTrue(flyingEnemy.getY() < startY);
    }

    @Test
    void testInitializeEnemyDown() {
        flyingEnemy = new FlyingEnemy(10, 10, Direction.NONE, Direction.DOWN, 128800);
        int startY = flyingEnemy.getY();
        flyingEnemy.update();
        assertTrue(flyingEnemy.getY() > startY);
    }

    @Test
    void testInitializeEnemyLeftUp() {
        flyingEnemy = new FlyingEnemy(10, 10, Direction.LEFT, Direction.UP, 128800);
        int startX = flyingEnemy.getX();
        int startY = flyingEnemy.getY();
        flyingEnemy.update();
        assertTrue(flyingEnemy.getX() < startX && flyingEnemy.getY() < startY);
    }

    @Test
    void testInitializeEnemyLeftDown() {
        flyingEnemy = new FlyingEnemy(10, 10, Direction.LEFT, Direction.DOWN, 128800);
        int startX = flyingEnemy.getX();
        int startY = flyingEnemy.getY();
        flyingEnemy.update();
        assertTrue(flyingEnemy.getX() < startX && flyingEnemy.getY() > startY);
    }

    @Test
    void testInitializeEnemyRightUp() {
        flyingEnemy = new FlyingEnemy(10, 10, Direction.RIGHT, Direction.UP, 128800);
        int startX = flyingEnemy.getX();
        int startY = flyingEnemy.getY();
        flyingEnemy.update();
        assertTrue(flyingEnemy.getX() > startX && flyingEnemy.getY() < startY);
    }

    @Test
    void testInitializeEnemyRightDown() {
        flyingEnemy = new FlyingEnemy(10, 10, Direction.RIGHT, Direction.DOWN, 128800);
        int startX = flyingEnemy.getX();
        int startY = flyingEnemy.getY();
        flyingEnemy.update();
        assertTrue(flyingEnemy.getX() > startX && flyingEnemy.getY() > startY);
    }

    @Test
    void testInitializeEnemyLeftUpPatrolDistance() {
        final int patrolDistance = 10;
        flyingEnemy = new FlyingEnemy(10, 10, Direction.LEFT, Direction.UP, patrolDistance);
        final int movementSpeed = flyingEnemy.getMovementSpeed();
        
        for (int i = 0; i < patrolDistance; i += movementSpeed) {
            flyingEnemy.update();
        }
        assertTrue(flyingEnemy.getX() == 0 && flyingEnemy.getY() == 0);
    }

    @Test
    void testInitializeEnemyLeftPatrolDistance() {
        final int patrolDistance = 10;
        flyingEnemy = new FlyingEnemy(10, 10, Direction.LEFT, Direction.NONE, patrolDistance);
        final int movementSpeed = flyingEnemy.getMovementSpeed();
        
        for (int i = 0; i < patrolDistance; i += movementSpeed) {
            flyingEnemy.update();
        }
        assertTrue(flyingEnemy.getX() == 0 && flyingEnemy.getY() == 10);
    }

    @Test
    void testInitializeEnemyUpPatrolDistance() {
        final int patrolDistance = 10;
        flyingEnemy = new FlyingEnemy(10, 10, Direction.NONE, Direction.UP, patrolDistance);
        final int movementSpeed = flyingEnemy.getMovementSpeed();
        
        for (int i = 0; i < patrolDistance; i += movementSpeed) {
            flyingEnemy.update();
        }
        assertTrue(flyingEnemy.getX() == 10 && flyingEnemy.getY() == 0);
    }


}
