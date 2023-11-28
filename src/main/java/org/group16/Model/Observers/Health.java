package org.group16.Model.Observers;

public interface Health extends CanDie {
    public void updateHealth(int damage);

    public int getHealth();
}
