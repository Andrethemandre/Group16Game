package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.AffectedByGravity;
import org.group16.Model.GameObjects.GameObjectType;

public class TeleportRushEnemy extends MovableEnemy implements AffectedByGravity {
    
    public TeleportRushEnemy(int x, int y,int width, int height) {
        super(GameObjectType.TELEPORT__, x, y,width,height);
    }

    @Override
    public boolean isDead() {
        return false;
    }

    @Override
    public void update() {}

    @Override
    public void move() {}
    

    @Override
    public void updateHealth(int damage) {
    }

    @Override
    public void toggleDirection() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toggleDirection'");
    }
}
