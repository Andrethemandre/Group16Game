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
import org.group16.Model.GameObjects.Goal.IGoal;
import org.group16.Model.GameObjects.Goal.GoalFactory;
import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.GameState;
import org.group16.Model.GameObjects.Blocks.BlockFactory;
import org.group16.Model.GameObjects.Blocks.IBlock;
import org.group16.Model.GameObjects.Blocks.MovableBlock;
import org.group16.Model.GameObjects.Enemy.EnemyFactory;
import org.group16.Model.GameObjects.Player.IPlayer;
import org.group16.Model.GameObjects.Player.PlayerFactory;
import org.group16.Model.GameObjects.PowerUp.IPowerUp;
import org.group16.Model.GameObjects.PowerUp.PowerUpFactory;
import org.group16.Model.Observers.GameObserver;

public class LevelHandler {
    private IPlayer player;
    private IGoal goal;
    private Collection<IEnemy> enemies;
    private Collection<IMovableEnemy> movableEnemies;
    private Collection<IBlock> blocks;
    private Collection<IPowerUp> powerUps;
    private Collection<ITrap> traps;

    private boolean playerIsAtGoal;

    private Collection<GameObserver> observers;
    private int lastLevelNumber = 0;
    private Level currentLevel;
    private GameState gameState;

    private GameStateManager gameStateManager;
    private StatsManager statsManager;
    private LevelSelectPageManager levelSelectPageManager;

    private final static int TOTAL_LEVELS = 10;

    // width and height depending on how big the level is

    public LevelHandler() {
        observers = new ArrayList<>();

        levelSelectPageManager = new LevelSelectPageManager(TOTAL_LEVELS);
        gameStateManager = new GameStateManager();

        enemies = new ArrayList<>();
        blocks = new ArrayList<>();
        powerUps = new ArrayList<>();
        traps = new ArrayList<>();
        movableEnemies = new ArrayList<>();

        statsManager = new StatsManager();
        statsManager.recordStats(1, new Stats(0));
        statsManager.recordStats(2, new Stats(0));
        statsManager.recordStats(3, new Stats(0));
        statsManager.recordStats(4, new Stats(0));
        statsManager.recordStats(5, new Stats(0));
        statsManager.recordStats(6, new Stats(0));
        statsManager.recordStats(7, new Stats(0));
        statsManager.recordStats(8, new Stats(0));
        statsManager.recordStats(9, new Stats(0));
        statsManager.recordStats(10, new Stats(0));

        levelSelectPageManager.setSelectedLevelNumber(1);

    }

    public int getTotalLevels() {
        return TOTAL_LEVELS;
    }

    public int getCurrentLevelSelectPage() {
        return levelSelectPageManager.getCurrentPage();
    }

    public void nextLevelSelectPage() {
        levelSelectPageManager.nextPage();
    }

    public void previousLevelSelectPage() {
        levelSelectPageManager.previousPage();
    }

    public int getLevelHighScore(int levelNumber) {
        return statsManager.getStats(levelNumber).getScore();
    }

    public GameState getGameState() {
        return gameStateManager.getGameState();
    }

    public int getCurrentSelectedLevelNumber() {
        return levelSelectPageManager.getSelectedLevelNumber();
    }

    public int getCurrentLevelNumber() {
        return currentLevel.getLevelNumber();
    }

    public void setSelectLevelNumber(int levelNumber) {
        levelSelectPageManager.setSelectedLevelNumber(levelNumber);
    }

    public void setCurrentLevelNumber(int levelNumber) {
        if (levelNumber > 0 && levelNumber < TOTAL_LEVELS + 1) {
            lastLevelNumber = levelNumber;
        }
    }

    public int getCurrentScore() {
        return statsManager.getScore();
    }

    public int getCurrentAttempts() {
        return statsManager.getLevelAttempts();
    }

