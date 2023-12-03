package org.group16.Model.GameObjects.PowerUp;

import static org.group16.Model.GameObjects.GameObjectType.FREEZE____;

import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.Enemy.IEnemy;
import org.group16.Model.GameObjects.Enemy.IObstacle;

public class FreezePowerUp extends PowerUp {

    public FreezePowerUp(int x, int y, boolean moveable, Direction direction) {
        super(FREEZE____, x, y, moveable, direction);
    }

    public FreezePowerUp(int x, int y) {
        super(FREEZE____, x, y);
    }    
}
