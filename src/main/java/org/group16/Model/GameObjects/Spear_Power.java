package org.group16.Model.GameObjects;

import static org.group16.Model.GameObjects.GameObjectType.BASIC_____;
import static org.group16.Model.GameObjects.GameObjectType.SPEAR_____;

import org.group16.Model.GameObjects.Enemy.Enemy;

public class Spear_Power extends PowerUp {

    public Spear_Power(int x, int y, boolean moveable, Direction direction) {
        super(x, y, moveable, direction,SPEAR_____);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void triggerPowerUp(Enemy enemy) {
        switch (enemy.getType()) {
            case BASIC_____:
                enemy.setIsDead(true);
                this.setRemove(true);
                break;
        
            default:
                break;
        }
        
    }

    


    
}
