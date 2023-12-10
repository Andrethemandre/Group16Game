package org.group16.Model.GameObjects.Blocks;

import static org.group16.Model.GameObjects.GameObjectType.TELEPORTER;

import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.Level.Metadata;

public class BlockFactory {
    public static IBlock createBlockAt(GameObjectType blockType, int x, int y) {
        switch (blockType) {
            case STATIONARY:
                return new StationaryBlock(x, y);
            default:
                throw new IllegalArgumentException("Block type is not supported");
        }
    }

    public static IMovableBlock createMovableBlockAt(GameObjectType blockType, int x, int y, Metadata metadata) {
        switch (blockType) {
            case MOVABLE___:
                return new MovableBlock(x, y, metadata.getDistance(), metadata.getHorizontalDirection(),
                        metadata.getVerticalDirection());
            default:
                throw new IllegalArgumentException("Block type is not supported");
        }
    }

    public static ITeleportBlock createTeleportBlockAt(GameObjectType blockType, int x, int y, Metadata metadata) {
        switch (blockType) {
            case TELEPORTER:
                return new TeleportBlock(x, y, metadata.getDestinationX(), metadata.getDestinationY());
            default:
                throw new IllegalArgumentException("Block type is not supported");
        }
    }
}
