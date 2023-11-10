package org.group16.Model.Level;

import org.group16.Model.GameObjects.GameObject;

public class FirstLevel extends Level{
    private final static int playerStartX = 0;
    private final static int playerStartY = 4;
    
   // Construct the level by positioning game objects in the grid
    public FirstLevel(){
        GameObject[][] secondLevelGrid =  getGrid();
        secondLevelGrid[playerStartX][playerStartY] = getPlayer();
    }
    
}
