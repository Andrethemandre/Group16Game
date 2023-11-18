package org.group16.Model.GameObjects;

import static org.group16.Model.GameObjects.GameObjectType.Powerup___;

import java.awt.Rectangle;

public class PowerUp implements IGameObject {
    private GameObject innerGameObject;

     public PowerUp(int x, int y) {
        innerGameObject = new GameObject(Powerup___, x, y, 16, 16);
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

    @Override
    public boolean checkCollision(IGameObject otherGameObject) {
        return innerGameObject.checkCollision(otherGameObject);
    }

    @Override
    public Rectangle getHitBox() {
        // TODO Auto-generated method stub
        return innerGameObject.getHitBox();
    }
}

