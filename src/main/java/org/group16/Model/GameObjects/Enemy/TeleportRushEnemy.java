package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.AffectedByGravity;
import org.group16.Model.GameObjects.GameObjectType;

public class TeleportRushEnemy extends MovableEnemy implements AffectedByGravity {

    private int width;
    private int height;


    public TeleportRushEnemy(int x, int y,int width, int height) {
        super(GameObjectType.TELEPORT__, x, y,width,height);
        this.width = width;
        this.height = height;

    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean isDead() {
        return false;
    }

    @Override
    public void update() {}

    @Override
    public void move() {}
    

    @Override
    public void updateHealth(int damage) {
    }
}
