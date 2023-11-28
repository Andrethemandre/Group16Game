package org.group16.Model.GameObjects.PowerUp;

import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.PowerUp.SpearPowerUp;
import org.group16.Model.GameObjects.PowerUp.PowerUp;
import org.group16.Model.GameObjects.PowerUp.FreezePowerUp;

public class PowerUpFactory {
    public static PowerUp createPowerUpPickUpAt(GameObjectType type, int x, int y) {
        switch(type) {
            case SPEAR_____:
                return new SpearPowerUp(x, y);
            case FREEZE____:
                return new FreezePowerUp(x, y);
            default:
                throw new IllegalArgumentException("Power up type is not supported");
        }
    }

    public static PowerUp createPowerUpUsableAt(GameObjectType type, int x, int y, boolean moveable, Direction direction) {
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
