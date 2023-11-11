package org.group16.Model.GameObjects.Blocks;

import static org.group16.Model.GameObjects.GameObjectType.MOVABLE;
import org.group16.Model.GameObjects.MovableGameObject;

class MovableBlock extends Block implements MovableGameObject{
    private int speed;

    MovableBlock() {
        super(MOVABLE);
    }

    @Override
    public void move() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }

    @Override
    public int getWidth() {
        return super.getWidth();
    }

    @Override
    public int getHeight() {
        return super.getHeight();
    }
}
