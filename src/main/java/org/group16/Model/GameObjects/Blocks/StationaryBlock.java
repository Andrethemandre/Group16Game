package org.group16.Model.GameObjects.Blocks;

import org.group16.Model.GameObjects.GameObjectType;

class StationaryBlock extends Block {

    StationaryBlock(int x, int y) {
        super(GameObjectType.STATIONARY, x, y);
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
