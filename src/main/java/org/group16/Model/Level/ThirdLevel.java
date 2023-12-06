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



import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class ThirdLevel extends Level  {
    // matrix 45X30 to represent level 3

    private static final GameObjectType[][] levelLayout = {
    
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,AIR_______,FLYING____,AIR_______,FLYING____,AIR_______,AIR_______,AIR_______,AIR_______,FLYING____,AIR_______,AIR_______,AIR_______,AIR_______,FLYING____,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,},
                                                {GOAL______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,},
                                                {STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,SPIKE_____,SPIKE_____,SPIKE_____,SPIKE_____,SPIKE_____,STATIONARY,STATIONARY,SPIKE_____,SPIKE_____,SPIKE_____,STATIONARY,STATIONARY,SPIKE_____,SPIKE_____,SPIKE_____,STATIONARY,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,SPEAR_____,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,},
                                                {STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,SPIKE_____,AIR_______,AIR_______,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,},
                                                {STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,},
                                                {STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,},
                                                {STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,AIR_______,AIR_______,SPIKE_____,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,},
                                                {STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,},
                                                {SPIKE_____,SPIKE_____,SPIKE_____,SPIKE_____,SPIKE_____,SPIKE_____,SPIKE_____,STATIONARY,STATIONARY,STATIONARY,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,STATIONARY,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,STATIONARY,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,BASIC_____,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,STATIONARY,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,BASIC_____,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,},
                                                {PLAYER____,AIR_______,AIR_______,AIR_______,SPEAR_____,AIR_______,AIR_______,BASIC_____,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,SPEAR_____,AIR_______,SPEAR_____,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,},
                                                {STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,},
                                                {STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,},
                                                {STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,},                                        
                                                };

    // Construct the level by positioning game objects in the grid
    public ThirdLevel() {
        super(levelLayout, 3);
    }

    protected Queue<Metadata> createMetadata() {
        Queue<Metadata> metadataQueue = new LinkedList<>();
        //flying
        metadataQueue.add(new Metadata(96, Direction.NONE, Direction.DOWN));
        metadataQueue.add(new Metadata(96,Direction.NONE, Direction.DOWN));
        metadataQueue.add(new Metadata(96, Direction.NONE, Direction.DOWN));
        metadataQueue.add(new Metadata(80, Direction.NONE, Direction.DOWN));


        //basic enemy
        metadataQueue.add(new Metadata(16, Direction.RIGHT, Direction.NONE));
        metadataQueue.add(new Metadata(16,Direction.RIGHT, Direction.NONE));
        metadataQueue.add(new Metadata(48, Direction.RIGHT, Direction.DOWN));


        return metadataQueue;
    }

    // Initialize the movableBlocks list based on the level matrix
    

}
