package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.IGameObject;
import org.group16.Model.Observers.CanDie;
import org.group16.Model.Observers.Freezable;
import org.group16.Model.Observers.HasHealth;

public interface IObstacle extends IGameObject, CanDie, Freezable {
    void dealDamage(HasHealth otherGameObject);
    void triggerPowerUp(GameObjectType powerUp);
}
