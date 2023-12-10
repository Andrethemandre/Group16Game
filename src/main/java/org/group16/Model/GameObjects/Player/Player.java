package org.group16.Model.GameObjects.Player;

import org.group16.Model.GameObjects.AffectedByGravity;
import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.GameObject;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.IGameObject;
import org.group16.Model.GameObjects.Blocks.IMovableBlock;
import org.group16.Model.GameObjects.Blocks.TeleportBlock;

class Player implements IPlayer {
    private boolean moveLeft = false;
    private boolean moveRight = false;
    private boolean doJump = false;
    private int movementSpeed = 5;
    private int health = 3;
    private GameObject innerGameObject;
    private int yAcceleration;
    private int xAcceleration;
    private double previousTime = 0;
    private double currentTime = 6;
    private double previousTeleportTime = 0;
    private double currentTeleportTime = 6;
    private final double teleportDelay = 1;
    private GameObjectType currentPowerUp = GameObjectType.NOTHING___;
    private Direction lastDirection = Direction.RIGHT;
    private final int damageDelay = 1;

    private boolean isFalling = false;
    private final int maxX;
    private final int maxY;

    public Player(int x, int y, int maxX, int maxY) {
        innerGameObject = new GameObject(GameObjectType.PLAYER____, x, y, 16, 16);
        this.maxX = maxX;
        this.maxY = maxY;
    }

    private void jump() {
        if (!isFalling()) {
            yAcceleration = -10;
            int newY = getY() + yAcceleration;
            setY(newY);
            isFalling = true;
            doJump = false;
        }
    }

    private void applyGravity() {
        yAcceleration = yAcceleration + AffectedByGravity.GRAVITY_FACTOR;
        if (yAcceleration > AffectedByGravity.GRAVITY_LIMIT) {
            yAcceleration = AffectedByGravity.GRAVITY_LIMIT;
        }

        int newY = getY() + yAcceleration;
        setY(newY);
    }

    private void applyFriction() {
        if (xAcceleration > 1) {
            xAcceleration -= 1;
        } else if (xAcceleration < -1) {
            xAcceleration += 1;
        } else {
            xAcceleration = 0;
        }
    }

    @Override
    public void checkCollision(IGameObject otherGameObject) {
        checkVerticalCollision(otherGameObject);
        checkHorizontalCollision(otherGameObject);
    }

    private void checkHorizontalCollision(IGameObject otherGameObject) {
        if (this.collidesWith(otherGameObject)) {
            setX(getX() - xAcceleration);

            while (!this.collidesWith(otherGameObject)) {
                setX(getX() + Integer.signum(xAcceleration));
            }

            setX(getX() - Integer.signum(xAcceleration));

            xAcceleration = 0;
            // Adjust player's X position based on MovableBlock's movement
        }
    }

    private void checkVerticalCollision(IGameObject otherGameObject) {
        setY(getY() + yAcceleration);

        if (this.collidesWith(otherGameObject)) {
            setY(getY() - yAcceleration);

            while (!this.collidesWith(otherGameObject)) {
                setY(getY() + Integer.signum(yAcceleration));
            }

            setY(getY() - Integer.signum(yAcceleration));

            // Adjust player's Y position based on MovableBlock's movement
            keepPlayerOnMovableBlock(otherGameObject);

            // Should only be able to jump if the player is on the ground
            if (yAcceleration > 0) {
                isFalling = false;
            }

            yAcceleration = 0;
        } else {
            setY(getY() - yAcceleration);
        }
    }

