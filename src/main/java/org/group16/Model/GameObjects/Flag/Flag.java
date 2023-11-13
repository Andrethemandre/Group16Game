package org.group16.Model.GameObjects.Flag;

import org.group16.Model.GameObjects.CollisionBox;
import org.group16.Model.GameObjects.IGameObject;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.Positionable;

public class Flag extends Positionable implements IGameObject{
    private final GameObjectType type = GameObjectType.GOAL______;
    private CollisionBox collisionBox = new CollisionBox(16, 16);

    public Flag(int x, int y) {
        super(x, y);
    }
    
    @Override
    public int getWidth() {
        return collisionBox.getWidth();
    }

    @Override
    public int getHeight() {
        return collisionBox.getHeight();
    }

    @Override
    public GameObjectType getType() {
        return type;
    }
}
