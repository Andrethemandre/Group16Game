package org.group16.Model.GameObjects.Blocks;

import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.Movable;

public interface IMovableBlock extends IBlock, Movable {
    Direction getVerticalDirection();
    int getMovementSpeed();
}
