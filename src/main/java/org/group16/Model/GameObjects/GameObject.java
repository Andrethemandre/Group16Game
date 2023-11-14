package org.group16.Model.GameObjects;

import java.awt.Rectangle;

public class GameObject implements IGameObject {
    private SizeHandler size;
    private Positionable coordinates;
    private final GameObjectType type;
    private Rectangle hitbox;
    
    public GameObject(GameObjectType type, int x, int y, int width, int height) {
        size = new SizeHandler(width, height);
        coordinates = new Positionable(x, y);
        this.type = type;
        hitbox = new Rectangle(x,y,width,height);
    }

    public Rectangle getHitBox(){
        return hitbox;

    }

    public void updateHitBox(){
        hitbox.x = (int) this.getX();
        hitbox.y = (int) this.getY();
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

    @Override
    public boolean checkCollision(IGameObject otherGameObject) {
        int gameObjectWidth = this.getWidth();
        int gameObjectHeight = this.getHeight();
        int gameObjectX = this.getX();
        int gameObjectY = this.getY();

        int otherGameObjectWidth = otherGameObject.getWidth();
        int otherGameObjectHeight = otherGameObject.getHeight();
        int otherGameObjectX = otherGameObject.getX();
        int otherGameObjectY = otherGameObject.getY();

        //  overflow || intersect
        return gameObjectX < otherGameObjectX + otherGameObjectWidth && gameObjectX + gameObjectWidth > otherGameObjectX && gameObjectY < otherGameObjectY + otherGameObjectHeight && gameObjectY + gameObjectHeight > otherGameObjectY;
    }
}
