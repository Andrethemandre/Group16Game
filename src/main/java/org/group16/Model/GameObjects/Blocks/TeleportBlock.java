package org.group16.Model.GameObjects.Blocks;

import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.IGameObject;

class TeleportBlock implements ITeleportBlock {
    private Block innerBlock;
    private int destinationX;
    private int destinationY;

    TeleportBlock(int x, int y, int destinationX, int destinationY) {
        innerBlock = new Block(GameObjectType.TELEPORTER, x, y);
        this.destinationX = destinationX;
        this.destinationY = destinationY;
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

    @Override
    public int getDestinationX() {
        return destinationX;
    }

    @Override
    public int getDestinationY() {
        return destinationY;
    }

    // Add other necessary methods or overrides if needed
}