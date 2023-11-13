package org.group16.Model.GameObjects.Flag;

import org.group16.Model.GameObjects.SizeHandler;
import org.group16.Model.GameObjects.IGameObject;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.Positionable;

public class Flag extends Positionable implements IGameObject{
    private final GameObjectType type = GameObjectType.GOAL______;
    private SizeHandler size = new SizeHandler(16, 16);

    public Flag(int x, int y) {
        super(x, y);
    }
    
    @Override
    public int getWidth() {
        return size.getWidth();
    }

    @Override
    public int getHeight() {
        return size.getHeight();
    }

    @Override
    public GameObjectType getType() {
        return type;
    }
}
