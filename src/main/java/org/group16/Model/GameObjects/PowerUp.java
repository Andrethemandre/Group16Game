package org.group16.Model.GameObjects;

import static org.group16.Model.GameObjects.GameObjectType.POWERUP___;

public class PowerUp implements IGameObject, Movable {
    private GameObject innerGameObject;
    private Boolean Movable;
    private int speed = 5;
    private Direction direction;

     public PowerUp(int x, int y, boolean moveable, Direction direction) {
        innerGameObject = new GameObject(POWERUP___, x, y, 16, 16);
        this.Movable = moveable;
        this.direction = direction;
    }


    public void update (){
        move();
    }

    @Override
    public GameObjectType getType() {
        return innerGameObject.getType();
    }

    @Override
    public int getX() {
        return innerGameObject.getX();
    }

    @Override
    public int getY() {
        return innerGameObject.getY();
    }

    @Override
    public int getWidth() {
        return innerGameObject.getWidth();
    }

    @Override
    public int getHeight() {
        return innerGameObject.getHeight();
    }

    public boolean getMovable(){
        return Movable;
    }

    @Override
    public boolean collidesWith(IGameObject otherGameObject) {
        return innerGameObject.collidesWith(otherGameObject);
    }

    @Override
    public void move() {
        if (Movable){
            if (direction == Direction.LEFT){
                innerGameObject.setX(getX() - speed);
            }
            else {
                innerGameObject.setX(getX() + speed);
            }
        }
    }
}

