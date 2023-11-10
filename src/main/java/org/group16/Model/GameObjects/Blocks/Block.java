package org.group16.Model.GameObjects.Blocks;

import org.group16.Model.GameObjects.CollisionBox;
import org.group16.Model.GameObjects.GameObject;
import org.group16.Model.GameObjects.Positionable;

public class Block extends Positionable implements GameObject {
    private CollisionBox collisionBox;

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
