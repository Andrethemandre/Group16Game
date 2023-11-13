package org.group16.Model.GameObjects;

public interface IGameObject extends IPositionable {
    int getWidth();
    int getHeight();
    GameObjectType getType();
}
