package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.Movable;

public interface IMovableEnemy extends IEnemy, Movable {
    void toggleDirection();
    int getMovementSpeed();
}
