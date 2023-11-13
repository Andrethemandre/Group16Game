package org.group16.Model.GameObjects.Blocks;

import org.group16.Model.GameObjects.SizeHandler;
import org.group16.Model.GameObjects.IGameObject;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.Positionable;

public abstract class Block extends Positionable implements IGameObject {
    private SizeHandler size = new SizeHandler(16, 16);
    private final GameObjectType blockType;
    

    Block(GameObjectType blockType, int x, int y) {
        super(x, y);
        this.blockType = blockType;

    }

    @Override
    public GameObjectType getType() {
        return blockType;
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
        return size.getWidth();
    }

    @Override
    public int getHeight() {
        return size.getHeight();
    }
}
