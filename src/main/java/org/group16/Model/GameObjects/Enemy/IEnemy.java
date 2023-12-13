package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.HasHealth;

public interface IEnemy extends IObstacle, HasHealth {
    Direction getDirection();
}
