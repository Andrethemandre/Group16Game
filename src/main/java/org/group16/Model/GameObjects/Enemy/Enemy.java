package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.Player.Player;
import org.group16.Model.Observers.Health;

public abstract class Enemy implements Health /* implements Level */ {
    private int damage;

    public void dealDamage(Player player) {

    }
}
