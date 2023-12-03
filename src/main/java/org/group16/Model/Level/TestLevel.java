package org.group16.Model.Level;

import org.group16.Model.GameObjects.GameObjectType;

import static org.group16.Model.GameObjects.GameObjectType.MOVABLE___;
import static org.group16.Model.GameObjects.GameObjectType.STATIONARY;

import java.util.Queue;

import static org.group16.Model.GameObjects.GameObjectType.AIR_______;
import static org.group16.Model.GameObjects.GameObjectType.BASIC_____;
import static org.group16.Model.GameObjects.GameObjectType.GOAL______;
import static org.group16.Model.GameObjects.GameObjectType.PLAYER____;
import static org.group16.Model.GameObjects.GameObjectType.POWERUP___;
import static org.group16.Model.GameObjects.GameObjectType.SPIKE_____;

public class TestLevel extends Level {
    private static final GameObjectType[][] testLevel = {
            { AIR_______, AIR_______, AIR_______, },
            { AIR_______, PLAYER____, AIR_______, },
            { AIR_______, AIR_______, AIR_______, }
    };

    public TestLevel() {
        super(testLevel, -1);
    }

    @Override
    protected Queue<Metadata> createMetadata() {
        throw new UnsupportedOperationException("Unimplemented method 'createMetadata'");
    }
}
