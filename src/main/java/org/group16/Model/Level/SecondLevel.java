package org.group16.Model.Level;

import org.group16.Model.GameObjects.GameObject;

public class SecondLevel extends Level {
    private final static int playerStartX = 0;
    private final static int playerStartY = 4;

    // Construct the level by positioning game objects in the grid
    public SecondLevel(){
        GameObject[][] secondLevelGrid =  getGrid();
        secondLevelGrid[playerStartX][playerStartY] = getPlayer();
    }
    
}
