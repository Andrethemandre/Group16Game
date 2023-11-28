package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.IGameObject;

import org.group16.Model.GameObjects.GameObject;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.Player.Player;
import org.group16.Model.Observers.Health;

public abstract class Enemy implements IGameObject, Health /* implements Health */ {
    GameObject innerGameObject;
    private int width;
    private int height;

    private int damage = 1;
    private boolean isDead;
    private boolean frozen = false;

    Enemy(GameObjectType enemyType, int x, int y) {
        innerGameObject = new GameObject(enemyType, x, y, 16, 16);
    }

    Enemy(GameObjectType enemyType,int x,  int y, int width, int height){
        innerGameObject = new GameObject(enemyType, x, y, width, height);
    }

    @Override
    public GameObjectType getType() {
        return innerGameObject.getType();
    }

    public void dealDamage(Player player) {
        player.updateHealth(damage);
    }

    @Override
    public boolean collidesWith(IGameObject otherGameObject) {
        return innerGameObject.collidesWith(otherGameObject);
    }

    @Override
    public int getX() {
        return innerGameObject.getX();
    }

    @Override
    public int getY() {
        return innerGameObject.getY();
    }

    void setX(int x) {
        innerGameObject.setX(x);
    }

    void setY(int y) {

        innerGameObject.setY(y);
    }

    @Override
    public int getWidth() {
        return innerGameObject.getWidth();
    }

    @Override
    public int getHeight() {
        return innerGameObject.getHeight();
    }



    public void setIsDead(boolean isDead){
        this.isDead = isDead;
    }

    public boolean isDead(){
        return isDead;
    }

    public void setFrozen(boolean frozen){
        this.frozen = frozen;
    }

    public boolean getFrozen(){
        return this.frozen;
    }



    public abstract void setHealth(int newHealth);


    public abstract void update();
}
