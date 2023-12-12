package org.group16.Model.GameObjects.PowerUp;

import static org.group16.Model.GameObjects.GameObjectType.FREEZE____;

import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.IGameObject;

public class FreezePowerUp implements IPowerUp {
    private PowerUp innerPowerUp;

    public FreezePowerUp(int x, int y, boolean moveable, Direction direction) {
        innerPowerUp = new PowerUp(FREEZE____, x, y, moveable, direction);
    }

    public FreezePowerUp(int x, int y) {
        innerPowerUp = new PowerUp(FREEZE____, x, y);
    }

    @Override
    public int getWidth() {
        return innerPowerUp.getWidth();
    }

    @Override
    public int getHeight() {
        return innerPowerUp.getHeight();
    }

    @Override
    public GameObjectType getType() {
        return innerPowerUp.getType();
    }

    @Override
    public void update() {
        innerPowerUp.update();
    }

    @Override
    public int getX() {
        return innerPowerUp.getX();
    }

    @Override
    public int getY() {
        return innerPowerUp.getY();
    }

    @Override
    public boolean collidesWith(IGameObject otherGameObject) {
        return innerPowerUp.collidesWith(otherGameObject);
    }

    @Override
    public void move() {
        innerPowerUp.move();
    }

    @Override
    public boolean isDead() {
        return innerPowerUp.isDead();
    }

    @Override
    public void use() {
        innerPowerUp.use();
    }

    @Override
    public boolean isMoving() {
        return innerPowerUp.isMoving();
    }   
    
    @Override
    public Direction getDirection(){
        return innerPowerUp.getDirection();
    }

    @Override
    public int getMovementSpeed() {
        return innerPowerUp.getMovementSpeed();
    }
    
}
