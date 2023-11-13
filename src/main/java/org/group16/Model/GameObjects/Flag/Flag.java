package org.group16.Model.GameObjects.Flag;

import org.group16.Model.GameObjects.IGameObject;
import org.group16.Model.GameObjects.GameObject;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.Positionable;

public class Flag extends Positionable implements IGameObject{
    private GameObject innerGameObject;

    public Flag(int x, int y) {
        super(x, y);
        innerGameObject = new GameObject(GameObjectType.GOAL______, 16, 16);
    }
    
    @Override
    public int getWidth() {
        return innerGameObject.getWidth();
    }

    @Override
    public int getHeight() {
        return innerGameObject.getHeight();
    }

    @Override
    public GameObjectType getType() {
        return innerGameObject.getType();
    }
}
