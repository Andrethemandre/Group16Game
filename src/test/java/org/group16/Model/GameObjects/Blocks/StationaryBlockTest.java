package org.group16.Model.GameObjects.Blocks;

import static org.group16.Model.GameObjects.GameObjectType.PLAYER____;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.group16.Model.GameObjects.Player.IPlayer;
import org.group16.Model.GameObjects.Player.PlayerFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StationaryBlockTest {
    private StationaryBlock stationaryBlock;
    private IPlayer player;

    @BeforeEach
    void setUp() {
        stationaryBlock = new StationaryBlock(0, 16);
        player = PlayerFactory.createPlayerAt(PLAYER____, 0, 0, Integer.MAX_VALUE, Integer.MAX_VALUE);

    }

    @Test
    void testPlayerCollisionBeforeUpdate() {
        assertFalse(stationaryBlock.collidesWith(player));
    }

    @Test
    void testPlayerCollisionAfterUpdate() {
        player.update();
        assertTrue(stationaryBlock.collidesWith(player));
    }

    @Test
    void testPlayerCollisionCorrectionAfterUpdate() {
        player.update();
        player.checkCollision(stationaryBlock);
        assertEquals(0, player.getY());
    }


}
