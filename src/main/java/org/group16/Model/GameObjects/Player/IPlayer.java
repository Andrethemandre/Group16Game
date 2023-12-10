package org.group16.Model.GameObjects.Player;

import org.group16.Model.GameObjects.AffectedByGravity;
import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.IGameObject;
import org.group16.Model.GameObjects.Movable;
import org.group16.Model.GameObjects.Teleportable;
import org.group16.Model.GameObjects.Blocks.ITeleportBlock;

import org.group16.Model.Observers.HasHealth;

public interface IPlayer extends Movable, IGameObject, HasHealth, AffectedByGravity, Teleportable {
    void startMovingInDirection(Direction direction);

    void stopMovingInDirection(Direction direction);

    Direction getDirection();

    boolean isFalling();

    void startJumping();

    void checkCollision(IGameObject otherGameObject);

    void setCurrentPowerUp(GameObjectType hasPowerUp);

    GameObjectType getCurrentPowerUp();
}
