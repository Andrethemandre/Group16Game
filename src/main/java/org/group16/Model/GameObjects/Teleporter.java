package org.group16.Model.GameObjects;

public interface Teleporter {
    void teleport(Teleportable teleportable);
    int getDestinationX();
    int getDestinationY();
}
