package org.group16.Model.GameObjects.Blocks;

import org.group16.Model.GameObjects.IGameObject;
import org.group16.Model.GameObjects.GameObject;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.Positionable;

public abstract class Block extends Positionable implements IGameObject {
    private GameObject innerGameObject;
    
    Block(GameObjectType blockType, int x, int y) {
        super(x, y);
        innerGameObject = new GameObject(blockType, 16, 16);
    }

    @Override
    public GameObjectType getType() {
        return innerGameObject.getType();
    }

    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public int getY() {
        return super.getY();
    }

    @Override
    public int getWidth() {
        return innerGameObject.getWidth();
    }

    @Override
    public int getHeight() {
        return innerGameObject.getHeight();
    }
}
