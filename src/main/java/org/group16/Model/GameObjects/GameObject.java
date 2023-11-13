package org.group16.Model.GameObjects;

public class GameObject {
    private SizeHandler size;
    
    public GameObject(int width, int height) {
        size = new SizeHandler(width, height);
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
}
