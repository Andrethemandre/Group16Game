package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.AffectedByGravity;
import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.GameObjectType;

public class FlyingEnemy extends MovableEnemy implements AffectedByGravity {
    private Direction patrolDirection;
    private int patrolDistance;
    private int traveledDistance;
    private double timeCounter = 0;

    public FlyingEnemy(int x, int y, int patrolDistance) {
        super(GameObjectType.FLYING____, x, y);
        this.patrolDistance = patrolDistance;
        this.patrolDirection = Direction.LEFT;
        this.traveledDistance = 0;
        setMovementSpeed(1);
    }

    @Override
    public void move() {
//        timeCounter++;
//        if(timeCounter < 1.2){
//           return;
//        }
//        timeCounter = 0; // reset moveCounter

        if(patrolDirection == Direction.RIGHT) {
            setX(getX() + getMovementSpeed());
            setY(getY() + getMovementSpeed());
            traveledDistance += getMovementSpeed();
            if (traveledDistance >= patrolDistance) {
                patrolDirection = Direction.LEFT;
                traveledDistance = 0;
            }
        }

        else if(patrolDirection == Direction.LEFT) {
            setX(getX() - getMovementSpeed());
            setY(getY() - getMovementSpeed());
            traveledDistance += getMovementSpeed();
            if (traveledDistance >= patrolDistance) {
                patrolDirection = Direction.RIGHT;
                traveledDistance = 0;
            }
        }
    }



    @Override
    public boolean isDead() {
        return false;
    }

    @Override
    public void update() {
        move();
    }



    @Override
    public void updateHealth(int damage) {

    }
}
