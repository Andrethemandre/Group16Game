package org.group16.Model.Level;

import org.group16.Model.GameObjects.GameObjectType;

public class SecondLevel extends Level {
    private static GameObjectType[][] level2;

    // Construct the level by positioning game objects in the grid
    public SecondLevel(){
        super(level2);
    }
    
}
