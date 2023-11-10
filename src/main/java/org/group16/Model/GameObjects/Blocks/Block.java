package org.group16.Model.GameObjects.Blocks;

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
    public void getWidth() {
        return collisionBox.getWidth();
    }

    @Override
    public void getHeight() {
        return collisionBox.getHeight();
    }
    
}
