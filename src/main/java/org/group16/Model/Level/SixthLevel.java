package org.group16.Model.Level;

import static org.group16.Model.GameObjects.GameObjectType.AIR_______;
import static org.group16.Model.GameObjects.GameObjectType.BASIC_____;
import static org.group16.Model.GameObjects.GameObjectType.FLYING____;
import static org.group16.Model.GameObjects.GameObjectType.GOAL______;
import static org.group16.Model.GameObjects.GameObjectType.MOVABLE___;
import static org.group16.Model.GameObjects.GameObjectType.PLAYER____;
import static org.group16.Model.GameObjects.GameObjectType.SPEAR_____;
import static org.group16.Model.GameObjects.GameObjectType.SPIKE_____;
import static org.group16.Model.GameObjects.GameObjectType.STATIONARY;
import static org.group16.Model.GameObjects.GameObjectType.TELEPORTER;
import static org.group16.Model.Utility.Settings.TILE_SIZE;

import java.util.LinkedList;
import java.util.Queue;

import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.GameObjectType;

class SixthLevel extends Level {
    // matrix 45X30 to represent level 6
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
                    AIR_______, AIR_______, AIR_______, AIR_______, FLYING____, AIR_______, AIR_______, AIR_______,
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
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, SPEAR_____, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, STATIONARY, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, BASIC_____,
                    AIR_______, AIR_______, AIR_______, SPIKE_____, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { TELEPORTER, STATIONARY, STATIONARY, AIR_______, AIR_______, AIR_______, AIR_______, STATIONARY,
                    STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, SPEAR_____, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, FLYING____, AIR_______, AIR_______, AIR_______, },
            { AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, STATIONARY,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, STATIONARY, STATIONARY, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, STATIONARY,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, STATIONARY, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, STATIONARY,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, STATIONARY, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { AIR_______, AIR_______, AIR_______, SPIKE_____, SPIKE_____, SPIKE_____, SPIKE_____, STATIONARY,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, SPIKE_____, SPIKE_____,
                    SPIKE_____, SPIKE_____, SPIKE_____, SPIKE_____, BASIC_____, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, STATIONARY, AIR_______, SPIKE_____, SPIKE_____, SPIKE_____,
                    SPIKE_____, AIR_______, BASIC_____, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY,
                    STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY,
                    STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY,
                    STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY,
                    STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, SPIKE_____, STATIONARY,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, FLYING____, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    FLYING____, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, STATIONARY,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, STATIONARY,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, STATIONARY,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, STATIONARY,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, STATIONARY,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, STATIONARY,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, STATIONARY,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, MOVABLE___, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, STATIONARY,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, MOVABLE___,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, SPIKE_____, AIR_______, AIR_______, TELEPORTER, STATIONARY,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, MOVABLE___, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, STATIONARY,
                    AIR_______, AIR_______, AIR_______, AIR_______, STATIONARY, STATIONARY, STATIONARY, STATIONARY,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, STATIONARY,
                    AIR_______, AIR_______, STATIONARY, GOAL______, STATIONARY, },
            { PLAYER____, AIR_______, SPEAR_____, AIR_______, BASIC_____, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, SPIKE_____, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, STATIONARY,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
            { STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY,
                    STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, STATIONARY, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, STATIONARY,
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, },
    };

    // Construct the level by positioning game objects in the grid
    public SixthLevel() {
        super(levelLayout, 6);
    }

    @Override
    protected Queue<Metadata> createMetadata() {
        Queue<Metadata> metadataQueue = new LinkedList<>();
        metadataQueue.add(new Metadata(3*TILE_SIZE + 2, Direction.RIGHT, Direction.DOWN)); // flying
        metadataQueue.add(new Metadata(3*TILE_SIZE, Direction.RIGHT, Direction.NONE)); // basic
        metadataQueue.add(new Metadata(37*TILE_SIZE, 25*TILE_SIZE)); // first teleport
        metadataQueue.add(new Metadata(2*TILE_SIZE + 8, Direction.LEFT, Direction.DOWN)); // flying
        metadataQueue.add(new Metadata(4*TILE_SIZE + 6, Direction.RIGHT, Direction.NONE)); // basic
        metadataQueue.add(new Metadata(5*TILE_SIZE, Direction.RIGHT, Direction.NONE)); // basic
        metadataQueue.add(new Metadata(5*TILE_SIZE, Direction.RIGHT, Direction.DOWN)); // flying
        metadataQueue.add(new Metadata(4*TILE_SIZE + 6, Direction.LEFT, Direction.DOWN)); // flying
        metadataQueue.add(new Metadata(2*TILE_SIZE + 8, Direction.LEFT, Direction.DOWN)); // movable block
        metadataQueue.add(new Metadata(3*TILE_SIZE + 2, Direction.LEFT, Direction.DOWN)); // movable block
        metadataQueue.add(new Metadata(TILE_SIZE, 9*TILE_SIZE));// second teleport
        metadataQueue.add(new Metadata(3*TILE_SIZE + 2, Direction.LEFT, Direction.NONE)); // movable block
        metadataQueue.add(new Metadata(TILE_SIZE + 14, Direction.RIGHT, Direction.NONE)); // basic

        return metadataQueue;
    }
}
