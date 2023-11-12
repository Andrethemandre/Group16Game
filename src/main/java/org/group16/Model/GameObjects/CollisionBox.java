package org.group16.Model.GameObjects;

//takes care of witdh and height of a player or enemies hit box

public class CollisionBox {
    private int width;
    private int height;

    public CollisionBox(int width, int height) {
        this.width = width;
        this.height = height;
    }

    // It's fine to have them public because collisionBox will be private in
    // the classes that uses it. 
    public void setWidth(int width){
        this.width = width;
    }

    public void setHeight(int width){
        this.width = width;
    }

    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }
}
