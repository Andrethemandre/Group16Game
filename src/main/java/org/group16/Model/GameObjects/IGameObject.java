package org.group16.Model.GameObjects;

public interface IGameObject extends IPositionable, ICollidable {
    int getWidth();

    int getHeight();

    GameObjectType getType();

    void update();
}
