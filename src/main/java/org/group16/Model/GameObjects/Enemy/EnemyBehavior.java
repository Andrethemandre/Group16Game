package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.Player.Player;
import org.group16.Model.Level.LevelHandler;

class EnemyBehavior <T extends MovableEnemy> {
    private static final int STATE_IDLE = 0;
    private static final int STATE_DISAPPEAR = 1;
    private static final int STATE_REAPPEAR = 2;
    private static final int STATE_CHASE = 3;

    private static final int NEAR_DISTANCE_X = 100; // threshold distance for player to be considered near

    private int targetX;
    private int targetY;

    private int currentState;
    private T enemy; // generic type can be any type of enemy
    private Player player;

    public EnemyBehavior(T enemy) {
        this.enemy = enemy;
        currentState = STATE_IDLE;
    }

//    public int getPlayerX() {
//        return levelHandler.getPlayer().getX();
//    }
//
//    // if needed
//    public int getPlayerY() {
//        return levelHandler.getPlayer().getY();
//    }

    public boolean isPlayerNear() {
       // Check if player is near

       int enemyX = enemy.getX();
       // int enemyY = enemy.getY();

       int distanceX = Math.abs(targetX - enemyX);

       return distanceX < NEAR_DISTANCE_X;
    }

    public void teleportBehindPlayer() {
        // Teleport behind player

    }

    public void printInfo(){
        System.out.println("Enemy X: " + enemy.getX());
        System.out.println("Enemy Y: " + enemy.getY());
//        System.out.println("Player X: " + getPlayerX());
//        System.out.println("Player Y: " + getPlayerY());
//        System.out.println("Distance X: " + Math.abs(getPlayerX() - enemy.getX()));
//        System.out.println("Distance Y: " + Math.abs(getPlayerY() - enemy.getY()));
        System.out.println("Enemy state: " + currentState);
        //System.out.println("Player position: (" + getPlayerX() + ", " + getPlayerY() + ")");
        System.out.println("Is player near: " + (isPlayerNear() ? "Yes" : "No"));

    }

    public void idle() {
        // Idle behavior
        if(isPlayerNear()) {
            currentState = STATE_DISAPPEAR;
        }
    }

    public void disappear() {
        // Disappear behavior
        // After disappearing, the enemy will reappear after a certain amount of time

            //enemy.toggleVisibility();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            currentState = STATE_REAPPEAR;

    }

    public void reappear() {
        // Reappear behavior
        // After reappearing, the enemy will chase the player
       //enemy.toggleVisibility();
        teleportBehindPlayer();
        currentState = STATE_CHASE;
    }

    public void chase() {
        // Chase behavior
        // Move the enemy towards the players position
//        if(player.getX() > enemy.getX()) {
//            enemy.setX(enemy.getX() + 1);
//        } else if(player.getX() < enemy.getX()){
//            enemy.setX(enemy.getX() - 1);
//        }
    }

    public void setTargetCoordinates(int x, int y) {
        // Set target coordinates for the enemy to move to
        this.targetX = x;
        this.targetY = y;
    }

    public void update() {
        switch(currentState) {
            case STATE_IDLE -> idle();
            case STATE_DISAPPEAR -> disappear();
            case STATE_REAPPEAR -> reappear();
            case STATE_CHASE -> chase();
            default -> throw new IllegalStateException("Unexpected value: " + currentState);
        }
    }

    public int getCurrentState() {
        return currentState;
    }
}
