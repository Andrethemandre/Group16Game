package org.group16.Model.GameObjects;

public class GameObject implements IGameObject {
    private SizeHandler size;
    private Positionable coordinates;
    private final GameObjectType type;
    
    public GameObject(GameObjectType type, int x, int y, int width, int height) {
        size = new SizeHandler(width, height);
        coordinates = new Positionable(x, y);
        this.type = type;
    }

    public int getWidth() {
        return size.getWidth();
    }

    public int getHeight() {
        return size.getHeight();
    }

    public int getX() {
        return coordinates.getX();
    }

    public void setX(int x) {
        coordinates.setX(x);
    }

    public int getY() {
        return coordinates.getY();
    }

    public void setY(int y) {
        coordinates.setY(y);
    }

    public GameObjectType getType() {
        return type;
    }
}
