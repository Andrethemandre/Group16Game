package org.group16.Model.GameObjects.Player;

import java.awt.Rectangle;

import org.group16.Model.GameObjects.*;
import org.group16.Model.GameObjects.Blocks.Block;
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
        //int newY = getY() + getYDirection() * getMovementSpeed();
    }

    public void gravity(){       
        yAcceleration = yAcceleration + this.GRAVITYFACTOR;
        if (yAcceleration > 10){
            yAcceleration = 5;
        }
        if(xAcceleration > 1) {
             xAcceleration -= 1; 
         }
        else if (xAcceleration < -1){
             xAcceleration += 1;
        }
        else {
            xAcceleration = 0;
        }
        
        if (xAcceleration == 0){
            System.out.println("still");
        }
        
        
        int newX = getX() + xAcceleration;
        int newY = getY() + yAcceleration;

        setX(newX);
        setY(newY);
    }

    public int getXAcceleration(){
        return xAcceleration;
    }

    public int getYAcceleration(){
        return yAcceleration;
    }

    public void collision(IGameObject otherGameObject){
        innerGameObject.updateHitBox();
        Rectangle otherGameObjectHitBox = otherGameObject.getHitBox();
        Rectangle playerHitbox = getHitBox();

       
        //vertical collision
        playerHitbox.y += yAcceleration;
        if (otherGameObjectHitBox.intersects(playerHitbox)){
            playerHitbox.y -=yAcceleration;
            while(!otherGameObjectHitBox.intersects(playerHitbox) ){
                playerHitbox.y += Math.signum(yAcceleration);
            }
            playerHitbox.y -= Math.signum(yAcceleration);
            yAcceleration = 0;
            setY(playerHitbox.y);
        }

        //x colision
        //playerHitbox.x += xAcceleration;
        if (playerHitbox.intersects(otherGameObjectHitBox)) {
            playerHitbox.x -=xAcceleration;
            while(!playerHitbox.intersects(otherGameObjectHitBox) ){
                playerHitbox.x += Math.signum(xAcceleration);
            }
            playerHitbox.x -= Math.signum(xAcceleration);
            
            xAcceleration = 0;
            setX(playerHitbox.x);           
        }   
    }


    // need to check if player is in the air to fall, so      
    public void update(){
        innerGameObject.updateHitBox();
        gravity();
        innerGameObject.updateHitBox();
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
    public boolean checkCollision(IGameObject otherGameObject) {
        return innerGameObject.checkCollision(otherGameObject);
    }

    @Override
    public Rectangle getHitBox() {
        return innerGameObject.getHitBox();
    }
}
