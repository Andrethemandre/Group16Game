package org.group16.Model.GameObjects;

import java.awt.Rectangle;

public interface IGameObject extends IPositionable {
    int getWidth();
    int getHeight();
    GameObjectType getType();
    boolean checkCollision(IGameObject otherGameObject);
    Rectangle getHitBox();
}
