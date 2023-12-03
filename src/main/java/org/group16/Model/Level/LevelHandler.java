package org.group16.Model.Level;

import static org.group16.Model.GameObjects.GameObjectType.SPEAR_____;
import static org.group16.Model.GameObjects.GameObjectType.FREEZE____;
import static org.group16.Model.GameObjects.GameObjectType.STATIONARY;

import java.util.ArrayList;
import java.util.Collection;

import org.group16.Model.GameObjects.Enemy.IEnemy;
import org.group16.Model.GameObjects.Enemy.IMovableEnemy;
import org.group16.Model.GameObjects.Enemy.ITrap;
import org.group16.Model.GameObjects.Enemy.TrapFactory;
import org.group16.Model.GameObjects.Goal.Goal;
import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.GameState;
import org.group16.Model.GameObjects.Blocks.BlockFactory;
import org.group16.Model.GameObjects.Blocks.IBlock;
import org.group16.Model.GameObjects.Blocks.MovableBlock;
import org.group16.Model.GameObjects.Enemy.EnemyFactory;
import org.group16.Model.GameObjects.Player.IPlayer;
import org.group16.Model.GameObjects.Player.PlayerFactory;
import org.group16.Model.GameObjects.PowerUp.PowerUp;
import org.group16.Model.GameObjects.PowerUp.PowerUpFactory;
import org.group16.Model.Observers.GameObserver;

public class LevelHandler {
    private IPlayer player;
    private Goal goal;
    private Collection<IEnemy> enemies;
    private Collection<IMovableEnemy> movableEnemies;
    private Collection<IBlock> blocks;
    private Collection<PowerUp> powerUps;
    private Collection<ITrap> traps;

    private boolean playerIsAtGoal;
    
    private Collection<GameObserver> observers;
    private int lastLevelNumber = 0;
    private int score = 0;
    private Level currentLevel;
    private long levelStartTime;
    private int levelAttempts = 0;
    private final static int SCORE_LIMIT = 9999;
    private GameState gameState;

    // width and height depending on how big the level is

    private long pauseStartTime = 0;
    private long totalPauseTime = 0;

    public LevelHandler() {
        observers = new ArrayList<>();
        gameState = GameState.START;
        enemies = new ArrayList<>();
        blocks = new ArrayList<>();
        powerUps = new ArrayList<>();
        traps = new ArrayList<>();
        movableEnemies = new ArrayList<>();
    }

    public GameState getGameState() {
        return gameState;
    }

