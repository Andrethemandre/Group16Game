package org.group16.Model.GameObjects.Blocks;

import org.group16.Model.GameObjects.GameObject;

public class BlockFactory {
    public static GameObject createBlock(BlockType blockType) {
        switch (blockType) {
            case Normal:
                return new Block();
            case Movable:
                return new MovableBlock();
            default:
                throw new IllegalArgumentException("Block type is not supported");
        }
    }
}
