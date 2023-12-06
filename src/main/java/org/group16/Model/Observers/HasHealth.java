package org.group16.Model.Observers;

public interface HasHealth extends CanDie {
    public void updateHealth(int damage);

    public int getHealth();
}
