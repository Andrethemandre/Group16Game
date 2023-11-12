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
    private CollisionBox collisionBox = new CollisionBox(32, 32);
    private final GameObjectType type = GameObjectType.PLAYER____;;

    public Player(int x, int y) {
        super(x, y);
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
