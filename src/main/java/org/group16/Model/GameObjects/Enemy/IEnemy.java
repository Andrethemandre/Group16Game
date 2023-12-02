package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.IGameObject;
import org.group16.Model.Observers.HasHealth;

public interface IEnemy extends IGameObject, HasHealth {
    void dealDamage(HasHealth otherGameObject);
}
