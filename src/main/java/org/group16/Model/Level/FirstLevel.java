package org.group16.Model.Level;

import org.group16.Model.GameObjects.GameObjectType;

import static org.group16.Model.GameObjects.GameObjectType.MOVABLE___;
import static org.group16.Model.GameObjects.GameObjectType.STATIONARY;
import static org.group16.Model.GameObjects.GameObjectType.AIR_______;
import static org.group16.Model.GameObjects.GameObjectType.GOAL______;
import static org.group16.Model.GameObjects.GameObjectType.PLAYER____;
import static org.group16.Model.GameObjects.GameObjectType.Powerup___;
import static org.group16.Model.GameObjects.GameObjectType.SPIKE_____;

public class FirstLevel extends Level {
    // matrix 45X30 to represent level 1
    private static GameObjectType[][] level1 = {{AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
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
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,MOVABLE___,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,MOVABLE___,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {PLAYER____,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,AIR_______,SPIKE_____,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,GOAL______,AIR_______,},
                                                {STATIONARY,STATIONARY,AIR_______,AIR_______,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,},                                        
                                                };

    // Construct the level by positioning game objects in the grid
    public FirstLevel() {
        super(level1);
    }
}
