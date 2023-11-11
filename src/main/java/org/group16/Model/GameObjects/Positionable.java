package org.group16.Model.GameObjects;

public abstract class Positionable implements IPositionable {

    private int x;
    private int y;

    protected void setX(int x){
        this.x = x;
    }

    protected void setY(int y){
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

}
