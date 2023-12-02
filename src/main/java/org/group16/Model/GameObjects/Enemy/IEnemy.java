package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.IGameObject;
import org.group16.Model.Observers.Freezeable;
import org.group16.Model.Observers.HasHealth;

public interface IEnemy extends IGameObject, HasHealth, Freezeable {
    void dealDamage(HasHealth otherGameObject);
    void update();
}
