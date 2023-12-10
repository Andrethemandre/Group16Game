package org.group16.Model.GameObjects.Goal;

import static org.group16.Model.GameObjects.GameObjectType.PLAYER____;

import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.Player.IPlayer;
import org.group16.Model.GameObjects.Player.PlayerFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GoalTest {
    private Goal goal;
    private IPlayer player;

    @BeforeEach
    void setUp() {
        goal = new Goal(16, 0);
        player = PlayerFactory.createPlayerAt(PLAYER____, 0, 0, Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    @Test
    void testCollisionWithPlayer() {
        player.startMovingInDirection(Direction.RIGHT);
        player.update();
        assert(player.collidesWith(goal));
    }
}
