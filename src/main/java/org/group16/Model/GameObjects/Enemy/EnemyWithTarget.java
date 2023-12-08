package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.Enemy.EnemyBehavior;

public interface EnemyWithTarget extends IMovableEnemy {
    EnemyState getCurrentState();


    void setTargetCoordinates(int x, int y);








}
