package org.group16.Model.Observers;

import java.util.ArrayList;
import java.util.List;

public class Eventmanager implements Events, Observers {
    public void updateObserver() {
        System.out.println("Eventmanager: Notified");
    };

    public List<Observers> observers = new ArrayList<Observers>();

    public void addObserver(Observers o) {
        observers.add(o);
    }

    public void removeobserver(Observers o) {
        observers.remove(o);
    }

    public void notifyObserver() {
        for (Observers o : observers) {
            o.updateObserver();
        }
    }

}
