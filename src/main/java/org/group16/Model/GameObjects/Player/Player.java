package org.group16.Model.GameObjects.Player;

import org.group16.Model.GameObjects.*;
import org.group16.Model.Observers.Health;

public class Player implements Movable, IGameObject, Health, AffectedByGravity {
    private int xDirection;
    private int yDirection;
    private int movementSpeed;
    private int health = 3;
    private GameObject innerGameObject;
    private int yAcceleration;
    private int xAcceleration;
    private double previousTime = 0;
    private double currentTime = 6;

    private boolean falling = false;

    public Player(int x, int y) {
        innerGameObject = new GameObject(GameObjectType.PLAYER____, x, y, 16, 16);
    }

    public void jump(){
        yAcceleration = -10;
        int newY = getY() + yAcceleration;
        setY(newY);
    }

    public void applyGravity() {       
        yAcceleration = yAcceleration + AffectedByGravity.GRAVITY_FACTOR;
        if (yAcceleration > 10){
            yAcceleration = 5;
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
        
        int newX = getX() + xAcceleration;
        setX(newX);
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

    // need to check if player is in the air to fall, so      
    public void update(){
        applyGravity();
        applyFriction();
    }

    public void stopFalling(int stopPosition){
        if(isFalling()){
            setYDirection(0);
            setY(stopPosition);
            update();
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
        if(yDirection != 0){
            this.falling = true;
        }
        else{
            this.falling = false;
        }

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
        setMovementSpeed(5);
        int movementSpeed = getMovementSpeed();
        if (getXDirection() < 1){
            xAcceleration = -movementSpeed;
        }
        else {
            xAcceleration = +movementSpeed;
        } 
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

    private boolean collidesWithInX(IGameObject otherGameObject) {
        return (this.getX() < otherGameObject.getX() + otherGameObject.getWidth() &&
                this.getX() + this.getWidth() > otherGameObject.getX()) ||
               (otherGameObject.getX() < this.getX() + this.getWidth() &&
                otherGameObject.getX() + otherGameObject.getWidth() > this.getX());
    }

    private boolean collidesWithInY(IGameObject otherGameObject) {
        return (this.getY() < otherGameObject.getY() + otherGameObject.getHeight() &&
                this.getY() + this.getHeight() > otherGameObject.getY()) ||
               (otherGameObject.getY() < this.getY() + this.getHeight() &&
                otherGameObject.getY() + otherGameObject.getHeight() > this.getY());
    }
}