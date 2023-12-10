package org.group16.Model.Level;

import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.GameObjectType;

import static org.group16.Model.GameObjects.GameObjectType.STATIONARY;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.group16.Model.GameObjects.GameObjectType.AIR_______;
import static org.group16.Model.GameObjects.GameObjectType.BASIC_____;
import static org.group16.Model.GameObjects.GameObjectType.FLYING____;
import static org.group16.Model.GameObjects.GameObjectType.FREEZE____;
import static org.group16.Model.GameObjects.GameObjectType.GOAL______;
import static org.group16.Model.GameObjects.GameObjectType.MOVABLE___;
import static org.group16.Model.GameObjects.GameObjectType.PLAYER____;
import static org.group16.Model.GameObjects.GameObjectType.SPIKE_____;
import static org.group16.Model.GameObjects.GameObjectType.POWERUP___;
import static org.group16.Model.GameObjects.GameObjectType.SPEAR_____;


public class NinthLevel extends Level {

    // matrix 45X30 to represent level 9  
    private final static GameObjectType[][] levelLayout = {
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {BASIC_____,AIR_______,AIR_______,AIR_______,SPEAR_____,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,PLAYER____,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,FREEZE____,AIR_______,AIR_______,BASIC_____,},
                                                {STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,AIR_______,AIR_______,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,MOVABLE___,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,STATIONARY,FLYING____,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,FLYING____,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,SPIKE_____,STATIONARY,STATIONARY,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,SPIKE_____,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,FLYING____,},
                                                {SPEAR_____,AIR_______,AIR_______,AIR_______,BASIC_____,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,SPIKE_____,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,SPIKE_____,STATIONARY,STATIONARY,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,SPIKE_____,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {STATIONARY,STATIONARY,AIR_______,AIR_______,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,SPIKE_____,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,SPIKE_____,STATIONARY,STATIONARY,STATIONARY,SPIKE_____,SPIKE_____,SPIKE_____,SPIKE_____,SPIKE_____,SPIKE_____,STATIONARY,SPIKE_____,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,FLYING____,AIR_______,AIR_______,FLYING____,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,SPIKE_____,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,SPIKE_____,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {FREEZE____,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,BASIC_____,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,SPEAR_____,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,AIR_______,AIR_______,STATIONARY,STATIONARY,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,AIR_______,AIR_______,SPIKE_____,SPIKE_____,FLYING____,SPIKE_____,SPIKE_____,FLYING____,SPIKE_____,SPIKE_____,FLYING____,SPIKE_____,SPIKE_____,FLYING____,SPIKE_____,SPIKE_____,SPIKE_____,SPIKE_____,SPIKE_____,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {FLYING____,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,MOVABLE___,MOVABLE___,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {SPIKE_____,SPIKE_____,SPIKE_____,SPIKE_____,SPIKE_____,SPIKE_____,SPIKE_____,SPIKE_____,AIR_______,SPIKE_____,SPIKE_____,AIR_______,SPIKE_____,SPIKE_____,SPIKE_____,SPIKE_____,SPIKE_____,SPIKE_____,SPIKE_____,AIR_______,AIR_______,SPEAR_____,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,BASIC_____,AIR_______,AIR_______,SPEAR_____,AIR_______,},
                                                {STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,AIR_______,STATIONARY,STATIONARY,AIR_______,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,AIR_______,STATIONARY,STATIONARY,AIR_______,STATIONARY,STATIONARY,AIR_______,STATIONARY,STATIONARY,AIR_______,STATIONARY,STATIONARY,AIR_______,AIR_______,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,FLYING____,STATIONARY,STATIONARY,STATIONARY,SPIKE_____,SPIKE_____,AIR_______,AIR_______,SPIKE_____,SPIKE_____,AIR_______,SPIKE_____,SPIKE_____,AIR_______,SPIKE_____,SPIKE_____,AIR_______,SPIKE_____,SPIKE_____,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,SPIKE_____,STATIONARY,STATIONARY,STATIONARY,SPIKE_____,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,MOVABLE___,MOVABLE___,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {FLYING____,AIR_______,AIR_______,AIR_______,SPIKE_____,SPIKE_____,AIR_______,AIR_______,AIR_______,AIR_______,FREEZE____,AIR_______,AIR_______,SPIKE_____,SPIKE_____,SPIKE_____,SPIKE_____,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,BASIC_____,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,FREEZE____,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,AIR_______,STATIONARY,STATIONARY,AIR_______,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,AIR_______,AIR_______,STATIONARY,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,SPIKE_____,STATIONARY,STATIONARY,STATIONARY,SPIKE_____,FLYING____,AIR_______,AIR_______,FLYING____,AIR_______,AIR_______,FLYING____,AIR_______,AIR_______,FLYING____,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,SPIKE_____,STATIONARY,STATIONARY,STATIONARY,SPIKE_____,AIR_______,SPEAR_____,AIR_______,AIR_______,SPEAR_____,AIR_______,AIR_______,SPEAR_____,AIR_______,AIR_______,SPEAR_____,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {STATIONARY,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,SPIKE_____,STATIONARY,STATIONARY,STATIONARY,SPIKE_____,AIR_______,STATIONARY,AIR_______,AIR_______,STATIONARY,AIR_______,AIR_______,STATIONARY,AIR_______,AIR_______,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,STATIONARY,AIR_______,AIR_______,AIR_______,GOAL______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,BASIC_____,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,MOVABLE___,MOVABLE___,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,},                                        
                                                };
    
    public NinthLevel() {
        super(levelLayout, 9);
    }

    @Override
    protected Queue<Metadata> createMetadata() {
        Queue<Metadata> metadataQueue = new LinkedList<>();
        // Metadata that is added to movable objects in the level matrix, 
        // by going left to right through each row 
        metadataQueue.add(new Metadata(9*16, Direction.RIGHT, Direction.NONE));
        metadataQueue.add(new Metadata(6*16, Direction.LEFT, Direction.NONE));
        metadataQueue.add(new Metadata(5*16, Direction.RIGHT, Direction.NONE));
        metadataQueue.add(new Metadata(5*16, Direction.RIGHT, Direction.NONE));
        metadataQueue.add(new Metadata(5*16, Direction.RIGHT, Direction.DOWN));
        metadataQueue.add(new Metadata(5*16, Direction.LEFT, Direction.DOWN));
        metadataQueue.add(new Metadata(7*16, Direction.RIGHT, Direction.NONE));
        metadataQueue.add(new Metadata(5*16, Direction.NONE, Direction.DOWN));
        metadataQueue.add(new Metadata(5*16, Direction.NONE, Direction.DOWN));
        metadataQueue.add(new Metadata(8*16, Direction.RIGHT, Direction.NONE));
        metadataQueue.add(new Metadata(8*16, Direction.NONE, Direction.DOWN));
        metadataQueue.add(new Metadata(8*16, Direction.NONE, Direction.DOWN));
        metadataQueue.add(new Metadata(8*16, Direction.NONE, Direction.DOWN));
        metadataQueue.add(new Metadata(8*16, Direction.NONE, Direction.DOWN));
        metadataQueue.add(new Metadata(20*16, Direction.RIGHT, Direction.NONE));
        metadataQueue.add(new Metadata(9*16, Direction.LEFT, Direction.NONE));
        metadataQueue.add(new Metadata(9*16, Direction.LEFT, Direction.NONE));
        metadataQueue.add(new Metadata(5*16, Direction.RIGHT, Direction.NONE));
        metadataQueue.add(new Metadata(19*16, Direction.LEFT, Direction.NONE));
        metadataQueue.add(new Metadata(7*16, Direction.LEFT, Direction.NONE));
        metadataQueue.add(new Metadata(7*16, Direction.LEFT, Direction.NONE));
        metadataQueue.add(new Metadata(20*16, Direction.RIGHT, Direction.NONE));
        metadataQueue.add(new Metadata(6*16, Direction.RIGHT, Direction.NONE));
        metadataQueue.add(new Metadata(4*16, Direction.NONE, Direction.DOWN));
        metadataQueue.add(new Metadata(4*16, Direction.NONE, Direction.DOWN));
        metadataQueue.add(new Metadata(4*16, Direction.NONE, Direction.DOWN));
        metadataQueue.add(new Metadata(4*16, Direction.NONE, Direction.DOWN));
        metadataQueue.add(new Metadata(4*16, Direction.LEFT, Direction.NONE));
        metadataQueue.add(new Metadata(15*16, Direction.LEFT, Direction.NONE));
        metadataQueue.add(new Metadata(15*16, Direction.LEFT, Direction.NONE));

        return metadataQueue;
    }
}

