package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.IGameObject;
import org.group16.Model.GameObjects.GameObject;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.Player.Player;
import org.group16.Model.Observers.Health;

public abstract class Enemy implements IGameObject, Health /* implements Health */ {
    private GameObject innerGameObject;
    private int damage;

    Enemy(GameObjectType enemyType, int x, int y) {
        innerGameObject = new GameObject(enemyType, x, y, 16, 16);
    }

    @Override
    public GameObjectType getType() {
        return innerGameObject.getType();
    }

    public void dealDamage(Player player) {

    }
    @Override
    public boolean checkCollision(IGameObject otherGameObject) {
        return innerGameObject.checkCollision(otherGameObject);
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
}
