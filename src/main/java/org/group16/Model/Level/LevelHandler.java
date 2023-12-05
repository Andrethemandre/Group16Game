package org.group16.Model.Level;

import static org.group16.Model.GameObjects.GameObjectType.SPEAR_____;
import static org.group16.Model.GameObjects.GameObjectType.FREEZE____;
import static org.group16.Model.GameObjects.GameObjectType.STATIONARY;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;

import org.group16.Model.GameObjects.Enemy.FlyingEnemy;
import org.group16.Model.GameObjects.IGameObject;
import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.GameState;
import org.group16.Model.GameObjects.Blocks.Block;
import org.group16.Model.GameObjects.Blocks.BlockFactory;
import org.group16.Model.GameObjects.Blocks.MovableBlock;
import org.group16.Model.GameObjects.Enemy.Enemy;
import org.group16.Model.GameObjects.Enemy.EnemyFactory;
import org.group16.Model.GameObjects.Flag.Flag;
import org.group16.Model.GameObjects.Player.Player;
import org.group16.Model.GameObjects.PowerUp.FreezePowerUp;
import org.group16.Model.GameObjects.PowerUp.PowerUp;
import org.group16.Model.GameObjects.PowerUp.PowerUpFactory;
import org.group16.Model.GameObjects.PowerUp.SpearPowerUp;
import org.group16.Model.Observers.GameObserver;

public class LevelHandler {
    private List<MovableBlock> movableBlocks; // Add this member variable

    private Player player;
    private Flag goalFlag;
    private Collection<Enemy> enemies;
    private Collection<Block> blocks;
    // private MovableBlock movableBlock;
    private Collection<PowerUp> powerUps;
    private boolean playerIsAtFlag;
    private IGameObject[][] grid;
    private Collection<GameObjectType> acceptedEnemyTypes = Arrays
            .asList(new GameObjectType[] { GameObjectType.BASIC_____, GameObjectType.SPIKE_____,
                    GameObjectType.FLYING____, GameObjectType.TELEPORT__ });
    private Collection<GameObjectType> acceptedBlockTypes = Arrays
            .asList(new GameObjectType[] { GameObjectType.STATIONARY, GameObjectType.MOVABLE___ });
    private Collection<GameObjectType> acceptedPowerUpTypes = Arrays
            .asList(new GameObjectType[] { GameObjectType.SPEAR_____, GameObjectType.FREEZE____ });
    private Collection<GameObserver> observers;
    private int currentLevelNumber;
    private int score = 0;
    private Level currentLevel;
    private long levelStartTime;
    private int levelAttempts = 0;
    private static int SCORE_LIMIT = 9999;
    private GameState gameState;

    FirstLevel firstLevel = new FirstLevel();
    SecondLevel secondLevel = new SecondLevel();
    SixthLevel sixthLevel = new SixthLevel();
    // width and height depending on how big the level is

    private long pauseStartTime = 0;
    private long totalPauseTime = 0;

    public LevelHandler() {
        movableBlocks = new ArrayList<>();
        observers = new ArrayList<>();
        gameState = GameState.START;

        // setLevel(1);
        // setxandydirectionofmovableblocks(firstLevel.getMovableBlocks());

        // Schedule the movable blocks movement at fixed intervals
    }

    public GameState getGameState() {
        return gameState;
    }

    private void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getCurrentLevelNumber() {
        return this.currentLevelNumber;
    }

    private void addScore(int points) {
        this.score += points;
    }

    private void calculateScore() {
        // int baseScore = 9999;
        int pointsPerSecond = 100; // Number of points per second

        // Calculate the number of seconds that have passed
        int secondsPassed = (int) ((System.currentTimeMillis() - levelStartTime - totalPauseTime) / 1000);

        // Add points for each second that has passed
        int timeBonus = secondsPassed * pointsPerSecond;

        // Some points deducted for each attempt
        int attemptsPenalty = levelAttempts * 500;

        int totalScore = SCORE_LIMIT - timeBonus - attemptsPenalty;
        addScore(totalScore - score);

        if (score < -SCORE_LIMIT) {
            score = -SCORE_LIMIT;
        } else if (score > SCORE_LIMIT) {
            score = SCORE_LIMIT;
        }
    }

    public int getScore() {
        calculateScore();
        return this.score;
    }

    public int getCurrentAttempts() {
        return this.levelAttempts;
    }

    // collision checkers
    private void checkIfPlayerAtFlag() {
        if (player.collidesWith(goalFlag)) {
            setLevel(2);
        }
    }

    private void checkIfPlayerCollidesWithBlocks() {
        for (Block block : blocks) {
            player.collision(block);
        }
    }

    private void checkIfPlayerCollidesWithEnemies() {
        for (Enemy enemy : enemies) {
            if (player.collidesWith(enemy)) {
                enemy.dealDamage(player);
            }
        }
    }

