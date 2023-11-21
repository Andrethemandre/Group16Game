package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.AffectedByGravity;
import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.GameObject;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.Player.Player;

public class BasicEnemy extends MovableEnemy implements AffectedByGravity {
    private Direction patrolDirection   = Direction.RIGHT;
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



//    public void patrol() {
//        if (direction == Direction.RIGHT) {
//            if (getX() >= patrolBoundaryRight) {
//                direction = Direction.LEFT;
//                System.out.println("change direction to left" + getX());
//            }
//        } else if (direction == Direction.LEFT) {
//            if (getX() <= patrolBoundaryLeft) {
//                direction = Direction.RIGHT;
//                System.out.println("change direction to right" + getX());
//            }
//        }
//    }
    @Override
    public void move() {
       if(stepsMoved < stepsToMove){
           move(patrolDirection);
           stepsMoved++;
       } else{
            changeDirection();
       }
    }

    private void changeDirection(){
        if (patrolDirection == Direction.RIGHT){
            patrolDirection = Direction.LEFT;
        } else {
            patrolDirection = Direction.RIGHT;
        }

        stepsMoved = 0;
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
    @Override
    public void update() {

        move();
    }





    @Override
    public void dealDamage(Player player) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dealDamage'");
    }


    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public void setX(int x) {
        super.setX(x);
    }
}
