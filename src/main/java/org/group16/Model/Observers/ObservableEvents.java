package org.group16.Model.Observers;

public interface ObservableEvents {


    void addObserver(GameObserver o);

    void removeObserver(GameObserver o);

    void notifyObserver();
}