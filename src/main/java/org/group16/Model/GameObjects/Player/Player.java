package org.group16.Model.GameObjects.Player;

import org.group16.Model.GameObjects.*;
import org.group16.Model.Observers.Health;

public class Player implements Movable, IGameObject, Health, AffectedByGravity {
    private boolean moveLeft = false;
    private boolean moveRight = false;
    private boolean doJump = false;
    private int movementSpeed = 5;
    private int health = 3;
    private GameObject innerGameObject;
    private int yAcceleration;
    private int xAcceleration;
    private double previousTime = 0;
    private double currentTime = 6;

    private boolean falling = false;
    private int maxX;
    private int maxY;

    public Player(int x, int y, int maxX, int maxY) {
        innerGameObject = new GameObject(GameObjectType.PLAYER____, x, y, 16, 16);
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public void jump(){
        if (!isFalling()) {
            yAcceleration = -10;
            int newY = getY() + yAcceleration;
            setY(newY);
            falling = true;
            doJump = false;
        }
    }

    public void applyGravity() {       
        yAcceleration = yAcceleration + AffectedByGravity.GRAVITY_FACTOR;
        if (yAcceleration > AffectedByGravity.GRAVITY_LIMIT){
            yAcceleration = AffectedByGravity.GRAVITY_LIMIT;
        }
        
        int newY = getY() + yAcceleration;
        setY(newY);
    }

    public void applyFriction() {
        if (xAcceleration > 1) {
            xAcceleration -= 1; 
        }
        else if (xAcceleration < -1) {
            xAcceleration += 1;
        }
        else {
            xAcceleration = 0;
        }
    }

    public int getXAcceleration(){
        return xAcceleration;
    }

    public int getYAcceleration(){
        return yAcceleration;
    }

    public void collision(IGameObject otherGameObject) {
        setY(getY() + yAcceleration);
        if (this.collidesWith(otherGameObject)){
            setY(getY() - yAcceleration);
            while (!this.collidesWith(otherGameObject)){
                setY(getY() + Integer.signum(yAcceleration));
            }
            setY(getY() - Integer.signum(yAcceleration));
            yAcceleration = 0;
            falling = false;
        } else {
            setY(getY() - yAcceleration);
        }
        if (this.collidesWith(otherGameObject)){
            setX(getX() - xAcceleration);
            while (!this.collidesWith(otherGameObject)){
                setX(getX() + Integer.signum(xAcceleration));
            }
            setX(getX() - Integer.signum(xAcceleration));
            xAcceleration = 0;
        }
    }

    @Override
    public void move() {
        if (moveLeft) {
            if (xAcceleration >= 0) {
                    xAcceleration -= movementSpeed;
                } else {
                    xAcceleration = -movementSpeed;
                }
        } 
        if (moveRight) {
            if (xAcceleration <= 0) {
                    xAcceleration += movementSpeed;
                } else {
                    xAcceleration = movementSpeed;
                }
        }

        int newX = getX() + xAcceleration;
        setX(newX);
    }

    public void startJumping() {
        doJump = true;
    }

    // need to check if player is in the air to fall, so      
    public void update() {
        move();
        applyGravity();
        applyFriction();
        if (doJump) {
            jump();
        }
    }

    public boolean isFalling() {
        return this.falling;
        
    }
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void startMovingInDirection(Direction direction) {
        switch (direction) {
            case LEFT:
                moveLeft = true;
                break;
            case RIGHT:
                moveRight = true;
                break;
            default:
                break;
        }
    }

    public void stopMovingInDirection(Direction direction) {
        switch (direction) {
            case LEFT:
                moveLeft = false;
                break;
            case RIGHT:
                moveRight = false;
                break;
            default:
                break;
        }
    }

    public int getMovementSpeed() {
        return movementSpeed;
    }

    private void setMovementSpeed(int movementSpeed) {
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
    public GameObjectType getType() {
        return innerGameObject.getType();
    }

    public boolean isDead() {
        return health == 0;
    }

    @Override
    public void updateHealth(int damage) {
        currentTime = System.currentTimeMillis()/1000.0;
        
        if (health > 0 && currentTime - previousTime > 2) {
            health -= damage;
            previousTime = currentTime;
        }    
    }
    @Override
    public boolean collidesWith(IGameObject otherGameObject) {
        return innerGameObject.collidesWith(otherGameObject);
    }

    @Override
    public int getX() {
        return innerGameObject.getX();
    }

    private void setX(int x) {
        x = keepXInBox(x);

        innerGameObject.setX(x);
    }

    private int keepXInBox(int x) {
        if (x < 0) {
            x = 0;
        } else if (x > maxX - getWidth()) {
            x = maxX - getWidth();
        }
        return x;
    }

    @Override
    public int getY() {
        return innerGameObject.getY();
    }

    private void setY(int y) {
        if (y < 0) {
            y = 0;
        // when player falls of, player is dead.
        } else if (y > maxY + getHeight()) {
            health = 0;
        }
        innerGameObject.setY(y);
    }
}