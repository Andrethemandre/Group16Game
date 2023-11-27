package org.group16.Model.GameObjects.PowerUp;

import static org.group16.Model.GameObjects.GameObjectType.FREEZE____;

import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.Enemy.Enemy;

public class FreezePowerUp extends PowerUp {

    public FreezePowerUp(int x, int y, boolean moveable, Direction direction) {
        super(x, y, moveable, direction, FREEZE____);
    }

    @Override
    public void triggerPowerUp(Enemy enemy) {
        switch (enemy.getType()) {
            case BASIC_____:
                enemy.setFrozen(true);
                this.setRemove(true);
                break;
            
            case SPIKE_____:
                enemy.setFrozen(true);
                this.setRemove(true);
                break;

            
            default:
                break;
        }
    }
    
}
