package org.group16.Model.GameObjects.PowerUp;

import static org.group16.Model.GameObjects.GameObjectType.FREEZE____;

import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.Enemy.IEnemy;

public class FreezePowerUp extends PowerUp {

    public FreezePowerUp(int x, int y, boolean moveable, Direction direction) {
        super(FREEZE____, x, y, moveable, direction);
    }

    public FreezePowerUp(int x, int y) {
        super(FREEZE____, x, y);
    }

    @Override
    public void triggerPowerUp(IEnemy enemy) {
        switch (enemy.getType()) {
            case BASIC_____:
                enemy.freeze();
                this.setIsDead(true);
                break;
            
            case SPIKE_____:
                enemy.freeze();
                this.setIsDead(true);
                break;

            default:
                break;
        }
    }
    
}
