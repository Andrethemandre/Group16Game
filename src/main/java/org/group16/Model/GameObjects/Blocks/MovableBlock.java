package org.group16.Model.GameObjects.Blocks;

import org.group16.Model.GameObjects.CollisionBox;
import org.group16.Model.GameObjects.MovableGameObject;
import org.group16.Model.GameObjects.Positionable;

public class MovableBlock extends Positionable implements MovableGameObject{
    private int speed;
    private CollisionBox collisionBox;

    @Override
    public void move() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
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
