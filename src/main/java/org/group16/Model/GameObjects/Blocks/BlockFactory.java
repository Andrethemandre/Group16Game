package org.group16.Model.GameObjects.Blocks;

import org.group16.Model.GameObjects.GameObjectType;

public class BlockFactory {
    public static Block createBlock(GameObjectType blockType) {
        switch (blockType) {
            case STATIONARY:
                return new StationaryBlock();
            case MOVABLE___:
                return new MovableBlock();
            default:
                throw new IllegalArgumentException("Block type is not supported");
        }
    }
}
