package org.group16.Model.Observers;

public interface Events {
    public void addObserver(GameObserver o);

    public void removeobserver(GameObserver o);

    public void notifyObserver();

}