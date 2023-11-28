package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.AffectedByGravity;
import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.GameObject;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.Player.Player;

public class BasicEnemy extends MovableEnemy implements AffectedByGravity {
    private Direction horizontalDirection;
    private int patrolDistance;
    private int traveledDistance;

    BasicEnemy(int x, int y,int horizontalDistance) {
        super(GameObjectType.BASIC_____, x, y);
        this.patrolDistance = horizontalDistance;
        this.traveledDistance = 0;
        this.horizontalDirection = Direction.RIGHT;
        setMovementSpeed(1);
    }
    
    @Override
    public void move() {
        if(horizontalDirection == Direction.RIGHT){
            setX(getX() + getMovementSpeed());
            traveledDistance += getMovementSpeed();
            if(traveledDistance >= patrolDistance){
                horizontalDirection = Direction.LEFT;
                traveledDistance = 0;
            }
        }
        else if(horizontalDirection == Direction.LEFT){
            setX(getX() - getMovementSpeed());
            traveledDistance += getMovementSpeed();
            if(traveledDistance >= patrolDistance){
                horizontalDirection = Direction.RIGHT;
                traveledDistance = 0;
            }
        }

    }

    public void update() {
        move();
    }

    public int getX() {
        return super.getX();
    }


    public void setX(int x) {
        super.setX(x);
    }

    @Override
    public void updateHealth(int damage) {

    }

    @Override
    public void toggleDirection() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toggleDirection'");
    }
}
