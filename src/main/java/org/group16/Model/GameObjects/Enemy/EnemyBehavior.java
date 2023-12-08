package org.group16.Model.GameObjects.Enemy;


class EnemyBehavior <T extends MovableEnemy>  {
    private EnemyState currentState;
    private static final int NEAR_DISTANCE_X = 80; // threshold distance for player to be considered near

    private int targetX;
    private int targetY;



    private final T enemy; // generic type can be any type of enemy



    private double disappearStartTime = 0; // time when enemy disappears
    private final int disappearDelaySeconds = 5;

    public EnemyBehavior(T enemy) {
        this.enemy = enemy;
        currentState = EnemyState.IDLE;
    }



    public boolean isPlayerNear() {
        // Check if player is near
        int enemyX = enemy.getX();
        int distanceX = Math.abs(targetX - enemyX);



        return distanceX <= NEAR_DISTANCE_X;

    }

    public void teleportBehindPlayer() {
        // Teleport behind player
        int playerX = targetX;
        int enemyX = playerX - 50;
        enemy.setX(enemyX);

    }






    public void idle() {
        // Idle behavior
        if(isPlayerNear()) {
            currentState = EnemyState.DISAPPEAR;
            disappearStartTime = System.currentTimeMillis()/1000.0;
        }
    }

    public void disappear() {
        // Disappear behavior
        // After disappearing, the enemy will reappear after a certain amount of time
        if (System.currentTimeMillis()/1000.0 - disappearStartTime > disappearDelaySeconds) { // if 7 seconds have passed
            currentState = EnemyState.REAPPEAR;
        }
    }



    public void reappear() {
        // Reappear behavior
        // After reappearing, the enemy will chase the player
        double currentTime = System.currentTimeMillis()/1000.0;
        if(currentTime - disappearStartTime > disappearDelaySeconds){
            teleportBehindPlayer();
            currentState = EnemyState.CHASE;
        }

    }

    public void chase() {
        // Chase behavior
        // Move the enemy towards the players position
        if (targetX > enemy.getX()) {
            enemy.setX(enemy.getX() + 2);
        } else if(targetX < enemy.getX()){
            enemy.setX(enemy.getX() - 2);
       }
    }



    public void setTargetCoordinates(int x, int y) {
        // Set target coordinates for the enemy to move to
        this.targetX = x;
        this.targetY = y;
    }

    public void update() {
        switch(currentState) {
            case IDLE -> idle();
            case DISAPPEAR -> disappear();
            case REAPPEAR -> reappear();
            case CHASE -> chase();
            default -> throw new IllegalStateException("Unexpected value: " + currentState);
        }
    }

    public EnemyState getCurrentState() {
        return currentState;
    }

}
