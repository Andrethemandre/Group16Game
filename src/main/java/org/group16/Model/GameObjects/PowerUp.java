package org.group16.Model.GameObjects;

import static org.group16.Model.GameObjects.GameObjectType.Powerup___;

import java.awt.Rectangle;

public class PowerUp implements IGameObject, Movable {
    private GameObject innerGameObject;
    private Boolean Movable;
    private int speed = 5;
    private int direction;

     public PowerUp(int x, int y, boolean moveable, int direction) {
        innerGameObject = new GameObject(Powerup___, x, y, 16, 16);
        this.Movable = moveable;
        this.direction = direction;
    }


    public void update (){
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

    public boolean getMovable(){
        return Movable;
    }

    @Override
    public boolean checkCollision(IGameObject otherGameObject) {
        return innerGameObject.checkCollision(otherGameObject);
    }

    @Override
    public Rectangle getHitBox() {
        // TODO Auto-generated method stub
        return innerGameObject.getHitBox();
    }

    @Override
    public void move() {
        if (Movable){
            if (direction <1){
                innerGameObject.setX(getX() - speed);
            }
            else {
                innerGameObject.setX(getX() + speed);
            }
        }
    }
}

