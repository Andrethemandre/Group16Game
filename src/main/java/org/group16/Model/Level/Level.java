package org.group16.Model.Level;

import java.util.ArrayList;
import java.util.Collection;

import org.group16.Model.GameObjects.GameObject;
import org.group16.Model.GameObjects.GameObjectType;

public abstract class Level {

    private GameObjectType level[][];

    public Level(){
    }

    public  abstract GameObjectType[][] getLevel();

    

}
