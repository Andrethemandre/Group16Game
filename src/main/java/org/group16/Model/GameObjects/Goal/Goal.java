package org.group16.Model.GameObjects.Goal;

import org.group16.Model.GameObjects.IGameObject;

import org.group16.Model.GameObjects.GameObject;
import org.group16.Model.GameObjects.GameObjectType;

class Goal implements IGoal {
    private GameObject innerGameObject;

    public Goal(int x, int y) {
        innerGameObject = new GameObject(GameObjectType.GOAL______, x, y, 16, 16);
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

    @Override
    public int getX() {
        return innerGameObject.getX();
    }

    @Override
    public int getY() {
        return innerGameObject.getY();
    }

    @Override
    public boolean collidesWith(IGameObject otherGameObject) {
        return innerGameObject.collidesWith(otherGameObject);
    }

    @Override
    public void update() {
        // Goal doesn't need to update right now
    }
}
