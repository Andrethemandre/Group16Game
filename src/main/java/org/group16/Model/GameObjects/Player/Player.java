package org.group16.Model.GameObjects.Player;

import org.group16.Model.GameObjects.SizeHandler;
import org.group16.Model.GameObjects.IGameObject;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.Movable;
import org.group16.Model.GameObjects.Positionable;
import org.group16.Model.Observers.Health;

public class Player extends Positionable implements Movable, IGameObject, Health {
    private int xDirection;
    private int yDirection;
    private int movementSpeed;
    private int health;
    private SizeHandler size = new SizeHandler(16, 16);
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
        return size.getWidth();
    }

    @Override
    public int getHeight() {
        return size.getHeight();
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
