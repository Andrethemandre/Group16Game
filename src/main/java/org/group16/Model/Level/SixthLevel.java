package org.group16.Model.Level;

import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.GameObjectType;

import static org.group16.Model.GameObjects.GameObjectType.MOVABLE___;
import static org.group16.Model.GameObjects.GameObjectType.STATIONARY;
import static org.group16.Model.GameObjects.GameObjectType.TELEPORT__;
import static org.group16.Model.GameObjects.GameObjectType.AIR_______;
import static org.group16.Model.GameObjects.GameObjectType.BASIC_____;
import static org.group16.Model.GameObjects.GameObjectType.FREEZE____;
import static org.group16.Model.GameObjects.GameObjectType.GOAL______;
import static org.group16.Model.GameObjects.GameObjectType.PLAYER____;
import static org.group16.Model.GameObjects.GameObjectType.POWERUP___;
import static org.group16.Model.GameObjects.GameObjectType.SPEAR_____;
import static org.group16.Model.GameObjects.GameObjectType.SPIKE_____;
import static org.group16.Model.GameObjects.GameObjectType.FLYING____;
import org.group16.Model.GameObjects.Blocks.MovableBlock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class SixthLevel extends Level {
    // matrix 45X30 to represent level 1
    

    private final static GameObjectType[][] level6 = {

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
            { SPIKE_____, STATIONARY, STATIONARY, AIR_______, AIR_______, AIR_______, AIR_______, STATIONARY,
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
                    AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, AIR_______, STATIONARY,
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
                    AIR_______, AIR_______, AIR_______, AIR_______, SPIKE_____, AIR_______, AIR_______, SPIKE_____,
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
        super(level6, 6);
    }

    protected Queue<Metadata> createMetadata() {
        Queue<Metadata> metadataQueue = new LinkedList<>();
        metadataQueue.add(new Metadata(50, Direction.RIGHT, Direction.DOWN));
        metadataQueue.add(new Metadata(45, Direction.RIGHT, Direction.NONE));
        metadataQueue.add(new Metadata(40, Direction.LEFT, Direction.DOWN));
        metadataQueue.add(new Metadata(70, Direction.LEFT, Direction.DOWN));
        metadataQueue.add(new Metadata(80, Direction.LEFT, Direction.NONE));
        metadataQueue.add(new Metadata(80, Direction.RIGHT, Direction.DOWN));
        metadataQueue.add(new Metadata(70, Direction.LEFT, Direction.DOWN));
        metadataQueue.add(new Metadata(40, Direction.LEFT, Direction.DOWN));
        metadataQueue.add(new Metadata(50, Direction.LEFT, Direction.DOWN));
        metadataQueue.add(new Metadata(50, Direction.LEFT, Direction.NONE));
        metadataQueue.add(new Metadata(30, Direction.RIGHT, Direction.DOWN));
        metadataQueue.add(new Metadata(40, Direction.RIGHT, Direction.NONE));
        metadataQueue.add(new Metadata(40, Direction.LEFT, Direction.DOWN));
        metadataQueue.add(new Metadata(80, Direction.LEFT, Direction.DOWN));
        metadataQueue.add(new Metadata(60, Direction.RIGHT, Direction.NONE));

        return metadataQueue;
    }

    // Initialize the movableBlocks list based on the level matrix

}
