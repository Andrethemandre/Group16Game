
package org.group16.Model.Level;

import org.group16.Model.GameObjects.Blocks.MovableBlock;

import java.util.List;

public interface LevelWithMovableBlocks {
    List<MovableBlock> getMovableBlocks();

    void moveMovableBlocks();
}