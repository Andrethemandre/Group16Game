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

public class Level7 extends Level  {
    // matrix 45X30 to represent level 1
    private List<MovableBlock> movableBlocks;
    
    private static GameObjectType[][] level7 = {
    
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,FLYING____,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,GOAL______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,STATIONARY,STATIONARY,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,STATIONARY,STATIONARY,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,FLYING____,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,FLYING____,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,STATIONARY,STATIONARY,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,FLYING____,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,SPIKE_____,STATIONARY,STATIONARY,STATIONARY,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,SPIKE_____,STATIONARY,STATIONARY,STATIONARY,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,FLYING____,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,FLYING____,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,SPIKE_____,STATIONARY,STATIONARY,STATIONARY,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,SPIKE_____,STATIONARY,STATIONARY,STATIONARY,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,FLYING____,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,SPIKE_____,STATIONARY,STATIONARY,STATIONARY,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,SPIKE_____,STATIONARY,STATIONARY,STATIONARY,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,SPIKE_____,STATIONARY,STATIONARY,STATIONARY,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,FLYING____,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,SPIKE_____,STATIONARY,STATIONARY,STATIONARY,},
                                                {PLAYER____,AIR_______,AIR_______,AIR_______,FREEZE____,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,FLYING____,AIR_______,FREEZE____,AIR_______,FREEZE____,AIR_______,FREEZE____,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,SPIKE_____,STATIONARY,STATIONARY,STATIONARY,},
                                                {STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,SPIKE_____,SPIKE_____,SPIKE_____,SPIKE_____,SPIKE_____,SPIKE_____,SPIKE_____,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,SPIKE_____,STATIONARY,STATIONARY,STATIONARY,},
                                                {STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,SPIKE_____,STATIONARY,STATIONARY,STATIONARY,},
                                                {STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,SPIKE_____,STATIONARY,STATIONARY,STATIONARY,},                                        
                                                };

    // Construct the level by positioning game objects in the grid
    public Level7() {
        super(level7);
    }

    protected Queue<Metadata> createMetadata() {
        Queue<Metadata> metadataQueue = new LinkedList<>();
        metadataQueue.add(new Metadata(208, Direction.NONE, Direction.DOWN));
        metadataQueue.add(new Metadata(176, Direction.NONE, Direction.DOWN));
        metadataQueue.add(new Metadata(160, Direction.NONE, Direction.DOWN));
        metadataQueue.add(new Metadata(160, Direction.NONE, Direction.DOWN));
        metadataQueue.add(new Metadata(144, Direction.NONE, Direction.DOWN));
        metadataQueue.add(new Metadata(144, Direction.NONE, Direction.DOWN));
        metadataQueue.add(new Metadata(112, Direction.NONE, Direction.DOWN));
        metadataQueue.add(new Metadata(64, Direction.NONE, Direction.DOWN));
        //metadataQueue.add(new Metadata(96, Direction.LEFT, Direction.NONE));
    

        return metadataQueue;
    }

    // Initialize the movableBlocks list based on the level matrix
    

}
