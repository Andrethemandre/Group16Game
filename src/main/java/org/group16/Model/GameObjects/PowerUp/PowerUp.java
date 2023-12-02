package org.group16.Model.GameObjects.PowerUp;

import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.GameObject;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.IGameObject;
import org.group16.Model.GameObjects.Movable;
import org.group16.Model.GameObjects.Enemy.IEnemy;
import org.group16.Model.Observers.CanDie;

public abstract class PowerUp implements IGameObject, Movable, CanDie {
    private GameObject innerGameObject;
    private Boolean movable;
    private int speed = 5;
    private Direction direction;
    private boolean isDead = false;

    public PowerUp(GameObjectType type, int x, int y, boolean moveable, Direction direction) {
        innerGameObject = new GameObject(type, x, y, 16, 16);
        this.movable = moveable;
        this.direction = direction;
    }

    public PowerUp(GameObjectType type, int x, int y) {
        innerGameObject = new GameObject(type, x, y, 16, 16);
        this.movable = false;
        this.direction = Direction.NONE;
    }

    public void update() {
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

    public boolean getMovable() {
        return movable;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setIsDead(boolean isDead) {
        this.isDead = isDead;
    }

    @Override
    public boolean collidesWith(IGameObject otherGameObject) {
        return innerGameObject.collidesWith(otherGameObject);
    }

    @Override
    public void move() {
        if (movable){
            switch (direction) {
                case LEFT:
                    innerGameObject.setX(getX() - speed);
                    break;
                case RIGHT:
                    innerGameObject.setX(getX() + speed);
                    break;
                default:
                    break;
            }
        }
    }

    public abstract void triggerPowerUp(IEnemy enemy);
}

