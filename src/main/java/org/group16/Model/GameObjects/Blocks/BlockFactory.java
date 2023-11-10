package org.group16.Model.GameObjects.Blocks;

public class BlockFactory {
    public static Block createBlock(BlockType blockType) {
        switch (blockType) {
            case Normal:
                return new NormalBlock();
            case Movable:
                return new MovableBlock();
            default:
                throw new IllegalArgumentException("Block type is not supported");
        }
    }
}
