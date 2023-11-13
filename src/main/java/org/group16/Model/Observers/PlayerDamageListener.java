package org.group16.Model.Observers;

import org.group16.Model.GameObjects.Player.Player;

public class PlayerDamageListener implements Health {
    // this method is called when the player is hit by an enemy and loses health and
    // have more than 0 health
    Player player;

    public void setHealth(int damage) {
        if (player.getHealth() > 0) {
            player.setHealth(player.getHealth() - damage);
        }
    }

    public int getHealth() {
        return player.getHealth();
    }

    // this method returns a bollean value if the player is dead or not
    public boolean isDead() {
        return player.getHealth() == 0;

    }
}
