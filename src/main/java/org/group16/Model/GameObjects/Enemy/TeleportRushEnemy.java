package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.AffectedByGravity;
import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.HasHealth;
import org.group16.Model.GameObjects.IGameObject;

class TeleportRushEnemy implements EnemyWithTarget, AffectedByGravity {
    private static final int TELEPORT_DISTANCE = 50;
    private MovableEnemy innerMovableEnemy;
    private EnemyState currentState = EnemyState.IDLE;
    private static final int NEAR_DISTANCE_X = 80;
    private Direction direction = Direction.NONE;
    private int movementSpeed = 3;

    private static final double SPEED_THRESHOLD = 4;

    private int targetX;
    private int targetY;

    private int previousTargetX;
    private int previousTargetY;

    private double disappearStartTime = 0;
    private final int disappearDelaySeconds = 4;

    private double delayStartTime = 0;
    private final int delaySeconds = 2;

    public TeleportRushEnemy(int x, int y, int width, int height) {
        innerMovableEnemy = new MovableEnemy(GameObjectType.TELEPORT__, x, y, width, height, 99, 1);
    }

    @Override
    public boolean isDead() {
        return innerMovableEnemy.isDead();
    }

    @Override
    public void update() {
        switch (currentState) {
            case IDLE -> idle();
            case DISAPPEAR -> disappear();
            case REAPPEAR -> reappear();
            case CHASE -> chase();
            default -> throw new IllegalStateException("Unexpected value: " + currentState);
        }
        applyGravity();
    }

    private boolean isDelayOver() {
        double currentTime = System.currentTimeMillis() / 1000.0;
        return currentTime - delayStartTime > delaySeconds;
    }

    private void idle() {
        // Idle behavior
        if (isTargetNear()) {
            currentState = EnemyState.DISAPPEAR;
            disappearStartTime = System.currentTimeMillis() / 1000.0;
        }
    }

    private boolean isTargetNear() {
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
        if (System.currentTimeMillis() / 1000.0 - disappearStartTime > disappearDelaySeconds) {
            teleportNearTarget();
            currentState = EnemyState.REAPPEAR;
        }
    }

    private void teleportNearTarget() {
        // Teleport behind player
        int newX;
        int newY = targetY;

        if (isTargetFar() && !isTargetMovingSlow()) {
            newX = targetX + TELEPORT_DISTANCE;
        } else if (isTargetMovingSlow()) {
            newX = targetX - TELEPORT_DISTANCE;
        } else {
            newX = targetX - TELEPORT_DISTANCE;
        }
        setX(newX);
        setY(newY);
    }

    private void reappear() {
        // Reappear behavior
        // After reappearing, the enemy will chase the player
        double currentTime = System.currentTimeMillis() / 1000.0;
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

        if (isTargetFar()) {
            if (delayStartTime == 0) {
                delayStartTime = System.currentTimeMillis() / 1000.0;
            } else if (isDelayOver()) {
                teleportNearTarget();
                applyGravity();
                delayStartTime = 0;
            }
        }
    }

    private boolean isTargetFar() {

        int verticalDistance = Math.abs(targetY - getY());
        int tooFarDistanceY = 80;
        return verticalDistance > tooFarDistanceY;
    }

    private double calculateTargetSpeed() {
        int dx = targetX - previousTargetX;
        int dy = targetY - previousTargetY;
        return Math.sqrt(dx * dx + dy * dy);
    }
    private boolean isTargetMovingSlow() {
        return calculateTargetSpeed() <= SPEED_THRESHOLD;
    }


    private boolean isTargetMovingOpposite() {
        System.out.println("is working");
        return (targetX < previousTargetX && direction == Direction.RIGHT) ||
                (targetX > previousTargetX && direction == Direction.LEFT);
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
        this.previousTargetX = this.targetX;
        this.previousTargetY = this.targetY;
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




