package org.group16.Model.Observers;

import java.util.ArrayList;
import java.util.List;

public class Eventmanager implements ObservableEvents{
    public void updateObserver() {
        System.out.println("Eventmanager: Notified");
    };

    public List<Observers> observers = new ArrayList<Observers>();

    @Override
    public void addObserver(Observers o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observers o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver() {
        for (Observers o : observers) {
            o.updateObserver();
        }
    }

}
