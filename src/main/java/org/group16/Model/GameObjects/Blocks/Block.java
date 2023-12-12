package org.group16.Model.GameObjects.Blocks;

import org.group16.Model.GameObjects.IGameObject;
import org.group16.Model.Utility.Settings;
import org.group16.Model.GameObjects.GameObject;
import org.group16.Model.GameObjects.GameObjectType;

class Block implements IBlock {
    private GameObject innerGameObject;

    Block(GameObjectType blockType, int x, int y) {
        innerGameObject = new GameObject(blockType, x, y, Settings.TILE_SIZE, Settings.TILE_SIZE);
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

    void setX(int x) {
        this.innerGameObject.setX(x);
    }

    void setY(int y) {
        this.innerGameObject.setY(y);
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

}