    private void checkIfFlyingEnemyCollidesWithBlocks() {
        for (Enemy enemy : enemies) {
            if (enemy.getType() == GameObjectType.FLYING____) {
                for (Block block : blocks) {
                    if (enemy.collidesWith(block)) {
                        ((FlyingEnemy) enemy).toggleDirection();
                    }
                }
            }
        }
    }

    private void checkIfPlayerCollidesWithPowerUp() {
        PowerUp powerUpToRemove = null;
        if (powerUps != null) {
            if (player.getHasPowerUp() == GameObjectType.NOTHING___) {
                for (PowerUp powerUp : powerUps) {
                    if (player.collidesWith(powerUp)) {
                        if (!powerUp.getMovable()) {
                            powerUpToRemove = powerUp;
                            player.setHasPowerUp(powerUp.getType());

                        }
                    }
                }
                powerUps.remove(powerUpToRemove);

            }
        }
    }

    private void checkIfPowerUpsCollidesWithEnemies() {
        for (PowerUp powerUp : powerUps) {
            for (Enemy enemy : enemies) {
                if (powerUp.collidesWith(enemy)) {
                    powerUp.triggerPowerUp(enemy);
                }
            }
        }
    }

    private void checkIfPowerUpsCollidesWithBlocks() {
        for (PowerUp powerUp : powerUps) {
            for (Block block : blocks) {
                if (powerUp.collidesWith(block)) {
                    powerUp.setIsDead(true);
                }
            }
        }

    }

    private void checkIfPlayerIsDead() {
        if (player.isDead()) {
            setLevel(currentLevelNumber);

            this.levelAttempts++;
        }
    }

    public void updateEnemies() {
        for (Enemy enemy : enemies) {
            enemy.update();
        }
    }

    public void startGame() {
        setLevel(1);

        totalPauseTime = 0;
        pauseStartTime = 0;
        levelAttempts = 0;
        score = 0;
        levelStartTime = System.currentTimeMillis();
    }

    public void restartGame() {
        setLevel(currentLevelNumber);

        totalPauseTime = 0;
        pauseStartTime = 0;
        levelAttempts = 0;
        score = 0;
        levelStartTime = System.currentTimeMillis();

        for (GameObserver o : observers) {
            o.updateObserver();
        }
    }

    private void setLevel(int levelNumber) {
        gameState = GameState.PLAYING;

        if (levelNumber != currentLevelNumber) {
            levelAttempts = 0;
            score = 0;
            levelStartTime = System.currentTimeMillis();
        }

        enemies = new ArrayList<>();
        blocks = new ArrayList<>();
        powerUps = new ArrayList<>();
        enemies.clear();
        blocks.clear();
        powerUps.clear();
        movableBlocks.clear();
        currentLevel = LevelFactory.createLevel(levelNumber);

        // GameStats
        currentLevelNumber = levelNumber;
        grid = new IGameObject[currentLevel.getWidth()][currentLevel.getHeight()];
        for (int i = 0; i < currentLevel.getHeight(); i++) {
            for (int j = 0; j < currentLevel.getWidth(); j++) {
                Metadata metadata = currentLevel.getMetadata(new Tuple(j, i));
                if (acceptedEnemyTypes.contains(currentLevel.getLevelTile(i, j))) {
                    Enemy newEnemy = EnemyFactory.createEnemyAt(currentLevel.getLevelTile(i, j), j * 16, i * 16,
                            metadata);
                    addEnemy(newEnemy);
                    grid[j][i] = newEnemy;

                } else if (acceptedBlockTypes.contains(currentLevel.getLevelTile(i, j))) {
                    Block newBlock = BlockFactory.createBlockAt(currentLevel.getLevelTile(i, j), j * 16, i * 16,
                            metadata);
                    addBlock(newBlock);
                    grid[j][i] = newBlock;
                    if (newBlock instanceof MovableBlock) {
                        movableBlocks.add((MovableBlock) newBlock);
                    }

                } else if (acceptedPowerUpTypes.contains(currentLevel.getLevelTile(i, j))) {
                    PowerUp newPowerUp = PowerUpFactory.createPowerUpPickUpAt(currentLevel.getLevelTile(i, j), j * 16,
                            i * 16);
                    powerUps.add(newPowerUp);
                    grid[j][i] = newPowerUp;

                } else if (currentLevel.getLevelTile(i, j) == GameObjectType.PLAYER____) {
                    // The grid uses /16 of the actual size
                    player = new Player(j * 16, i * 16, getHeight() * 16, getWidth() * 16);
                    grid[j][i] = player;

                } else if (currentLevel.getLevelTile(i, j) == GameObjectType.GOAL______) {
                    // will only reset if there is a new flag on next level.
                    goalFlag = new Flag(j * 16, i * 16);
                    grid[j][i] = goalFlag;

                }
            }
        }
    }

