package org.group16.Model.GameObjects.PowerUp;

import static org.group16.Model.GameObjects.GameObjectType.POWERUP___;

import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.GameObject;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.IGameObject;
import org.group16.Model.GameObjects.Movable;
import org.group16.Model.GameObjects.Enemy.Enemy;

public abstract class PowerUp implements IGameObject, Movable {
    private GameObject innerGameObject;
    private Boolean Movable;
    private int speed = 5;
    private Direction direction;
    private boolean remove = false;

     public PowerUp(int x, int y, boolean moveable, Direction direction, GameObjectType type) {
        innerGameObject = new GameObject(type, x, y, 16, 16);
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

    public boolean getRemove(){
        return this.remove;
    }

    public void setRemove(boolean remove){
        this.remove = remove;
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

    public abstract void triggerPowerUp(Enemy enemy);
}

