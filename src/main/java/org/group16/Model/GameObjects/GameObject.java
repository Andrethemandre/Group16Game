package org.group16.Model.GameObjects;

public interface GameObject extends IPositionable {
    int getWidth();
    int getHeight();
    GameObjectType getType();
}
