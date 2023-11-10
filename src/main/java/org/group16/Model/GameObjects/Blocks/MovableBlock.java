package org.group16.Model.GameObjects.Blocks;

import org.group16.Model.GameObjects.MovableGameObject;

public class MovableBlock extends Block implements MovableGameObject{
    private int speed;

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
