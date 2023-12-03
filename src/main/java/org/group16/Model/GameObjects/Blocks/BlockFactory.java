package org.group16.Model.GameObjects.Blocks;

import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.Level.Metadata;

public class BlockFactory {
    public static Block createBlockAt(GameObjectType blockType, int x, int y, Metadata metadata) {
        switch (blockType) {
            case STATIONARY:
                return new StationaryBlock(x, y);
            case MOVABLE___:
                return new MovableBlock(x, y, metadata.getDistance(), metadata.getHorizontalDirection(),
                        metadata.getVerticalDirection());
            default:
                throw new IllegalArgumentException("Block type is not supported");
        }
    }

    public static MovableBlock createMovableBlockAt(GameObjectType blockType, int x, int y, Metadata metadata) {
        switch (blockType) {
            case MOVABLE___:
                return new MovableBlock(x, y, metadata.getDistance(), metadata.getHorizontalDirection(),
                        metadata.getVerticalDirection());
            default:
                throw new IllegalArgumentException("Block type is not supported");
        }
    }
}
