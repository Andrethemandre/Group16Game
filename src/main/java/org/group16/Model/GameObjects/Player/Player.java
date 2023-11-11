package org.group16.Model.GameObjects.Player;

import org.group16.Model.GameObjects.MovableGameObject;
import org.group16.Model.GameObjects.Positionable;
import org.group16.Model.Observers.Health;

public class Player extends Positionable implements MovableGameObject, Health {
    private int xDirection;
    private int yDirection;
    private int movementSpeed;
    private int health;


    public Player() {
    }

    public void jump(){}

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getxDirection() {
        return xDirection;
    }

    public void setxDirection(int xDirection) {
        this.xDirection = xDirection;
    }

    public int getyDirection() {
        return yDirection;
    }

    public void setyDirection(int yDirection) {
        this.yDirection = yDirection;
    }

    public int getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(int movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public int getWidth() {
        // TODO return actual width
        return 0;
    }

    @Override
    public int getHeight() {
        // TODO return actual height
        return 0;
    }

    @Override
    public void move() {

    }
}
