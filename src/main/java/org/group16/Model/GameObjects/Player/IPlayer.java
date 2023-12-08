package org.group16.Model.GameObjects.Player;

import org.group16.Model.GameObjects.AffectedByGravity;
import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.IGameObject;
import org.group16.Model.GameObjects.Movable;
import org.group16.Model.GameObjects.Blocks.IBlock;
import org.group16.Model.GameObjects.Blocks.TeleportBlock;
import org.group16.Model.Observers.HasHealth;

public interface IPlayer extends Movable, IGameObject, HasHealth, AffectedByGravity, IBlock {
    void startMovingInDirection(Direction direction);

    void stopMovingInDirection(Direction direction);

    Direction getDirection();

    boolean isFalling();

    void startJumping();

    void collision(IGameObject otherGameObject);

    void setCurrentPowerUp(GameObjectType hasPowerUp);

    GameObjectType getCurrentPowerUp();

    void teleport(TeleportBlock teleportBlock);
}
