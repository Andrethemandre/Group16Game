package org.group16.Model.Observers;

import org.group16.Model.GameObjects.Player.Player;

public class PlayerDamageListener {
    // this method is called when the player is hit by an enemy and loses health and
    // have more than 0 health
    public void updatehealth(Player player) {
        if (player.getHealth() > 0) {
            player.setHealth(player.getHealth() - 1);
        }
    }

    // this method returns a bollean value if the player is dead or not
    public boolean isDead(Player player) {
        return player.getHealth() == 0;

    }
}
