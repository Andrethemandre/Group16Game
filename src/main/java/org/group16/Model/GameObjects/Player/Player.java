package org.group16.Model.GameObjects.Player;

import org.group16.Model.GameObjects.CollisionBox;
import org.group16.Model.GameObjects.GameObject;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.Movable;
import org.group16.Model.GameObjects.Positionable;
import org.group16.Model.Observers.Health;

public class Player extends Positionable implements Movable, GameObject, Health {
    private int xDirection;
    private int yDirection;
    private int movementSpeed;
    private int health;
    private CollisionBox collisionBox = new CollisionBox();
    private final GameObjectType type;

    public Player(int x, int y) {
        this.setX(x);
        this.setY(y);
        this.type = GameObjectType.PLAYER____;
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
    public int getWidth() {
        return collisionBox.getWidth();
    }

    @Override
    public int getHeight() {
        return collisionBox.getHeight();
    }

    @Override
    public void move() {
        setX(getX());
    }

    @Override
    public GameObjectType getType() {
        return type;
    }
}
