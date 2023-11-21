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

    private int stepsToMove = 20;

    private int stepsMoved = 0;

    BasicEnemy(int x, int y,int patrolBoundaryLeft,int patrolBoundaryRight) {
        super(GameObjectType.BASIC_____, x, y);
        this.patrolBoundaryLeft = patrolBoundaryLeft;
        this.patrolBoundaryRight = patrolBoundaryRight;
    }
    
    @Override
    public void move() {
       if(stepsMoved <= stepsToMove){
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
    public int getX() {
        return super.getX();
    }

    @Override
    public void setX(int x) {
        super.setX(x);
    }
}
