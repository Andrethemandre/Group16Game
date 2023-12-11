package org.group16.Model.Level;

import static org.group16.Model.GameObjects.GameObjectType.SPEAR_____;
import static org.group16.Model.GameObjects.GameObjectType.FREEZE____;
import static org.group16.Model.GameObjects.GameObjectType.STATIONARY;

import java.util.ArrayList;
import java.util.Collection;

import org.group16.Model.GameObjects.Enemy.*;
import org.group16.Model.GameObjects.Goal.IGoal;
import org.group16.Model.GameObjects.Goal.GoalFactory;
import org.group16.Model.GameObjects.Direction;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.GameState;
import org.group16.Model.GameObjects.Blocks.BlockFactory;
import org.group16.Model.GameObjects.Blocks.IBlock;
import org.group16.Model.GameObjects.Blocks.IMovableBlock;
import org.group16.Model.GameObjects.Blocks.ITeleportBlock;
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
    private Collection<EnemyWithTarget> enemiesWithTarget;

    private Collection<ITeleportBlock> teleportBlocks;
    private Collection<GameObserver> observers;
    private int lastLevelNumber = 1;
    private Level currentLevel;
    private GameState gameState;

    private GameStateManager gameStateManager;
    private StatsManager statsManager;
    private LevelSelectPageManager levelSelectPageManager;

    private final static int TOTAL_LEVELS = LevelFactory.getTotalLevels();

    public LevelHandler() {
        observers = new ArrayList<>();

        levelSelectPageManager = new LevelSelectPageManager(TOTAL_LEVELS);
        gameStateManager = new GameStateManager();
        enemies = new ArrayList<>();
        blocks = new ArrayList<>();
        powerUps = new ArrayList<>();
        traps = new ArrayList<>();
        movableEnemies = new ArrayList<>();
        enemiesWithTarget = new ArrayList<>();
        teleportBlocks = new ArrayList<>();

        statsManager = new StatsManager();

        for (int i = 1; i <= TOTAL_LEVELS; i++) {
            statsManager.recordStats(i, new LevelStats(0, 0, 0,0));
        }

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
        return statsManager.getCurrentScore();
    }

    public int getEndScore(){
        return statsManager.getEndScore();
    }

    public int getCurrentAttempts() {
        return statsManager.getLevelAttempts();
    }

    public int getEnemiesDefeated() {
        return statsManager.getEnemiesDefeated();
    }

    public int getPowerUpsPicked() {
        return statsManager.getPowerUpsPicked();
    }

    // collision checkers
    private void checkIfPlayerAtGoal() {
        if (player.collidesWith(goal)) {
            if (getLevelHighScore(currentLevel.getLevelNumber()) < getEndScore()) {
                statsManager.recordStats(currentLevel.getLevelNumber(), new LevelStats(getEndScore(),getEnemiesDefeated(),getPowerUpsPicked(),getElapsedTime()));
            }

            if (currentLevel.getLevelNumber() >= TOTAL_LEVELS) {
                goToMainMenu();
            } else {
                startGame();
                setLevel(currentLevel.getLevelNumber() + 1);
            }

        }
    }

    private void checkIfPlayerCollidesWithBlocks() {
        for (IBlock block : blocks) {
            player.checkCollision(block);
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
                if (powerUp.collidesWith(enemy) && powerUp.isMoving()) {
                    enemy.triggerPowerUp(powerUp.getType());

                    if(enemy.isDead()){
                        incrementEnemiesDefeatedStats(enemy);
                        incrementPowerUpHitStats(powerUp);
                    }

                    powerUp.use();
                }
            }
        }
    }

    private void checkEnemiesWithTargetCollision() {
        for (EnemyWithTarget enemy : enemiesWithTarget) {
            for (IBlock block : blocks) {
                if (enemy.collidesWith(block)) {
                    enemy.checkCollision(block);
                }
            }
        }
    }

    private void incrementPowerUpHitStats(IPowerUp powerUp) {
        switch (powerUp.getType()) {
            case SPEAR_____:
                statsManager.incrementSpearPowerUpsKills();
                break;
            case FREEZE____:
                statsManager.incrementFreezePowerUpsFroze();
                break;
            default:
                break;
        }
    }

    private void incrementEnemiesDefeatedStats(IEnemy enemy) {
        switch (enemy.getType()) {
            case BASIC_____:
                statsManager.incrementBasicEnemiesDefeated();
                break;
            case FLYING____:
                statsManager.incrementFlyingEnemiesDefeated();
                break;
            default:
                break;
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
        teleportBlocks.clear();
        enemiesWithTarget.clear();


        currentLevel = LevelFactory.createLevel(levelNumber);

        setCurrentLevelNumber(levelNumber);

        for (int i = 0; i < currentLevel.getHeight(); i++) {
            for (int j = 0; j < currentLevel.getWidth(); j++) {
                Metadata metadata = currentLevel.getMetadata(new Tuple(j, i));
                GameObjectType currentLevelTile = currentLevel.getLevelTile(i, j);
                switch (currentLevelTile) {
                    case BASIC_____:
                    case FLYING____:
                        createMovableEnemy(i, j, metadata, currentLevelTile);
                        break;

                    case TELEPORT__:
                        createEnemyWithTarget(i, j, metadata, currentLevelTile);
                        break;

                    case STATIONARY:
                        createBlock(i, j, currentLevelTile);
                        break;

                    case MOVABLE___:
                        createMovableBlock(i, j, metadata, currentLevelTile);
                        break;

                    case TELEPORTER:
                        createTeleportBlock(i, j, metadata, currentLevelTile);
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

    private void createBlock(int i, int j, GameObjectType currentLevelTile) {
        IBlock newBlock = BlockFactory.createBlockAt(currentLevelTile, j * 16, i * 16);
        blocks.add(newBlock);
    }

    private void createMovableBlock(int i, int j, Metadata metadata, GameObjectType currentLevelTile) {
        IMovableBlock newBlock = BlockFactory.createMovableBlockAt(currentLevelTile, j * 16, i * 16, metadata);
        blocks.add(newBlock);
    }

    // exists for when we want non movable enemies
    private void createEnemy(int i, int j, Metadata metadata, GameObjectType currentLevelTile) {
        IEnemy newEnemy = EnemyFactory.createEnemyAt(currentLevelTile, j * 16, i * 16, metadata);
        enemies.add(newEnemy);
    }

    private void createEnemyWithTarget(int i, int j, Metadata metadata, GameObjectType currentLevelTile) {
        EnemyWithTarget newEnemy = EnemyFactory.createEnemyWithTargetAt(currentLevelTile, j * 16, i * 16, metadata);
        enemies.add(newEnemy);
        movableEnemies.add(newEnemy);
        enemiesWithTarget.add(newEnemy);
    }

    private void createMovableEnemy(int i, int j, Metadata metadata, GameObjectType currentLevelTile) {
        IMovableEnemy newEnemy = EnemyFactory.createMovableEnemyAt(currentLevelTile, j * 16, i * 16, metadata);
        enemies.add(newEnemy);
        movableEnemies.add(newEnemy);
    }

    private void createTeleportBlock(int i, int j, Metadata metadata, GameObjectType currentLevelTile) {
        ITeleportBlock newBlock = BlockFactory.createTeleportBlockAt(currentLevelTile, j * 16, i * 16, metadata);
        blocks.add(newBlock);
        teleportBlocks.add(newBlock);
    }

    public long getElapsedTime() {
        return statsManager.getElapsedTime();
    }

    public void update() {
        updateBlocks();
        player.update();

        checkIfPlayerCollidesWithTeleportBlocks();
        checkIfPlayerAtGoal();
        checkIfPlayerCollidesWithBlocks();
        checkIfPlayerCollidesWithEnemies();
        checkIfPlayerCollidesWithTraps();
        checkIfPlayerCollidesWithPowerUp();
        checkIfPlayerIsDead();
        updatePowerUps();
        removeDeadEntities();

        checkIfMovableEnemiesCollidesWithBlocks();

        checkIfPowerUpsCollidesWithEnemies();
        checkIfPowerUpsCollidesWithTraps();
        checkIfPowerUpsCollidesWithBlocks();

        updateEnemies();
        updateEnemiesWithTarget();
        checkEnemiesWithTargetCollision();

        notifyObservers();
    }

    private void updatePowerUps() {
        for (IPowerUp powerUp : powerUps) {
            powerUp.update();
        }
    }

    private void updateEnemiesWithTarget(){
        for (EnemyWithTarget enemyWithTarget : enemiesWithTarget) {
            enemyWithTarget.setTargetCoordinates(player.getX(), player.getY());
        }
    }

    private void removeDeadEntities() {
        removeDeadEnemy(enemies);
        removeDeadEnemy(movableEnemies);
        removeDeadEnemy(enemiesWithTarget);
        
        removeUsedPowerUps();
        freezeFrozenEnemy();
    }

    private void removeDeadEnemy(Collection<? extends IEnemy> enemies) {
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
                IBlock frozenEnemy = BlockFactory.createBlockAt(STATIONARY, enemy.getX(), enemy.getY());
                blocks.add(frozenEnemy);
                enemy.updateHealth(enemy.getHealth());
            }
        }

        for (ITrap trap : traps) {
            if (trap.isFrozen()) {
                IBlock frozenTrap = BlockFactory.createBlockAt(STATIONARY, trap.getX(), trap.getY());
                blocks.add(frozenTrap);
                
            }
        }
        removeFrozenTrap();
    }

    private void removeFrozenTrap() {
        ITrap trapToRemove = null;
        for (ITrap trap : traps) {
            if (trap.isFrozen()) {
                statsManager.incrementFreezePowerUpsFroze();
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

    public GameObjectType getPlayersPowerUp (){
        return player.getCurrentPowerUp();
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

    public Collection<ITeleportBlock> getTeleportBlocks() {
        return teleportBlocks;
    }

    public Collection<IPowerUp> getPowerUps() {
        return powerUps;
    }

    public Collection<ITrap> getTraps() {
        return traps;
    }

    public Collection<EnemyWithTarget> getEnemiesWithTarget() {
        return enemiesWithTarget;
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
        gameStateManager.togglePause();
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

    public void checkIfPlayerCollidesWithTeleportBlocks() {
        for (ITeleportBlock teleportBlock : teleportBlocks) {
            if (player.collidesWith(teleportBlock)) {
                teleportBlock.teleport(player);
            }
        }
    }
}
