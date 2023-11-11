package org.group16.Model.Level;

import org.group16.Model.GameObjects.GameObject;
import static org.group16.Model.GameObjects.GameObjectType.STATIONARY;
import static org.group16.Model.GameObjects.GameObjectType.AIR;

public class FirstLevel extends Level{
    private final static int playerStartX = 0;
    private final static int playerStartY = 4;

    //matrix 80X45 to represent level 1   
    private int[][]  level1 = {

   

   
   // Construct the level by positioning game objects in the grid
    public FirstLevel(){
        GameObject[][] secondLevelGrid =  getGrid();
        secondLevelGrid[playerStartX][playerStartY] = getPlayer();
    }

    public int[][] getLevel(){
        return this.level1;
    }
    
}
