package org.group16.Model.GameObjects.Blocks;

import static org.group16.Model.GameObjects.GameObjectType.PLAYER____;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.Player.IPlayer;
import org.group16.Model.GameObjects.Player.PlayerFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeleportBlockTest {
    private TeleportBlock teleportBlock;
    private IPlayer player;

    @BeforeEach
    void setUp() {
        teleportBlock = new TeleportBlock(16, 0);
        player = PlayerFactory.createPlayerAt(PLAYER____, 0, 0, Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    @Test
    void testCollisionWithPlayer() {
        player.startMovingInDirection(Direction.RIGHT);
        player.update();
        assertTrue(player.collidesWith(teleportBlock));
    }

}
