package org.group16.Model.GameObjects.Blocks;

import org.group16.Model.GameObjects.IGameObject;

import org.group16.Model.GameObjects.GameObject;
import org.group16.Model.GameObjects.GameObjectType;

public abstract class Block implements IGameObject {
    private GameObject innerGameObject;

    Block(GameObjectType blockType, int x, int y) {
        innerGameObject = new GameObject(blockType, x, y, 16, 16);
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

    @Override
    public int getWidth() {
        return innerGameObject.getWidth();
    }

    @Override
    public int getHeight() {
        return innerGameObject.getHeight();
    }

    @Override
    public boolean collidesWith(IGameObject otherGameObject) {
        return innerGameObject.collidesWith(otherGameObject);
    }

    public void setX(int x) {
        this.innerGameObject.setX(x);
    }

    public void setY(int y) {
        this.innerGameObject.setY(y);
    }
}