    private void keepPlayerOnMovableBlock(IGameObject otherGameObject) {
        if (otherGameObject instanceof IMovableBlock) {
            IMovableBlock movableBlock = (IMovableBlock) otherGameObject;

            // Player is getting pushed from the side or is on top of the block
            Direction blockHorizontalDirection = movableBlock.getDirection();
            Direction blockVerticalDirection = movableBlock.getVerticalDirection();

            switch (blockHorizontalDirection) {
                case LEFT:
                    setX(getX() - movableBlock.getMovementSpeed());
                    break;
                case RIGHT:
                    setX(getX() + movableBlock.getMovementSpeed());
                    break;
                default:
                    break;
            }

            switch (blockVerticalDirection) {
                case UP:
                    setY(getY() - movableBlock.getMovementSpeed());
                    isFalling = false;
                    yAcceleration = 0;
                    break;
                case DOWN:
                    setY(getY() + movableBlock.getMovementSpeed());
                    isFalling = false;
                    yAcceleration = 0;
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void move() {
        if (moveLeft) {
            if (xAcceleration >= 0) {
                xAcceleration -= movementSpeed;
            } else {
                xAcceleration = -movementSpeed;
            }
        }
        if (moveRight) {
            if (xAcceleration <= 0) {
                xAcceleration += movementSpeed;
            } else {
                xAcceleration = movementSpeed;
            }
        }

        int newX = getX() + xAcceleration;
        setX(newX);
    }

    @Override
    public void startJumping() {
        doJump = true;
    }

    @Override
    public void update() {
        move();
        updateDirection();
        applyGravity();
        applyFriction();
        if (doJump) {
            jump();
        }
    }

    private void updateDirection() {
        if (moveLeft && !moveRight) {
            lastDirection = Direction.LEFT;
        } else if (moveRight && !moveLeft) {
            lastDirection = Direction.RIGHT;
        }
    }

    @Override
    public boolean isFalling() {
        return isFalling;

    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void startMovingInDirection(Direction direction) {
        switch (direction) {
            case LEFT:
                moveLeft = true;
                break;
            case RIGHT:
                moveRight = true;
                break;
            case NONE:
                moveRight = false;
                moveLeft = false;
                break;
            default:
                break;
        }
    }

    @Override
    public void stopMovingInDirection(Direction direction) {
        switch (direction) {
            case LEFT:
                moveLeft = false;
                break;
            case RIGHT:
                moveRight = false;
                break;
            default:
                break;
        }
    }

    @Override
    public int getWidth() {
        return innerGameObject.getWidth();
    }

    @Override
    public int getHeight() {
        return innerGameObject.getHeight();
    }

    @Override
    public GameObjectType getType() {
        return innerGameObject.getType();
    }

    @Override
    public boolean isDead() {
        return health == 0;
    }

    @Override
    public void updateHealth(int damage) {
        currentTime = System.currentTimeMillis() / 1000.0;

        if (health > 0 && currentTime - previousTime > damageDelay) {
            health -= damage;
            previousTime = currentTime;
        }
    }

    @Override
    public boolean collidesWith(IGameObject otherGameObject) {
        return innerGameObject.collidesWith(otherGameObject);
    }

    @Override
    public int getX() {
        return innerGameObject.getX();
    }

    private void setX(int x) {
        x = keepXInBox(x);

        innerGameObject.setX(x);
    }

    private int keepXInBox(int x) {
        if (x < 0) {
            x = 0;
        } else if (x > maxX - getWidth()) {
            x = maxX - getWidth();
        }
        return x;
    }

    @Override
    public int getY() {
        return innerGameObject.getY();
    }

    private void setY(int y) {
        if (y < 0) {
            y = 0;
            // when player falls of, player is dead.
        } else if (y > maxY + getHeight()) {
            health = 0;
        }
        innerGameObject.setY(y);

    }

    @Override
    public void setCurrentPowerUp(GameObjectType hasPowerUp) {
        this.currentPowerUp = hasPowerUp;
    }

    @Override
    public GameObjectType getCurrentPowerUp() {
        return currentPowerUp;
    }

    @Override
    public Direction getDirection() {
        return lastDirection;
    }

    @Override
    public void teleport(TeleportBlock teleportBlock) {
        currentTeleportTime = System.currentTimeMillis() / 1000.0;
        if (currentTeleportTime - previousTeleportTime > teleportDelay) {
            previousTeleportTime = currentTeleportTime;

            setX(teleportBlock.getX());
            setY(teleportBlock.getY() - 16);
        }

    }

    @Override
    public int getMovementSpeed() {
        return movementSpeed;
    }
}