    private void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getCurrentLevelNumber() {
        return currentLevel.getLevelNumber();
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
    private void checkIfPlayerAtGoal() {
        if (player.collidesWith(goal)) {
            setLevel(2);
        }
    }

    private void checkIfPlayerCollidesWithBlocks() {
        for (IBlock block : blocks) {
            player.collision(block);
        }
    }

    private void checkIfPlayerCollidesWithEnemies() {
        for (IEnemy enemy : enemies) {
            if (player.collidesWith(enemy)) {
                enemy.dealDamage(player);
            }
        }
    }

    private void checkIfPlayerCollidesWithTraps() {
        for (ITrap trap : traps) {
            if (player.collidesWith(trap)) {
                trap.dealDamage(player);
            }
        }
    }

    private void checkIfMovableEnemiesCollidesWithBlocks() {
        for (IMovableEnemy enemy : movableEnemies) {
            switch (enemy.getType()) {
                case FLYING____:
                    for (IBlock block : blocks) {
                        if (enemy.collidesWith(block)) {
                            enemy.toggleDirection();
                        }
                    }
                    break;
                case BASIC_____:
                    for (IBlock block : blocks) {
                        if (enemy.collidesWith(block)) {
                            enemy.toggleDirection();
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private void checkIfPlayerCollidesWithPowerUp() {
        PowerUp powerUpToRemove = null;

        if (player.getCurrentPowerUp() == GameObjectType.NOTHING___) {
            for (PowerUp powerUp : powerUps) {
                if (player.collidesWith(powerUp)) {
                    if (!powerUp.getMovable()) {
                        powerUpToRemove = powerUp;
                        player.setCurrentPowerUp(powerUp.getType());

                    }
                }
            }
            powerUps.remove(powerUpToRemove);
        }
    }

    private void checkIfPowerUpsCollidesWithEnemies() {
        for (PowerUp powerUp : powerUps) {
            for (IEnemy enemy : enemies) {
                if (powerUp.collidesWith(enemy)) {
                    enemy.triggerPowerUp(powerUp.getType());
                    powerUp.use();
                }
            }
        }
    }

    private void checkIfPowerUpsCollidesWithTraps() {
        for (PowerUp powerUp : powerUps) {
            for (ITrap trap : traps) {
                if (powerUp.collidesWith(trap)) {
                    trap.triggerPowerUp(powerUp.getType());
                    powerUp.use();
                }
            }
        }
    }

    private void checkIfPowerUpsCollidesWithBlocks() {
        for (PowerUp powerUp : powerUps) {
            for (IBlock block : blocks) {
                if (powerUp.collidesWith(block)) {
                    powerUp.use();
                }
            }
        }

    }

    private void checkIfPlayerIsDead() {
        if (player.isDead()) {
            setLevel(currentLevel.getLevelNumber());
            
            levelAttempts++;
        }
    }

    public void updateEnemies() {
        for (IEnemy enemy : enemies) {
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
        setLevel(currentLevel.getLevelNumber());

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

        if (levelNumber != lastLevelNumber) {
            levelAttempts = 0;
            score = 0;
            levelStartTime = System.currentTimeMillis();
        }

        enemies.clear();
        blocks.clear();
        powerUps.clear();
        traps.clear();
        movableEnemies.clear();

        currentLevel = LevelFactory.createLevel(levelNumber);
        lastLevelNumber = levelNumber;

        for (int i = 0; i < currentLevel.getHeight(); i++) {
            for (int j = 0; j < currentLevel.getWidth(); j++) {
                Metadata metadata = currentLevel.getMetadata(new Tuple(j, i));
                GameObjectType currentLevelTile = currentLevel.getLevelTile(i, j);
                switch (currentLevelTile) {
                    case BASIC_____:
                    case FLYING____:
                    case TELEPORT__:
                        createMovableEnemy(i, j, metadata, currentLevelTile);
                        break;

                    case STATIONARY:
                        createBlock(i, j, metadata, currentLevelTile);
                        break;

                    case MOVABLE___:
                        createMovableBlock(i, j, metadata, currentLevelTile);
                        break;

                    case SPEAR_____:
                    case FREEZE____:
                        createPowerUp(i, j, currentLevelTile);
                        break;

                    case SPIKE_____:
                        createTrap(i, j, currentLevelTile);
                        break;

                    case PLAYER____:
                        // The grid uses /16 of the actual size
                        player = PlayerFactory.createPlayerAt(currentLevelTile, j * 16, i * 16, getHeight() * 16, getWidth() * 16);
                        break;

                    case GOAL______:
                        // will only reset if there is a new goal on next level.
                        goal = new Goal(j * 16, i * 16);
                        break;

                    default:
                        break;
                }
            }
        }
    }

    private void createTrap(int i, int j, GameObjectType currentLevelTile) {
        ITrap newTrap = TrapFactory.createTrapAt(currentLevelTile, j * 16, i * 16);
        traps.add(newTrap);
    }

    private void createPowerUp(int i, int j, GameObjectType currentLevelTile) {
        PowerUp newPowerUp = PowerUpFactory.createPowerUpPickUpAt(currentLevelTile, j * 16, i * 16);
        powerUps.add(newPowerUp);
    }

    private void createBlock(int i, int j, Metadata metadata, GameObjectType currentLevelTile) {
        IBlock newBlock = BlockFactory.createBlockAt(currentLevelTile, j * 16, i * 16, metadata);
        blocks.add(newBlock);
    }

    private void createMovableBlock(int i, int j, Metadata metadata, GameObjectType currentLevelTile) {
        MovableBlock newBlock = BlockFactory.createMovableBlockAt(currentLevelTile, j * 16, i * 16, metadata);
        blocks.add(newBlock);
    }

    // exists for when we want non movable enemies
    private void createEnemy(int i, int j, Metadata metadata, GameObjectType currentLevelTile) {
        IEnemy newEnemy = EnemyFactory.createEnemyAt(currentLevelTile, j * 16, i * 16, metadata);
        enemies.add(newEnemy);
    }

    private void createMovableEnemy(int i, int j, Metadata metadata, GameObjectType currentLevelTile) {
        IMovableEnemy newEnemy = EnemyFactory.createMovableEnemyAt(currentLevelTile, j * 16, i * 16, metadata);
        enemies.add(newEnemy);
        movableEnemies.add(newEnemy);
    }

    public long getElapsedTime() {
        return System.currentTimeMillis() - levelStartTime - totalPauseTime;
    }

    public void update() {
        updateBlocks();
        player.update();

        checkIfPlayerAtGoal();
        checkIfPlayerCollidesWithBlocks();
        checkIfPlayerCollidesWithEnemies();
        checkIfPlayerCollidesWithTraps();
        checkIfPlayerCollidesWithPowerUp();

        checkIfMovableEnemiesCollidesWithBlocks();

        checkIfPowerUpsCollidesWithEnemies();
        checkIfPowerUpsCollidesWithTraps();
        checkIfPowerUpsCollidesWithBlocks();

        updateProjectilePositions();
        removeDeadEntities();
        removeFrozenTrap();
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
        IEnemy enemyToRemove = null;
        for (IEnemy enemy : enemies) {
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
        for (IEnemy enemy : enemies) {
            if (enemy.isFrozen()) {
                IBlock frozenEnemy = BlockFactory.createBlockAt(STATIONARY, enemy.getX(), enemy.getY(),
                        new Metadata(0, Direction.NONE, Direction.NONE));
                blocks.add(frozenEnemy);
                enemy.updateHealth(enemy.getHealth());
            }
        }

        for (ITrap trap : traps) {
            if (trap.isFrozen()) {
                IBlock frozenTrap = BlockFactory.createBlockAt(STATIONARY, trap.getX(), trap.getY(),
                        new Metadata(0, Direction.NONE, Direction.NONE));
                blocks.add(frozenTrap);
            }
        }
    }

    private void removeFrozenTrap() {
        ITrap trapToRemove = null;
        for (ITrap trap : traps) {
            if (trap.isFrozen()) {
                trapToRemove = trap;
            }
        }
        if (trapToRemove != null) {
            traps.remove(trapToRemove);
        }
    }

    public void addObserver(GameObserver observer) {
        observers.add(observer);
    }

    public void removeEnemy(IEnemy enemy) {
        enemies.remove(enemy);
    }

    public IPlayer getPlayer() {
        return player;
    }

    public Goal getGoal() {
        return goal;
    }

    public Collection<IEnemy> getEnemies() {
        return enemies;
    }

    public Collection<IBlock> getBlocks() {
        return blocks;
    }

    public Collection<PowerUp> getPowerUps() {
        return powerUps;
    }

    public Collection<ITrap> getTraps() {
        return traps;
    }

    // Somehow this is the right way to do it
    public int getWidth() {
        return currentLevel.getHeight();
    }

    public int getHeight() {
        return currentLevel.getWidth();
    }

    public GameState getPauseState() {
        return gameState;
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
        switch (player.getCurrentPowerUp()) {
            case SPEAR_____:
                powerUp = PowerUpFactory.createPowerUpUsableAt(SPEAR_____, player.getX(), player.getY(), true,
                        player.getDirection());
                powerUps.add(powerUp);
                player.setCurrentPowerUp(GameObjectType.NOTHING___);
                break;
            case FREEZE____:
                powerUp = PowerUpFactory.createPowerUpUsableAt(FREEZE____, player.getX(), player.getY(), true,
                        player.getDirection());
                powerUps.add(powerUp);
                player.setCurrentPowerUp(GameObjectType.NOTHING___);
                break;
            default:
                break;

        }
    }

    public void updateBlocks() {
        for (IBlock block : blocks) {
            block.update();
        }
    }

}