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
import org.group16.Model.GameObjects.PowerUp.PowerUp;
import org.group16.Model.GameObjects.PowerUp.PowerUpFactory;
import org.group16.Model.Observers.GameObserver;

public class LevelHandler {
    private List<MovableBlock> movableBlocks; // Add this member variable
    private Player player;
    private Flag goalFlag;
    private Collection<Enemy> enemies;
    private Collection<Block> blocks;
    private Collection<PowerUp> powerUps;
    private Collection<GameObjectType> acceptedEnemyTypes = Arrays
            .asList(new GameObjectType[] { GameObjectType.BASIC_____, GameObjectType.SPIKE_____,
                    GameObjectType.FLYING____, GameObjectType.TELEPORT__ });
    private Collection<GameObjectType> acceptedBlockTypes = Arrays
            .asList(new GameObjectType[] { GameObjectType.STATIONARY, GameObjectType.MOVABLE___ });
    private Collection<GameObjectType> acceptedPowerUpTypes = Arrays
            .asList(new GameObjectType[] { GameObjectType.SPEAR_____, GameObjectType.FREEZE____ });
    private Collection<GameObserver> observers;
    private int currentLevelNumber;
    private Level currentLevel;
    private GameStateManager gameStateManager;    
    private StatsManager statsManager;
    private LevelSelectPageManager levelSelectPageManager;

    private final static int TOTAL_LEVELS = 9;

    public LevelHandler() {
        observers = new ArrayList<>();
        levelSelectPageManager = new LevelSelectPageManager(TOTAL_LEVELS);
        gameStateManager = new GameStateManager();

        // Temporary due to lack of save system
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

        movableBlocks = new ArrayList<>();
        enemies = new ArrayList<>();
        blocks = new ArrayList<>();
        powerUps = new ArrayList<>();
        
        setCurrentLevelNumber(1); 
    }

    public int getTotalLevels(){
        return TOTAL_LEVELS;
    }

    public int getCurrentLevelSelectPage(){
        return levelSelectPageManager.getCurrentPage();
    }

    public void nextLevelSelectPage() {
        levelSelectPageManager.nextPage();
    }

    public void previousLevelSelectPage() {
        levelSelectPageManager.previousPage();
    }

    public int getLevelHighScore(int levelNumber){
        return statsManager.getStats(levelNumber).getScore();
    }

    public GameState getGameState() {
        return gameStateManager.getGameState();
    }

    public int getCurrentLevelNumber() {
        return this.currentLevelNumber;
    }

    public void setCurrentLevelNumber(int levelNumber) {
        if(levelNumber > 0 && levelNumber < TOTAL_LEVELS + 1){
            this.currentLevelNumber = levelNumber;
        }
    }

    public int getCurrentScore() {
        return statsManager.getScore();
    }

    public int getCurrentAttempts() {
        return statsManager.getLevelAttempts();
    }

    // collision checkers
    private void checkIfPlayerAtFlag() {
        if (player.collidesWith(goalFlag)) {
            if(getLevelHighScore(currentLevelNumber) < getCurrentScore()){
                statsManager.recordStats(currentLevelNumber, new Stats(getCurrentScore()));
            }

            currentLevelNumber += 1;

            if(currentLevelNumber > TOTAL_LEVELS){
                goToMainMenu();
                currentLevelNumber = 1;
            }
            else{
                startGame();
                setLevel(currentLevelNumber);
            }

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
            statsManager.incrementLevelAttempts();
        }
    }

    public void updateEnemies() {
        for (Enemy enemy : enemies) {
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
        setLevel(currentLevelNumber);

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
        setLevel(currentLevelNumber);

        statsManager.resetScore();
        gameStateManager.togglePause();

        notifyObservers();
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

    private void setLevel(int levelNumber) {
        enemies.clear();
        blocks.clear();
        powerUps.clear();
        movableBlocks.clear();
        currentLevel = LevelFactory.createLevel(levelNumber);
        
        setCurrentLevelNumber(levelNumber);

        for (int i = 0; i < currentLevel.getHeight(); i++) {
            for (int j = 0; j < currentLevel.getWidth(); j++) {
                Metadata metadata = currentLevel.getMetadata(new Tuple(j, i));
                if (acceptedEnemyTypes.contains(currentLevel.getLevelTile(i, j))) {
                    Enemy newEnemy = EnemyFactory.createEnemyAt(currentLevel.getLevelTile(i, j), j * 16, i * 16,
                            metadata);
                    addEnemy(newEnemy);

                } else if (acceptedBlockTypes.contains(currentLevel.getLevelTile(i, j))) {
                    Block newBlock = BlockFactory.createBlockAt(currentLevel.getLevelTile(i, j), j * 16, i * 16,
                            metadata);
                    addBlock(newBlock);

                    if (newBlock instanceof MovableBlock) {
                        movableBlocks.add((MovableBlock) newBlock);
                    }

                } else if (acceptedPowerUpTypes.contains(currentLevel.getLevelTile(i, j))) {
                    PowerUp newPowerUp = PowerUpFactory.createPowerUpPickUpAt(currentLevel.getLevelTile(i, j), j * 16,
                            i * 16);
         
                    powerUps.add(newPowerUp);

                } else if (currentLevel.getLevelTile(i, j) == GameObjectType.PLAYER____) {
                    // The grid uses /16 of the actual size
          
                    player = new Player(j * 16, i * 16, getWidth() * 16, getHeight() * 16);

                } else if (currentLevel.getLevelTile(i, j) == GameObjectType.GOAL______) {
                    // will only reset if there is a new flag on next level.
                    goalFlag = new Flag(j * 16, i * 16);
                }
            }
        }
    }

    // is actually level height
    public int getHeight() {
        return currentLevel.getHeight();
        // return currentLevel.getWidth();
    }
    // is actually level width
    public int getWidth() {
        return currentLevel.getWidth();
        //return currentLevel.getHeight();
    }

    public long getElapsedTime() {
        return statsManager.getElapsedTime();
    }

    public void update() {
        moveMovableBlocks();
        player.update();

        checkIfPlayerAtFlag();
        checkIfPlayerCollidesWithBlocks();
        checkIfPlayerCollidesWithEnemies();
        checkIfPlayerCollidesWithPowerUp();
        checkIfPlayerIsDead();

        checkIfFlyingEnemyCollidesWithBlocks();

        checkIfPowerUpsCollidesWithEnemies();
        checkIfPowerUpsCollidesWithBlocks();

        updateProjectilePositions();
        removeDeadEntities();
        updateEnemies();


        notifyObservers();
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