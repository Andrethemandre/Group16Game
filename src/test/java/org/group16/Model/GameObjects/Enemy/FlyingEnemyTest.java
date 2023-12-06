package org.group16.Model.GameObjects.Enemy;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.group16.Model.GameObjects.Direction;
import org.junit.jupiter.api.Test;

public class FlyingEnemyTest {
    private FlyingEnemy flyingEnemy;

    @Test
    void testInitializeFlyingEnemyLeft() {
        flyingEnemy = new FlyingEnemy(10, 10, 128800, Direction.LEFT, Direction.NONE);
        int startX = flyingEnemy.getX();
        flyingEnemy.update();
        assertTrue(flyingEnemy.getX() < startX);
    }

    @Test
    void testInitializeFlyingEnemyRight() {
        flyingEnemy = new FlyingEnemy(10, 10, 128800, Direction.RIGHT, Direction.NONE);
        int startX = flyingEnemy.getX();
        flyingEnemy.update();
        assertTrue(flyingEnemy.getX() > startX);
    }

    @Test
    void testInitializeFlyingEnemyUp() {
        flyingEnemy = new FlyingEnemy(10, 10, 128800, Direction.NONE, Direction.UP);
        int startY = flyingEnemy.getY();
        flyingEnemy.update();
        assertTrue(flyingEnemy.getY() < startY);
    }

    @Test
    void testInitializeFlyingEnemyDown() {
        flyingEnemy = new FlyingEnemy(10, 10, 128800, Direction.NONE, Direction.DOWN);
        int startY = flyingEnemy.getY();
        flyingEnemy.update();
        assertTrue(flyingEnemy.getY() > startY);
    }

    @Test
    void testInitializeFlyingEnemyLeftUp() {
        flyingEnemy = new FlyingEnemy(10, 10, 128800, Direction.LEFT, Direction.UP);
        int startX = flyingEnemy.getX();
        int startY = flyingEnemy.getY();
        flyingEnemy.update();
        assertTrue(flyingEnemy.getX() < startX && flyingEnemy.getY() < startY);
    }

    @Test
    void testInitializeFlyingEnemyLeftDown() {
        flyingEnemy = new FlyingEnemy(10, 10, 128800, Direction.LEFT, Direction.DOWN);
        int startX = flyingEnemy.getX();
        int startY = flyingEnemy.getY();
        flyingEnemy.update();
        assertTrue(flyingEnemy.getX() < startX && flyingEnemy.getY() > startY);
    }

    @Test
    void testInitializeFlyingEnemyRightUp() {
        flyingEnemy = new FlyingEnemy(10, 10, 128800, Direction.RIGHT, Direction.UP);
        int startX = flyingEnemy.getX();
        int startY = flyingEnemy.getY();
        flyingEnemy.update();
        assertTrue(flyingEnemy.getX() > startX && flyingEnemy.getY() < startY);
    }

    @Test
    void testInitializeFlyingEnemyRightDown() {
        flyingEnemy = new FlyingEnemy(10, 10, 128800, Direction.RIGHT, Direction.DOWN);
        int startX = flyingEnemy.getX();
        int startY = flyingEnemy.getY();
        flyingEnemy.update();
        assertTrue(flyingEnemy.getX() > startX && flyingEnemy.getY() > startY);
    }

    @Test
    void testInitializeFlyingEnemyLeftUpPatrolDistance() {
        final int patrolDistance = 10;
        flyingEnemy = new FlyingEnemy(10, 10, patrolDistance, Direction.LEFT, Direction.UP);
        final int movementSpeed = flyingEnemy.getMovementSpeed();
        
        for (int i = 0; i < patrolDistance; i += movementSpeed) {
            flyingEnemy.update();
        }
        assertTrue(flyingEnemy.getX() == 0 && flyingEnemy.getY() == 0);
    }

    @Test
    void testInitializeFlyingEnemyLeftPatrolDistance() {
        final int patrolDistance = 10;
        flyingEnemy = new FlyingEnemy(10, 10, patrolDistance, Direction.LEFT, Direction.NONE);
        final int movementSpeed = flyingEnemy.getMovementSpeed();
        
        for (int i = 0; i < patrolDistance; i += movementSpeed) {
            flyingEnemy.update();
        }
        assertTrue(flyingEnemy.getX() == 0 && flyingEnemy.getY() == 10);
    }

    @Test
    void testInitializeFlyingEnemyUpPatrolDistance() {
        final int patrolDistance = 10;
        flyingEnemy = new FlyingEnemy(10, 10, patrolDistance, Direction.NONE, Direction.UP);
        final int movementSpeed = flyingEnemy.getMovementSpeed();
        
        for (int i = 0; i < patrolDistance; i += movementSpeed) {
            flyingEnemy.update();
        }
        assertTrue(flyingEnemy.getX() == 10 && flyingEnemy.getY() == 0);
    }
}
