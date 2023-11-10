package org.group16.Model.GameObjects;

//takes care of witdh and height of a player or enemies hit box

public class CollisionBox {
    
    private int width = 0;
    private int height = 0;


    private void setWidth(int width){
        this.width = width;
    }

    private void setHeight(int width){
        this.width = width;
    }

    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }
}