    public long getElapsedTime() {
        return System.currentTimeMillis() - levelStartTime - totalPauseTime;
    }

    public void update() {
        moveMovableBlocks();
        player.update();

        checkIfPlayerAtFlag();
        checkIfPlayerCollidesWithBlocks();
        checkIfPlayerCollidesWithEnemies();
        checkIfPlayerCollidesWithPowerUp();

        checkIfFlyingEnemyCollidesWithBlocks();

        checkIfPowerUpsCollidesWithEnemies();
        checkIfPowerUpsCollidesWithBlocks();

        updateProjectilePositions();
        removeDeadEntities();
        updateEnemies();

        for (GameObserver o : observers) {
            o.updateObserver();
        }

        checkIfPlayerIsDead();
    }

    private void updateProjectilePositions() {
        for (PowerUp powerUp : powerUps) {
            powerUp.update();
        }
    }

    private void removeDeadEntities() {
        removeDeadEnemy();
        removeUsedPowerUps();
        freezeFrozenEnemy();
    }

    private void removeDeadEnemy() {
        Enemy enemyToRemove = null;
        for (Enemy enemy : enemies) {
            if (enemy.isDead()) {
                enemyToRemove = enemy;
            }
        }
        if (enemyToRemove != null) {
            enemies.remove(enemyToRemove);
        }
    }

    private void removeUsedPowerUps() {
        PowerUp powerUpToRemove = null;
        for (PowerUp powerUp : powerUps) {
            if (powerUp.isDead()) {
                powerUpToRemove = powerUp;
            }
        }
        if (powerUpToRemove != null) {
            powerUps.remove(powerUpToRemove);
        }
    }

    private void freezeFrozenEnemy() {
        for (Enemy enemy : enemies) {
            if (enemy.getFrozen()) {
                Block frozenEnemy = BlockFactory.createBlockAt(STATIONARY, enemy.getX(), enemy.getY(),
                        new Metadata(0, Direction.NONE, Direction.NONE));
                addBlock(frozenEnemy);
                enemy.setIsDead(true);
            }
        }
    }

    public void addObserver(GameObserver observer) {
        observers.add(observer);
    }

    public void addEnemy(Enemy enemy) {
        this.enemies.add(enemy);
    }

    public void removeEnemy(Enemy enemy) {
        this.enemies.remove(enemy);
    }

    public void addBlock(Block block) {
        this.blocks.add(block);
    }

    public Player getPlayer() {
        return this.player;
    }

    public Flag getGoalFlag() {
        return goalFlag;
    }

    public Collection<Enemy> getEnemies() {
        return this.enemies;
    }

    public Collection<Block> getBlocks() {
        return this.blocks;
    }

    public Collection<PowerUp> getPowerUps() {
        return this.powerUps;
    }

    public IGameObject[][] getGrid() {
        return this.grid;
    }

    public int getWidth() {
        return grid[0].length;
    }

    public int getHeight() {
        return grid.length;
    }

    public GameState getPauseState() {
        return this.gameState;
    }

    public void togglePause() {
        GameState currentGameState = getGameState();

        if (currentGameState == GameState.PLAYING) {
            pauseStartTime = System.currentTimeMillis();
            setGameState(GameState.PAUSED);
        } else if (currentGameState == GameState.PAUSED) {
            totalPauseTime += System.currentTimeMillis() - pauseStartTime;
            setGameState(GameState.PLAYING);
        }

        for (GameObserver o : observers) {
            o.updateObserver();
        }
    }

    public void goToMainMenu() {
        setGameState(GameState.START);

        for (GameObserver o : observers) {
            o.updateObserver();
        }
    }

    // is here because levelHandler has the power ups list that I need to change for
    // things to be drawn
    public void usePowerUp() {
        PowerUp powerUp;
        switch (player.getHasPowerUp()) {
            case SPEAR_____:
                powerUp = PowerUpFactory.createPowerUpUsableAt(SPEAR_____, player.getX(), player.getY(), true,
                        player.getDirection());
                powerUps.add(powerUp);
                player.setHasPowerUp(GameObjectType.NOTHING___);
                break;
            case FREEZE____:
                powerUp = PowerUpFactory.createPowerUpUsableAt(FREEZE____, player.getX(), player.getY(), true,
                        player.getDirection());
                powerUps.add(powerUp);
                player.setHasPowerUp(GameObjectType.NOTHING___);
                break;
            default:
                break;

        }
    }

    public void moveMovableBlocks() {
        for (Block block : blocks) {
            if (block instanceof MovableBlock) {
                ((MovableBlock) block).move();
            }
        }
    }

}