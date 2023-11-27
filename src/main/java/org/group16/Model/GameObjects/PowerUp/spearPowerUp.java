package org.group16.Model.GameObjects.PowerUp;

import static org.group16.Model.GameObjects.GameObjectType.SPEAR_____;

import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.Enemy.Enemy;

public class SpearPowerUp extends PowerUp {

    public SpearPowerUp(int x, int y, boolean moveable, Direction direction) {
        super(x, y, moveable, direction, SPEAR_____);
    }

    @Override
    public void triggerPowerUp(Enemy enemy) {
        switch (enemy.getType()) {
            case BASIC_____:
                enemy.setIsDead(true);
                this.setRemove(true);
                break;

            case SPIKE_____:
                this.setRemove(true);
                break;

            default:
                break;
        }
        
    }

    


    
}
