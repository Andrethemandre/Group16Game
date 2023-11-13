package org.group16.Model.GameObjects.Player;

import org.group16.Model.GameObjects.IGameObject;
import org.group16.Model.GameObjects.GameObject;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.Movable;
import org.group16.Model.Observers.Health;

public class Player implements Movable, IGameObject, Health {
    private int xDirection;
    private int yDirection;
    private int movementSpeed;
    private int health;
    private GameObject innerGameObject;

    public Player(int x, int y) {
        innerGameObject = new GameObject(GameObjectType.PLAYER____, x, y, 16, 16);
    }

    public void jump(){}

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getXDirection() {
        return xDirection;
    }

    public void setXDirection(int xDirection) {
        this.xDirection = xDirection;
    }

    public int getYDirection() {
        return yDirection;
    }

    public void setYDirection(int yDirection) {
        this.yDirection = yDirection;
    }

    public int getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(int movementSpeed) {
        this.movementSpeed = movementSpeed;
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
    public void move() {
        setX(getX());
    }

    @Override
    public GameObjectType getType() {
        return innerGameObject.getType();
    }

    @Override
    public int getX() {
        return innerGameObject.getX();
    }

    private void setX(int x) {
        innerGameObject.setX(x);
    }

    @Override
    public int getY() {
        return innerGameObject.getY();
    }

    private void setY(int y) {
        innerGameObject.setY(y);
    }

}
