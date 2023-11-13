package org.group16.Model.GameObjects;

public class GameObject implements IGameObject {
    private SizeHandler size;
    private final GameObjectType type;
    
    public GameObject(GameObjectType type, int width, int height) {
        size = new SizeHandler(width, height);
        this.type = type;
    }

    public int getWidth() {
        return size.getWidth();
    }

    public int getHeight() {
        return size.getHeight();
    }

    public int getX() {
        // TODO
        return 0;
    }

    public int getY() {
        // TODO
        return 0;
    }

    public GameObjectType getType() {
        return type;
    }
}
