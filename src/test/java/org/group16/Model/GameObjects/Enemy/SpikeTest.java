package org.group16.Model.GameObjects.Enemy;

import static org.group16.Model.GameObjects.GameObjectType.SPIKE_____;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.group16.Model.GameObjects.Direction;
import org.group16.Model.Level.Metadata;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SpikeTest {
    private Spike spike;
    
    @BeforeEach
    void setUp() {
        spike = (Spike) EnemyFactory.createEnemyAt(SPIKE_____, 0, 0, new Metadata(0, Direction.NONE, Direction.NONE));
    }

    @Test
    void testSpikeCantDie() {
        assertFalse(spike.isDead());
    }
}
