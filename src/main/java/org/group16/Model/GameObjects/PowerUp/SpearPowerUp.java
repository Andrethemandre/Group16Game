package org.group16.Model.GameObjects.PowerUp;

import static org.group16.Model.GameObjects.GameObjectType.SPEAR_____;

import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.Enemy.IEnemy;

public class SpearPowerUp extends PowerUp {

    public SpearPowerUp(int x, int y, boolean moveable, Direction direction) {
        super(SPEAR_____, x, y, moveable, direction);
    }

    public SpearPowerUp(int x, int y) {
        super(SPEAR_____, x, y);
    }

    @Override
    public void triggerPowerUp(IEnemy enemy) {
        switch (enemy.getType()) {
            case BASIC_____:
                enemy.updateHealth(enemy.getHealth());
                this.setIsDead(true);
                break;

            case SPIKE_____:
                this.setIsDead(true);
                break;

            default:
                break;
        }   
    }
}
