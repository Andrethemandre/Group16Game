package org.group16.Model.GameObjects.PowerUp;

import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.GameObjectType;

public class PowerUpFactory {
    public static IPowerUp createPowerUpPickUpAt(GameObjectType type, int x, int y) {
        switch(type) {
            case SPEAR_____:
                return new SpearPowerUp(x, y);
            case FREEZE____:
                return new FreezePowerUp(x, y);
            default:
                throw new IllegalArgumentException("Power up type is not supported");
        }
    }

    public static IPowerUp createPowerUpUsableAt(GameObjectType type, int x, int y, boolean moveable, Direction direction) {
        switch(type) {
            case SPEAR_____:
                return new SpearPowerUp(x, y, moveable, direction);
            case FREEZE____:
                return new FreezePowerUp(x, y, moveable, direction);
            default:
                throw new IllegalArgumentException("Power up type is not supported");
        }
    }
}
