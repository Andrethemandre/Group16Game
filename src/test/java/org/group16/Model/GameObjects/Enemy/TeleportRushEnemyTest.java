package org.group16.Model.GameObjects.Enemy;

import static org.group16.Model.GameObjects.GameObjectType.PLAYER____;
import static org.group16.Model.Utility.Settings.TILE_SIZE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.group16.Model.GameObjects.Player.IPlayer;
import org.group16.Model.GameObjects.Player.PlayerFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeleportRushEnemyTest {
    private TeleportRushEnemy teleportRushEnemy;
    private IPlayer player;

    @BeforeEach
    void setUp() {
        teleportRushEnemy = new TeleportRushEnemy(20, 20, 2*TILE_SIZE, 2*TILE_SIZE);
        player = PlayerFactory.createPlayerAt(PLAYER____, 0, 0, Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    @Test
    void testStartingStateIsIdle() {
        assertEquals(EnemyState.IDLE, teleportRushEnemy.getCurrentState());
    }

    @Test
    void testPlayerNear() {
        teleportRushEnemy.setTargetCoordinates(player.getX(), player.getY());
        teleportRushEnemy.update();
        assertEquals(EnemyState.DISAPPEAR, teleportRushEnemy.getCurrentState());
    }

    @Test
    void testPlayerNotNear() {
        teleportRushEnemy.setTargetCoordinates(player.getX() + 300, player.getY());
        teleportRushEnemy.update();
        assertEquals(EnemyState.IDLE, teleportRushEnemy.getCurrentState());
    }
    
    @Test
    void testDontDealDamageWhenIdle() {
        int startingPlayerHealth = player.getHealth();
        teleportRushEnemy.dealDamage(player);
        assertEquals(startingPlayerHealth, player.getHealth());
    }

    @Test
    void testDontDealDamageWhenDisappearing() {
        int startingPlayerHealth = player.getHealth();
        teleportRushEnemy.setTargetCoordinates(player.getX(), player.getY());
        teleportRushEnemy.update();
        teleportRushEnemy.dealDamage(player);
        assertEquals(startingPlayerHealth, player.getHealth());
    }

    @Test 
    void testGravity() {
        int startingY = teleportRushEnemy.getY();
        teleportRushEnemy.update();
        assertTrue(teleportRushEnemy.getY() > startingY);
    }
}
