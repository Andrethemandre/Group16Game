package org.group16.Model.GameObjects.PowerUp;

import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.IGameObject;
import org.group16.Model.GameObjects.Movable;
import org.group16.Model.Observers.CanDie;

public interface IPowerUp extends IGameObject, Movable, CanDie {
    void use();
    boolean isMoving();
    Direction getDirection();

    
}
