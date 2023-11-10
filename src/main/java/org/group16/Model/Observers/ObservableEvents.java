package org.group16.Model.Observers;

public interface ObservableEvents {
    private void addObservers(){}
    private void removeObservers(){}
    private void notifyObservers(){}

    void addObserver(Observers o);

    void removeObserver(Observers o);

    void notifyObserver();
}