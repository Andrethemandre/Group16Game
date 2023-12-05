package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.GameObjectType;

public class TrapFactory {
    public static ITrap createTrapAt(GameObjectType type, int x, int y) {
        switch(type) {
            case SPIKE_____:
                return new Spike(x, y);
            default:
                throw new IllegalArgumentException("Invalid trap type");
        }
    }
}
