package org.group16.Model.Observers;

import org.group16.Model.GameObjects.Enemy.Enemy;

public class EnemyDamageListener implements Health {
    // suposed to daamage the enemy but need specific enemy to do so both it´s type
    // and health. also need to add get/set health methods to the enemy class(es?)
    Enemy enemy;

    public void setHealth(int damage) {
//        if (enemy.getHealth() > 0) {
//            enemy.setHealth(enemy.getHealth() - damage);
//        }
    }

    @Override
    public void updateHealth(int damage) {

    }

    public int getHealth() {
        return enemy.getHealth();
    }

    public Boolean isDead() {
        return enemy.getHealth() == 0;
    }
}
