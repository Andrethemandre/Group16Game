package org.group16.Model.GameObjects.Blocks;

import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.IGameObject;

class StationaryBlock implements IBlock {
    Block innerBlock;

    StationaryBlock(int x, int y) {
        innerBlock = new Block(GameObjectType.STATIONARY, x, y);
    }

    @Override
    public int getWidth() {
        return innerBlock.getWidth();
    }

    @Override
    public int getHeight() {
        return innerBlock.getHeight();
    }

    @Override
    public void update() {
        // Stationary blocks don't need to update
    }

    @Override
    public GameObjectType getType() {
        return innerBlock.getType();
    }

    @Override
    public int getX() {
        return innerBlock.getX();
    }

    @Override
    public int getY() {
        return innerBlock.getY();
    }

    @Override
    public boolean collidesWith(IGameObject otherGameObject) {
        return innerBlock.collidesWith(otherGameObject);
    }
}
