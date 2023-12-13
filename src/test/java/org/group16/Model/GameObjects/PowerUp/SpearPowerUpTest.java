package org.group16.Model.GameObjects.PowerUp;

import static org.group16.Model.GameObjects.GameObjectType.BASIC_____;
import static org.group16.Model.GameObjects.GameObjectType.PLAYER____;
import static org.group16.Model.Utility.Settings.TILE_SIZE;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.Enemy.EnemyFactory;
import org.group16.Model.GameObjects.Enemy.IMovableEnemy;
import org.group16.Model.GameObjects.Player.IPlayer;
import org.group16.Model.GameObjects.Player.PlayerFactory;
import org.group16.Model.Level.Metadata;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SpearPowerUpTest {
    private SpearPowerUp spearPowerUpPickUp;
    private IMovableEnemy enemy;
    private IPlayer player;

    @BeforeEach
    void setUp() {
        spearPowerUpPickUp = new SpearPowerUp(TILE_SIZE, 0);
        enemy = EnemyFactory.createMovableEnemyAt(BASIC_____, 2*TILE_SIZE, 0, new Metadata(0, Direction.RIGHT));
        player = PlayerFactory.createPlayerAt(PLAYER____, 0, 0, Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    @Test
    void testCollisionWithPlayer() {
        player.startMovingInDirection(Direction.RIGHT);
        player.update();
        assertTrue(player.collidesWith(spearPowerUpPickUp));
    }

    @Test void testPowerUpDealsDamageToEnemy() {
        int enemyStartingHealth = enemy.getHealth();
        enemy.triggerPowerUp(spearPowerUpPickUp.getType());
        enemy.update();
        assertTrue(enemy.getHealth() < enemyStartingHealth);
    }

}
