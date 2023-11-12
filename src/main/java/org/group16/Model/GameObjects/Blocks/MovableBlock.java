package org.group16.Model.GameObjects.Blocks;

import org.group16.Model.GameObjects.GameObjectType;

import org.group16.Model.GameObjects.Movable;

class MovableBlock extends Block implements Movable {
    private int speed;

    MovableBlock(int x, int y) {
        super(GameObjectType.MOVABLE___, x, y);
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
