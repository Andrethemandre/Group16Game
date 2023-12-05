package org.group16.Model.GameObjects.Enemy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.group16.Model.GameObjects.Direction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BasicEnemyTest {
    private BasicEnemy basicEnemy;

    @Test
    void testInitializeEnemyLeft() {
        basicEnemy = new BasicEnemy(10, 10, 128800, Direction.LEFT);
        int startX = basicEnemy.getX();
        basicEnemy.update();
        assertTrue(basicEnemy.getX() < startX);
    }

    @Test
    void testInitializeEnemyRight() {
        basicEnemy = new BasicEnemy(10, 10, 128800, Direction.RIGHT);
        int startX = basicEnemy.getX();
        basicEnemy.update();
        assertTrue(basicEnemy.getX() > startX);
    }

    @Test
    void testInitializeEnemyLeftPatrolDistance() {
        final int patrolDistance = 10;
        basicEnemy = new BasicEnemy(10, 10, patrolDistance, Direction.LEFT);
        int startX = basicEnemy.getX();

        final int movementSpeed = basicEnemy.getMovementSpeed();
        for (int i = 0; i < patrolDistance; i += movementSpeed) {
            basicEnemy.update();
        }
        assertEquals(startX-patrolDistance, basicEnemy.getX());
    }

    @Test
    void testInitializeEnemyRightPatrolDistance() {
        final int patrolDistance = 10;
        basicEnemy = new BasicEnemy(10, 10, patrolDistance, Direction.RIGHT);
        int startX = basicEnemy.getX();

        final int movementSpeed = basicEnemy.getMovementSpeed();
        for (int i = 0; i < patrolDistance; i += movementSpeed) {
            basicEnemy.update();
        }
        assertEquals(startX+patrolDistance, basicEnemy.getX());
    }

}
