package org.group16.Model.Observers;

import java.util.ArrayList;
import java.util.List;

class Eventmanager implements ObservableEvents{
    public void updateObserver() {
        System.out.println("Eventmanager: Notified");
    };

    public List<GameObserver> observers = new ArrayList<GameObserver>();

    @Override
    public void addObserver(GameObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(GameObserver o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver() {
        for (GameObserver o : observers) {
            o.updateObserver();
        }
    }

}
