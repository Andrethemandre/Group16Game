package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.Movable;

public abstract class MovableEnemy extends Enemy implements Movable {
    private int positionX = 1;
    private int movementSpeed;


    MovableEnemy(GameObjectType enemyType, int x, int y) {
        super(enemyType, x, y);


    }

    public void setMovementSpeed(int movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    public int getmovementSpeed(){
        return movementSpeed;
    }

    public void move(Direction direction){
        setMovementSpeed(2);

        switch (direction){
            case LEFT:
                setX(getX() - movementSpeed);
                break;
            case RIGHT:
                setX(getX() + movementSpeed);
                break;
            default:
                throw new IllegalArgumentException("Invalid direction: " + direction);
        }
    }

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

}
