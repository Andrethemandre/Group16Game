package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.CanDie;
import org.group16.Model.GameObjects.Freezable;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.HasHealth;
import org.group16.Model.GameObjects.IGameObject;

public interface IObstacle extends IGameObject, CanDie, Freezable {
    void dealDamage(HasHealth otherGameObject);
    void triggerPowerUp(GameObjectType powerUp);
}
