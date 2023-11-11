package org.group16.Model.Observers;

import org.group16.Model.GameObjects.Enemy.Enemy;

public class EnemyDamageListener {
    // suposed to daamage the enemy but need specific enemy to do so both it´s type
    // and health. also need to add get/set health methods to the enemy class(es?)
    Enemy enemy;

    public void updatehealth() {
        if (enemy.getHealth() > 0) {
            enemy.setHealth(enemy.getHealth() - 1);
        }
    }

    public Boolean isDead() {
        return enemy.getHealth() == 0;
    }
}
