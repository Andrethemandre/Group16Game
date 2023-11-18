package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.Player.Player;

public class Spike extends Enemy {

    Spike(int x, int y) {
        super(GameObjectType.SPIKE_____, x, y);
    }

    @Override
    public void setHealth(int newHealth) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setHealth'");
    }

    @Override
    public int getHealth() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getHealth'");
    }

    @Override
    public void updateHealth(int damage) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateHealth'");
    }

    @Override
    public boolean isDead() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isDead'");
    }
}
