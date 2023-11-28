package org.group16.Model.GameObjects.Player;

import org.group16.Model.GameObjects.*;
import org.group16.Model.GameObjects.Blocks.MovableBlock;
import org.group16.Model.Observers.Health;

public class Player implements Movable, IGameObject, Health, AffectedByGravity {
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
    private GameObjectType hasPowerUp = GameObjectType.NOTHING___;
    private Direction lastDirection = Direction.RIGHT;

    private boolean falling = false;
    private int maxX;
    private int maxY;

    public Player(int x, int y, int maxX, int maxY) {
        innerGameObject = new GameObject(GameObjectType.PLAYER____, x, y, 16, 16);
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public void jump() {
        if (!isFalling()) {
            yAcceleration = -10;
            int newY = getY() + yAcceleration;
            setY(newY);
            falling = true;
            doJump = false;
        }
    }

    public void applyGravity() {
        yAcceleration = yAcceleration + AffectedByGravity.GRAVITY_FACTOR;
        if (yAcceleration > AffectedByGravity.GRAVITY_LIMIT) {
            yAcceleration = AffectedByGravity.GRAVITY_LIMIT;
        }

        int newY = getY() + yAcceleration;
        setY(newY);
    }

    public void applyFriction() {
        if (xAcceleration > 1) {
            xAcceleration -= 1;
        } else if (xAcceleration < -1) {
            xAcceleration += 1;
        } else {
            xAcceleration = 0;
        }
    }

    public int getXAcceleration() {
        return xAcceleration;
    }

    public int getYAcceleration() {
        return yAcceleration;
    }

    public void collision(IGameObject otherGameObject) {
        setY(getY() + yAcceleration);

        if (this.collidesWith(otherGameObject)) {
            setY(getY() - yAcceleration);

            while (!this.collidesWith(otherGameObject)) {
                setY(getY() + Integer.signum(yAcceleration));
            }

            setY(getY() - Integer.signum(yAcceleration));

            // Adjust player's Y position based on MovableBlock's movement
            if (otherGameObject instanceof MovableBlock) {
                MovableBlock movableBlock = (MovableBlock) otherGameObject;

                // Player is getting pushed from the side or is on top of the block
                int blockHorizontalDirection = movableBlock.isitgoingposornegh();
                int blockVerticalDirection = movableBlock.isitgoingposornegv();

                if (blockHorizontalDirection != 0) {
                    // Adjust X position based on the block's horizontal movement
                    setX(getX() + blockHorizontalDirection);
                }

                if (blockVerticalDirection != 0) {
                    // Adjust Y position based on the block's vertical movement
                    setY(getY() + blockVerticalDirection);
                    falling = false;
                    yAcceleration = 0;
                } else if (isOnTopOf(movableBlock) && yAcceleration > 0) {
                    // Adjust Y position if on top of the MovableBlock and is falling
                    setY(movableBlock.getY() + movableBlock.getHeight());
                    falling = false;
                    yAcceleration = 0;
                }
            }

            // Should only be able to jump if the player is on the ground
            if (yAcceleration > 0) {
                falling = false;
            }

            yAcceleration = 0;
        } else {
            setY(getY() - yAcceleration);
        }

        setX(keepXInBox(getX())); // Make sure to keep X in bounds

        if (this.collidesWith(otherGameObject)) {
            setX(getX() - xAcceleration);

            while (!this.collidesWith(otherGameObject)) {
                setX(getX() + Integer.signum(xAcceleration));
            }

            setX(getX() - Integer.signum(xAcceleration));

            xAcceleration = 0;
            // Adjust player's X position based on MovableBlock's movement
            if (otherGameObject instanceof MovableBlock && isOnTopOf((MovableBlock) otherGameObject)) {
                MovableBlock movableBlock = (MovableBlock) otherGameObject;
                setX(getX() + movableBlock.isitgoingposornegh());
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

    public void startJumping() {
        doJump = true;
    }

    // need to check if player is in the air to fall, so
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

    public boolean isFalling() {
        return this.falling;

    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

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

    public int getMovementSpeed() {
        return movementSpeed;
    }

    private void setMovementSpeed(int movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    @Override
    public int getWidth() {
        return innerGameObject.getWidth();
    }

    @Override
    public int getHeight() {
        return innerGameObject.getHeight();
    }

    public GameObjectType getType() {
        return innerGameObject.getType();
    }

    public boolean isDead() {
        return health == 0;
    }

    @Override
    public void updateHealth(int damage) {
        currentTime = System.currentTimeMillis() / 1000.0;

        if (health > 0 && currentTime - previousTime > 2) {
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

    public void setHasPowerUp(GameObjectType hasPowerUp) {
        this.hasPowerUp = hasPowerUp;
    }

    public GameObjectType getHasPowerUp() {
        return hasPowerUp;
    }

    public Direction getDirection() {
        return lastDirection;
    }

    private boolean isOnTopOf(MovableBlock movableBlock) {
        int playerBottom = getY();
        int blockTop = movableBlock.getY() + movableBlock.getHeight();
        return playerBottom == blockTop;
    }
}