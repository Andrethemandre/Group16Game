package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.AffectedByGravity;
import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.IGameObject;
import org.group16.Model.Observers.HasHealth;

class TeleportRushEnemy implements EnemyWithTarget, AffectedByGravity {
    private static final int TELEPORT_DISTANCE = 80;
    private MovableEnemy innerMovableEnemy;
    private EnemyState currentState = EnemyState.IDLE;
    private static final int NEAR_DISTANCE_X = 80; // threshold distance for player to be considered near
    private Direction direction = Direction.NONE;
    private int movementSpeed = 3;

    private int targetX;
    private int targetY;

    private double disappearStartTime = 0; // time when enemy disappears
    private final int disappearDelaySeconds = 3;

    public TeleportRushEnemy(int x, int y,int width, int height) {
        innerMovableEnemy = new MovableEnemy(GameObjectType.TELEPORT__, x, y, width, height, 99);
    }

    @Override
    public boolean isDead() {
        return innerMovableEnemy.isDead();
    }

    @Override
    public void update() {
        switch(currentState) {
            case IDLE -> idle();
            case DISAPPEAR -> disappear();
            case REAPPEAR -> reappear();
            case CHASE -> {
                chase();
                if(isPlayerFar()){
                    teleportBehindPlayer();
                }
            }
            default -> throw new IllegalStateException("Unexpected value: " + currentState);
        }
        applyGravity();
    }

    private void idle() {
        // Idle behavior
        if(isPlayerNear()) {
            currentState = EnemyState.DISAPPEAR;
            disappearStartTime = System.currentTimeMillis()/1000.0;
        }
    }

    private boolean isPlayerNear() {
        // Check if player is near
        int horizontalDistance = Math.abs(targetX - getX());
        int verticalDistance = Math.abs(targetY - getY());

        if (verticalDistance > 70) {
            return false;
        }

        return horizontalDistance <= NEAR_DISTANCE_X;

    }

    private void disappear() {
        // Disappear behavior
        // After disappearing, the enemy will reappear after a certain amount of time
        if (System.currentTimeMillis()/1000.0 - disappearStartTime > disappearDelaySeconds) { // if 7 seconds have passed
            teleportBehindPlayer();
            currentState = EnemyState.REAPPEAR;
        }
    }

    private void teleportBehindPlayer() {
        // Teleport behind player
        int newX = targetX - TELEPORT_DISTANCE;
        setX(newX);
        int newY = targetY;
        setY(newY);
    }

    private void reappear() {
        // Reappear behavior
        // After reappearing, the enemy will chase the player
        double currentTime = System.currentTimeMillis()/1000.0;
        if (currentTime - disappearStartTime > disappearDelaySeconds) {
            currentState = EnemyState.CHASE;
        }
    }

    private void chase() {
        // Chase behavior
        // Move the enemy towards the players position
        if (targetX > getX()) {
            direction = Direction.RIGHT; 
        } else if (targetX < getX()) {
            direction = Direction.LEFT;
        }
        move();



    }

    private boolean isPlayerFar() {
        //int horizontalDistance = Math.abs(targetX - getX());
        int verticalDistance = Math.abs(targetY - getY());

        int tooFarDistanceY = 120;

        return verticalDistance > tooFarDistanceY;
    }

    @Override
    public void move() {
        switch (direction) {
            case LEFT:
                setX(getX() - getMovementSpeed());
                break;
            case RIGHT:
                setX(getX() + getMovementSpeed());
                break;
            default:
                break;
        }
    }

    private void applyGravity() {
        // Apply gravity
        setY(getY() + AffectedByGravity.GRAVITY_LIMIT);
    }

    @Override
    public void checkCollision(IGameObject otherGameObject) {
        switch (otherGameObject.getType()) {
            case STATIONARY:
            case MOVABLE___:
            case SPIKE_____:
                if (collidesWith(otherGameObject)) {
                    setY(getY() - AffectedByGravity.GRAVITY_LIMIT);
                }
                break; 
            default:
                break;
            }
    }
    
    @Override
    public void updateHealth(int damage) {
        innerMovableEnemy.updateHealth(damage);
    }

    @Override
    public void toggleDirection() {
        switch (direction) {
            case LEFT:
                direction = Direction.RIGHT;
                break;
            case RIGHT:
                direction = Direction.LEFT;
                break;
            default:
                break;
        }
    }

    @Override
    public void dealDamage(HasHealth otherGameObject) {
        switch (currentState) {
            case CHASE:
                innerMovableEnemy.dealDamage(otherGameObject);
                break;
            default:
                break;
        }
    }
        
    @Override
    public int getWidth() {
        return innerMovableEnemy.getWidth();
    }

    @Override
    public int getHeight() {
        return innerMovableEnemy.getHeight();
    }

    @Override
    public GameObjectType getType() {
        return innerMovableEnemy.getType();
    }

    @Override
    public int getX() {
        return innerMovableEnemy.getX();
    }

    void setX(int x) {
        innerMovableEnemy.setX(x);
    }

    @Override
    public int getY() {
        return innerMovableEnemy.getY();
    }

    void setY(int y) {
        innerMovableEnemy.setY(y);
    }

    @Override
    public boolean collidesWith(IGameObject otherGameObject) {
        return innerMovableEnemy.collidesWith(otherGameObject);
    }

    @Override
    public int getHealth() {
        return innerMovableEnemy.getHealth();
    }

    @Override
    public void freeze() {
        innerMovableEnemy.freeze();
    }

    @Override
    public boolean isFrozen() {
        return innerMovableEnemy.isFrozen();
    }

    @Override
    public int getMovementSpeed() {
        return movementSpeed;
    }

    @Override
    public void triggerPowerUp(GameObjectType powerUp) {
        switch (powerUp) {
            case SPEAR_____:
                updateHealth(1);
                break;
            default:
                break;
        }
    }

    @Override
    public void setTargetCoordinates(int x, int y) {
        this.targetX = x;
        this.targetY = y;
    }

    @Override
    public EnemyState getCurrentState() {
        return currentState;
    }

    @Override
    public Direction getDirection() {
        return direction;
    }
}




