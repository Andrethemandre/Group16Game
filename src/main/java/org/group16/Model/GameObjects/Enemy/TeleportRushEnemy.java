package org.group16.Model.GameObjects.Enemy;

import org.group16.Model.GameObjects.AffectedByGravity;
import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.HasHealth;
import org.group16.Model.GameObjects.IGameObject;

class TeleportRushEnemy implements EnemyWithTarget, AffectedByGravity {
    private static final int TELEPORT_DISTANCE = 80;
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
    private final int delaySeconds = 4;

    private long damageStartTime = 0;
    private final int damageDelaySeconds = 1;

    private boolean hasDelayBeenDone = false;


    public TeleportRushEnemy(int x, int y, int width, int height) {
        innerMovableEnemy = new MovableEnemy(GameObjectType.TELEPORT__, x, y, width, height, 100, 1);
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
            case DAMAGED -> enemyWasDamaged();
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
        int newY = targetY - 16;

        if (calculateTargetDirection() < 0) {
            newX = targetX + TELEPORT_DISTANCE;
        } else if (calculateTargetDirection() > 0) {
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
        System.out.println("a");
    }

    private void takeDamage() {
        // Take damage behavior
        damageStartTime = System.currentTimeMillis()/1000;
        currentState = EnemyState.DAMAGED;
        updateHealth(50);
        System.out.println("Enemy took damage");
    }

    private void enemyWasDamaged(){
        long currentTime = System.currentTimeMillis()/1000;
        if (currentTime - damageStartTime >= damageDelaySeconds) {
            currentState = EnemyState.CHASE;
            System.out.println("b");
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

    private int calculateTargetDirection() {
        int dx = targetX - previousTargetX;
        return dx;
    }

    private boolean isTargetMovingSlow() {
        return calculateTargetSpeed() <= SPEED_THRESHOLD;
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
        setY(getY() + AffectedByGravity.GRAVITY_FACTOR);
    }

    @Override
    public void checkCollision(IGameObject otherGameObject) {
        switch (otherGameObject.getType()) {
            case STATIONARY:
            case MOVABLE___:
            case SPIKE_____:
                if (collidesWith(otherGameObject)) {
                    setY(getY() - AffectedByGravity.GRAVITY_FACTOR);
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
                takeDamage();
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




