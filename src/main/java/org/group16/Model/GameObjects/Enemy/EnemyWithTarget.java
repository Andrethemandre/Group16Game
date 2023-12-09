package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.IGameObject;

public interface EnemyWithTarget extends IMovableEnemy {
    EnemyState getCurrentState();

    void setTargetCoordinates(int x, int y);

    void checkCollision(IGameObject otherGameObject);
}