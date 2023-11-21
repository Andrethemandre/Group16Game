package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.AffectedByGravity;
import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.GameObject;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.Player.Player;

public class BasicEnemy extends MovableEnemy implements AffectedByGravity {
    private Direction direction = Direction.RIGHT;
    private GameObject gameObject;
    private int patrolBoundaryLeft;
    private int patrolBoundaryRight;

    private int stepsToMove = 5;

    private int stepsMoved = 0;

    BasicEnemy(int x, int y,int patrolBoundaryLeft,int patrolBoundaryRight) {
        super(GameObjectType.BASIC_____, x, y);
//        if (x < patrolBoundaryLeft || x > patrolBoundaryRight) {
//            throw new IllegalArgumentException("Initial position is outside patrol boundaries");
//        }
        this.patrolBoundaryLeft = patrolBoundaryLeft;
        this.patrolBoundaryRight = patrolBoundaryRight;
    }



    public void patrol() {
        if (direction == Direction.RIGHT) {
            if (getX() >= patrolBoundaryRight) {
                direction = Direction.LEFT;
            }
        } else if (direction == Direction.LEFT) {
            if (getX() <= patrolBoundaryLeft) {
                direction = Direction.RIGHT;
            }
        }
    }
    @Override
    public void move() {
        patrol();

        if (direction == Direction.RIGHT) {
            if (stepsMoved < stepsToMove) {
                super.move(); // This will call the move method of the superclass (MovableEnemy), which updates the x-coordinate.
                stepsMoved++;
            } else {
                direction = Direction.LEFT;
                stepsMoved = 0;
            }
        } else if (direction == Direction.LEFT) {
            if (stepsMoved < stepsToMove) {
                super.move(); // Similarly, call the move method of the superclass.
                stepsMoved++;
            } else {
                direction = Direction.RIGHT;
                stepsMoved = 0;
            }
        }
    }

    private void setX(int i) {

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setX'");
    }


    @Override
    public void setHealth(int newHealth) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setHealth'");
    }

    @Override
    public boolean isDead() {
        return false;
    }

    @Override
    public void updateHealth(int damage) {

    }

    @Override
    public int getHealth() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getHealth'");
    }

    public void update() {
        move();
    }





    @Override
    public void dealDamage(Player player) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dealDamage'");
    }





}
