package org.group16.Model.Observers;

public interface ObservableEvents {
    private void addObservers(){}
    private void removeObservers(){}
    private void notifyObservers(){}

    void addObserver(GameObserver o);

    void removeObserver(GameObserver o);

    void notifyObserver();
}