package org.group16.Model.Level;

import static org.group16.Model.GameObjects.GameObjectType.MOVABLE___;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Arrays;

import org.group16.Model.GameObjects.IGameObject;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.Blocks.Block;
import org.group16.Model.GameObjects.Blocks.BlockFactory;
import org.group16.Model.GameObjects.Blocks.MovableBlock;
import org.group16.Model.GameObjects.Enemy.Enemy;
import org.group16.Model.GameObjects.Enemy.EnemyFactory;
import org.group16.Model.GameObjects.Flag.Flag;
import org.group16.Model.GameObjects.Player.Player;
import org.group16.Model.Observers.GameObserver;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class LevelHandler {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private int MOVABLE_BLOCKS_INTERVAL_SECONDS = 2; // Adjust the interval as needed
    private Player player;
    private Flag goalFlag;
    private Collection<Enemy> enemies;
    private Collection<Block> blocks;
    private boolean playerIsAtFlag;
    private IGameObject[][] grid;
    private Collection<GameObjectType> acceptedEnemyTypes = Arrays
            .asList(new GameObjectType[] { GameObjectType.BASIC_____, GameObjectType.SPIKE_____ });
    private Collection<GameObjectType> acceptedBlockTypes = Arrays
            .asList(new GameObjectType[] { GameObjectType.STATIONARY, GameObjectType.MOVABLE___ });
    private Collection<GameObserver> observers;
    private int currentLevelNumber;

    private Level currentLevel;

    // width and height depending on how big the level is

    public LevelHandler() {
        observers = new ArrayList<>();
        setLevel(1);
        setxandydirectionofmovableblocks(20, 0);

        // Schedule the movable blocks movement at fixed intervals

        // scheduler.scheduleAtFixedRate(this::moveMovableBlocks, 0,
        // MOVABLE_BLOCKS_INTERVAL_SECONDS, TimeUnit.SECONDS);
    }

    // collision checkers
    public void checkIfPlayerAtFlag() {
        if (player.checkCollision(goalFlag)) {
            setLevel(2);
        }
    }

    public void checkIfPlayerCollidesWithBlocks() {
        for (Block block : blocks) {
            // if(player.checkCollision(block) && player.isFalling()){
            // player.stopFalling(block.getY() - player.getHeight());
            // }

            player.collision(block);
        }
    }

    public void checkIfPlayerCollidiesWithEnemies() {

        for (Enemy enemy : enemies) {
            if (player.checkCollision(enemy)) {
                enemy.dealDamage(player);
                if (player.isDead()) {
                    setLevel(currentLevelNumber);
                }

            }
        }
    }

    public void setLevel(int levelNumber) {
        enemies = new ArrayList<>();
        blocks = new ArrayList<>();
        enemies.clear();
        blocks.clear();

        currentLevel = LevelFactory.createLevel(levelNumber);
        currentLevelNumber = levelNumber;
        grid = new IGameObject[currentLevel.getWidth()][currentLevel.getHeight()];
        for (int i = 0; i < currentLevel.getHeight(); i++) {
            for (int j = 0; j < currentLevel.getWidth(); j++) {
                if (acceptedEnemyTypes.contains(currentLevel.getLevelTile(i, j))) {
                    Enemy newEnemy = EnemyFactory.createEnemyAt(currentLevel.getLevelTile(i, j), j * 16, i * 16);
                    addEnemy(newEnemy);
                    grid[j][i] = newEnemy;

                } else if (acceptedBlockTypes.contains(currentLevel.getLevelTile(i, j))) {
                    Block newBlock = BlockFactory.createBlockAt(currentLevel.getLevelTile(i, j), j * 16, i * 16);
                    addBlock(newBlock);
                    grid[j][i] = newBlock;

                } else if (currentLevel.getLevelTile(i, j) == GameObjectType.PLAYER____) {
                    // The grid uses /16 of the actual size
                    player = new Player(j * 16, i * 16);
                    grid[j][i] = player;
                } else if (currentLevel.getLevelTile(i, j) == GameObjectType.GOAL______) {
                    // will only reset if there is a new flag on next level.
                    goalFlag = new Flag(j * 16, i * 16);
                    grid[j][i] = goalFlag;
                }
            }
        }
    }

    public void update() {
        moveMovableBlocks();
        player.update();
        checkIfPlayerAtFlag();
        checkIfPlayerCollidesWithBlocks();
        checkIfPlayerCollidiesWithEnemies();
        for (GameObserver o : observers) {
            o.updateObserver();
        }
    }

    public void addObserver(GameObserver observer) {
        observers.add(observer);
    }

    public void addEnemy(Enemy enemy) {
        this.enemies.add(enemy);
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

    public IGameObject[][] getGrid() {
        return this.grid;
    }

    public int getWidth() {
        return grid[0].length;
    }

    public int getHeight() {
        return grid.length;
    }

    public void moveMovableBlocks() {
        for (Block block : blocks) {
            if (block instanceof MovableBlock) {
                ((MovableBlock) block).move();
                System.out.println("ginger");
            }
        }
    }

    public void setxandydirectionofmovableblocks(int x, int y) {
        for (Block block : blocks) {
            if (block instanceof MovableBlock) {
                ((MovableBlock) block).sethorisontalMovement(x);
                ((MovableBlock) block).setverticalMovement(y);
            }
        }
    }
}