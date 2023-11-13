package org.group16.Model.GameObjects.Flag;

import org.group16.Model.GameObjects.IGameObject;
import org.group16.Model.GameObjects.GameObject;
import org.group16.Model.GameObjects.GameObjectType;

public class Flag implements IGameObject{
    private GameObject innerGameObject;

    public Flag(int x, int y) {
        innerGameObject = new GameObject(GameObjectType.GOAL______, x, y, 16, 16);
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

    @Override
    public int getX() {
        return innerGameObject.getX();
    }

    @Override
    public int getY() {
        return innerGameObject.getY();
    }
}
