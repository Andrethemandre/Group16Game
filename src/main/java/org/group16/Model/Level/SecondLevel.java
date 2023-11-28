package org.group16.Model.Level;

import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.Blocks.MovableBlock;

import static org.group16.Model.GameObjects.GameObjectType.STATIONARY;

import java.util.ArrayList;
import java.util.List;

import static org.group16.Model.GameObjects.GameObjectType.AIR_______;
import static org.group16.Model.GameObjects.GameObjectType.GOAL______;
import static org.group16.Model.GameObjects.GameObjectType.MOVABLE___;
import static org.group16.Model.GameObjects.GameObjectType.PLAYER____;
import static org.group16.Model.GameObjects.GameObjectType.SPIKE_____;
import static org.group16.Model.GameObjects.GameObjectType.POWERUP___;
import static org.group16.Model.GameObjects.GameObjectType.SPEAR_____;


public class SecondLevel extends Level implements LevelWithMovableBlocks {

    //matrix 45X30 to represent level 2  
    private static GameObjectType[][] level2 = {{AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,AIR_______,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,AIR_______,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {AIR_______,AIR_______,SPEAR_____,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,},
                                                {PLAYER____,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,STATIONARY,AIR_______,AIR_______,STATIONARY,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,AIR_______,GOAL______,},
                                                {STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,STATIONARY,},                                        
                                                };


    // Construct the level by positioning game objects in the grid
    public SecondLevel() {
        super(level2);
        initializeMovableBlocks();
    }

    // List to keep track of movable blocks
    private List<MovableBlock> movableBlocks;

    // Initialize the movableBlocks list based on the level matrix
    private void initializeMovableBlocks() {
        movableBlocks = new ArrayList<>();

        for (int i = 0; i < level2.length; i++) {
            for (int j = 0; j < level2[i].length; j++) {
                if (level2[i][j] == MOVABLE___) {
                    MovableBlock movableBlock = new MovableBlock(j, i);
                    movableBlocks.add(movableBlock);
                }
            }
        }

        // Set specific values for the first few movable blocks

        if (!movableBlocks.isEmpty()) {
            movableBlocks.get(0).setdirection(40, 180);
            movableBlocks.get(1).setdirection(20, 0);
            movableBlocks.get(2).setdirection(30, 0);

            // Set (0, 0) if you forgot to set the direction for some of the movable blocks
            for (int i = 3; i < movableBlocks.size(); i++) {
                movableBlocks.get(i).setdirection(0, 0);
            }
        }
    }

    // Getter for movableBlocks
    @Override
    public List<MovableBlock> getMovableBlocks() {
        return movableBlocks;
    }

    // Override the update method to move movable blocks
    @Override
    public void moveMovableBlocks() {
        // Update the movable blocks' positions

    }

}