    // collision checkers
    private void checkIfPlayerAtGoal() {
        if (player.collidesWith(goal)) {
            if (getLevelHighScore(currentLevel.getLevelNumber()) < getCurrentScore()) {
                statsManager.recordStats(currentLevel.getLevelNumber(), new Stats(getCurrentScore()));
            }

            if (currentLevel.getLevelNumber() > TOTAL_LEVELS) {
                goToMainMenu();
            } else {
                startGame();
                setLevel(currentLevel.getLevelNumber() + 1);
            }

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
        IPowerUp powerUpToRemove = null;

        if (player.getCurrentPowerUp() == GameObjectType.NOTHING___) {
            for (IPowerUp powerUp : powerUps) {
                if (player.collidesWith(powerUp)) {
                    if (!powerUp.isMoving()) {
                        powerUpToRemove = powerUp;
                        player.setCurrentPowerUp(powerUp.getType());

                    }
                }
            }
            powerUps.remove(powerUpToRemove);
        }
    }

    private void checkIfPowerUpsCollidesWithEnemies() {
        for (IPowerUp powerUp : powerUps) {
            for (IEnemy enemy : enemies) {
                if (powerUp.collidesWith(enemy)) {
                    enemy.triggerPowerUp(powerUp.getType());
                    powerUp.use();
                }
            }
        }
    }

    private void checkIfPowerUpsCollidesWithTraps() {
        for (IPowerUp powerUp : powerUps) {
            for (ITrap trap : traps) {
                if (powerUp.collidesWith(trap)) {
                    trap.triggerPowerUp(powerUp.getType());
                    powerUp.use();
                }
            }
        }
    }

    private void checkIfPowerUpsCollidesWithBlocks() {
        for (IPowerUp powerUp : powerUps) {
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
            statsManager.incrementLevelAttempts();
        }
    }

    public void updateEnemies() {
        for (IEnemy enemy : enemies) {
            enemy.update();
        }
    }

    public void notifyObservers() {
        for (GameObserver o : observers) {
            o.updateObserver();
        }
    }

    public void newGame() {
        // TODO: SAVE SYSTEM
        gameStateManager.newGame();
    }

    public void continueGame() {
        gameStateManager.continueGame();
    }

    public void goToLevelSelect() {
        gameStateManager.goToLevelSelect();
    }

    public void startGame() {
        gameStateManager.startGame();
        setLevel(lastLevelNumber);

        statsManager.resetScore();

        notifyObservers();
    }

    public void goToMainMenu() {
        gameStateManager.goToMainMenu();

        notifyObservers();
    }

    public void loadGame() {
        // TODO: SAVE SYSTEM
        gameStateManager.loadGame();

        notifyObservers();
    }

    public void restartGame() {
        setLevel(currentLevel.getLevelNumber());

        statsManager.resetScore();
        gameStateManager.togglePause();

        notifyObservers();
    }

    private void setLevel(int levelNumber) {
        enemies.clear();
        blocks.clear();
        powerUps.clear();
        traps.clear();
        movableEnemies.clear();

        currentLevel = LevelFactory.createLevel(levelNumber);

        setCurrentLevelNumber(levelNumber);

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

                        player = PlayerFactory.createPlayerAt(currentLevelTile, j * 16, i * 16, getHeight() * 16,
                                getWidth() * 16);
                        break;

                    case GOAL______:
                        // will only reset if there is a new goal on next level.
                        goal = GoalFactory.createGoalAt(currentLevelTile, j * 16, i * 16);
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
        IPowerUp newPowerUp = PowerUpFactory.createPowerUpPickUpAt(currentLevelTile, j * 16, i * 16);
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
        return statsManager.getElapsedTime();
    }

    public void update() {
        updateBlocks();
        player.update();

        checkIfPlayerAtGoal();
        checkIfPlayerCollidesWithBlocks();
        checkIfPlayerCollidesWithEnemies();
        checkIfPlayerCollidesWithTraps();
        checkIfPlayerCollidesWithPowerUp();
        checkIfPlayerIsDead();

        checkIfMovableEnemiesCollidesWithBlocks();

        checkIfPowerUpsCollidesWithEnemies();
        checkIfPowerUpsCollidesWithTraps();
        checkIfPowerUpsCollidesWithBlocks();

        removeFrozenTrap();
        updateEnemies();

        notifyObservers();
    }

    private void updatePowerUps() {
        for (IPowerUp powerUp : powerUps) {
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
        IPowerUp powerUpToRemove = null;
        for (IPowerUp powerUp : powerUps) {
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

    public IGoal getGoal() {
        return goal;
    }

    public Collection<IEnemy> getEnemies() {
        return enemies;
    }

    public Collection<IBlock> getBlocks() {
        return blocks;
    }

    public Collection<IPowerUp> getPowerUps() {
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

        if (gameStateManager.getGameState() == GameState.PAUSED) {
            statsManager.setPauseStartTime();

        } else if (gameStateManager.getGameState() == GameState.PLAYING) {
            statsManager.setTotalPauseTime();
        }

        notifyObservers();
    }

    // is here because levelHandler has the power ups list that I need to change for
    // things to be drawn
    public void usePowerUp() {
        IPowerUp powerUp;
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