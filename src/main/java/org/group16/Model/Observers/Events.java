package org.group16.Model.Observers;

public interface Events {
    public void addObserver(Observers o);

    public void removeobserver(Observers o);

    public void notifyObserver();

}