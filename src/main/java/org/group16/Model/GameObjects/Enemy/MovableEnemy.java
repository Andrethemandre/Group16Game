package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.Movable;

public abstract class MovableEnemy extends Enemy implements Movable {
    private int positionX = 1;
    private int positionY = 1;
    private int movementSpeed;

    MovableEnemy(GameObjectType enemyType, int x, int y) {
        super(enemyType, x, y);
    }

    MovableEnemy(GameObjectType enemyType,int x,  int y, int width, int height){
        super(enemyType, x, y, width, height);
    }

    public void setMovementSpeed(int movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    public int getMovementSpeed(){
        return movementSpeed;
    }

    public abstract void move();

    @Override
    public int getHealth() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getHealth'");
    }

    @Override
    public void setHealth(int newHealth) {

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setHealth'");
    }

    public abstract void toggleDirection();

}
