package org.group16.Model.GameObjects.Blocks;

import org.group16.Model.GameObjects.CollisionBox;
import org.group16.Model.GameObjects.Positionable;

public abstract class Block extends Positionable implements IBlock {
    private CollisionBox collisionBox;
    private final BlockType blockType;

    @Override
    public BlockType getBlockType() {
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
        return collisionBox.getWidth();
    }

    @Override
    public int getHeight() {
        return collisionBox.getHeight();
    }
    
}
