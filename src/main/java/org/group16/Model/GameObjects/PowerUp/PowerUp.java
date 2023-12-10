package org.group16.Model.GameObjects.PowerUp;

import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.GameObject;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.IGameObject;

class PowerUp implements IPowerUp {
    private GameObject innerGameObject;
    private Boolean isMoving;
    private int speed = 5;
    private Direction direction;
    private boolean isDead = false;

    public PowerUp(GameObjectType type, int x, int y, boolean moveable, Direction direction) {
        innerGameObject = new GameObject(type, x, y, 16, 16);
        this.isMoving = moveable;
        this.direction = direction;
    }

    public PowerUp(GameObjectType type, int x, int y) {
        innerGameObject = new GameObject(type, x, y, 16, 16);
        this.isMoving = false;
        this.direction = Direction.NONE;
    }

    @Override
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

    @Override
    public Direction getDirection(){
        return direction;
    }

    @Override
    public boolean isMoving() {
        return isMoving;
    }

    @Override
    public boolean isDead() {
        return isDead;
    }

    @Override
    public void use() {
        isDead = true;
    }

    @Override
    public boolean collidesWith(IGameObject otherGameObject) {
        return innerGameObject.collidesWith(otherGameObject);
    }

    @Override
    public void move() {
        if (isMoving){
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

    @Override
    public int getMovementSpeed() {
        return speed;
    }
}

