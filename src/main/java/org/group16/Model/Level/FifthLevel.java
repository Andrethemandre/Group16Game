package org.group16.Model.Level;

import static org.group16.Model.GameObjects.GameObjectType.AIR_______;
import static org.group16.Model.GameObjects.GameObjectType.BASIC_____;
import static org.group16.Model.GameObjects.GameObjectType.FLYING____;
import static org.group16.Model.GameObjects.GameObjectType.GOAL______;
import static org.group16.Model.GameObjects.GameObjectType.MOVABLE___;
import static org.group16.Model.GameObjects.GameObjectType.PLAYER____;
import static org.group16.Model.GameObjects.GameObjectType.SPIKE_____;
import static org.group16.Model.GameObjects.GameObjectType.STATIONARY;

import java.util.LinkedList;
import java.util.Queue;

import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.GameObjectType;

class FifthLevel extends Level {
    // matrix 45X30 to represent level 5

    private final static GameObjectType[][] levelLayout = {

            { AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, FLYING____, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, GOAL______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, STATIONARY, STATIONARY, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, STATIONARY, AIR_______,
                    SPIKE_____, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, STATIONARY, STATIONARY,
                    STATIONARY, STATIONARY, STATIONARY, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, MOVABLE___, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, STATIONARY,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, STATIONARY,
                    AIR_______, AIR_______, BASIC_____, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, STATIONARY,
                    STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    FLYING____, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, SPIKE_____,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { PLAYER____, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, BASIC_____,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, MOVABLE___, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, STATIONARY, AIR_______, AIR_______, AIR_______, MOVABLE___, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, STATIONARY, STATIONARY, STATIONARY,
                    STATIONARY, STATIONARY, AIR_______, MOVABLE___, AIR_______, },
            { STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY,
                    STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY,
                    STATIONARY, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY,
                    STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY,
                    STATIONARY, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY,
                    STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY,
                    STATIONARY, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY,
                    STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY,
                    STATIONARY, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
    };

    // Construct the level by positioning game objects in the grid
    public FifthLevel() {
        super(levelLayout, 5);
    }

    protected Queue<Metadata> createMetadata() {
        Queue<Metadata> metadataQueue = new LinkedList<>();
        // flying enemy
        metadataQueue.add(new Metadata(70, Direction.RIGHT, Direction.DOWN));
        // enemy at platform
        metadataQueue.add(new Metadata(20, Direction.LEFT, Direction.NONE));
        // enemy at platform
        metadataQueue.add(new Metadata(50, Direction.RIGHT, Direction.NONE));
        metadataQueue.add(new Metadata(80, Direction.NONE, Direction.DOWN));
        metadataQueue.add(new Metadata(80, Direction.RIGHT, Direction.NONE));
        metadataQueue.add(new Metadata(50, Direction.RIGHT, Direction.NONE));
        metadataQueue.add(new Metadata(40, Direction.RIGHT, Direction.NONE));
        metadataQueue.add(new Metadata(100, Direction.NONE, Direction.UP));

        return metadataQueue;
    }

    // Initialize the movableBlocks list based on the level matrix

}
