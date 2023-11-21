package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.IGameObject;
import org.group16.Model.GameObjects.Movable;

public abstract class MovableEnemy extends Enemy implements Movable, IGameObject {
    private int positionX = 1;


    MovableEnemy(GameObjectType enemyType, int x, int y) {
        super(enemyType, x, y);

    }



    public void move(Direction direction){
        switch (direction){
            case LEFT:
                positionX -= 1;
                System.out.println("left"   + positionX);
                break;
            case RIGHT:
                positionX += 1;
                System.out.println("right" + positionX);
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



    public void patrol(){

    }
}
