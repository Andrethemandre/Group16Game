package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.IGameObject;
import org.group16.Model.Observers.CanDie;
import org.group16.Model.Observers.Freezeable;
import org.group16.Model.Observers.HasHealth;

public interface IObstacle extends IGameObject, CanDie, Freezeable {
    void dealDamage(HasHealth otherGameObject);
}
