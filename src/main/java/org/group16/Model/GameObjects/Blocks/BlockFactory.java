package org.group16.Model.GameObjects.Blocks;

import org.group16.Model.GameObjects.GameObjectType;

public class BlockFactory {
    public static Block createBlockAt(GameObjectType blockType, int x, int y) {
        switch (blockType) {
            case STATIONARY:
                return new StationaryBlock(x, y);
            case MOVABLE___:
                return new MovableBlock(x, y);
            default:
                throw new IllegalArgumentException("Block type is not supported");
        }
    }
}
