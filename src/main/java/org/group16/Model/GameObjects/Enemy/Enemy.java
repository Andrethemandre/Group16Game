package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.IGameObject;
import org.group16.Model.GameObjects.GameObject;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.Positionable;
import org.group16.Model.GameObjects.Player.Player;
import org.group16.Model.Observers.Health;

public abstract class Enemy extends Positionable implements IGameObject, Health /* implements Health */ {
    private GameObject innerGameObject;
    private int damage;

    Enemy(GameObjectType enemyType, int x, int y) {
        super(x, y);
        innerGameObject = new GameObject(enemyType, 16, 16);
    }

    @Override
    public GameObjectType getType() {
        return innerGameObject.getType();
    }

    public void dealDamage(Player player) {

    }

    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public int getY() {
        return super.getY();
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
