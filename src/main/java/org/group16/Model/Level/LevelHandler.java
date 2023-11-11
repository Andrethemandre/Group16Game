package org.group16.Model.Level;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Arrays;

import org.group16.Model.GameObjects.GameObject;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.Blocks.Block;
import org.group16.Model.GameObjects.Blocks.BlockFactory;
import org.group16.Model.GameObjects.Enemy.Enemy;
import org.group16.Model.GameObjects.Enemy.EnemyFactory;
import org.group16.Model.GameObjects.Flag.Flag;
import org.group16.Model.GameObjects.Player.Player;

public class LevelHandler {
    private Player player;
    private Flag goalFlag;
    private Collection<Enemy> enemies;
    private Collection<Block> blocks;
    private boolean playerIsAtFlag;
    private GameObject[][] grid;
    private Collection<GameObjectType> acceptedEnemyTypes = Arrays.asList(new GameObjectType[]{GameObjectType.BASIC_____, GameObjectType.SPIKE_____});
    private Collection<GameObjectType> acceptedBlockTypes = Arrays.asList(new GameObjectType[]{GameObjectType.STATIONARY});

    private Level currentLevel;

    // width and height depending on how big the level is 

    public LevelHandler(){
        setLevel(1);
    }
    
    public void setLevel(int levelNumber){
        enemies = new ArrayList<>();
        blocks = new ArrayList<>();
        enemies.clear();
        blocks.clear();


        currentLevel = LevelFactory.createLevel(levelNumber);
        grid = new GameObject[currentLevel.getWidth()][currentLevel.getHeight()];
        for (int i = 0; i < currentLevel.getWidth(); i++) {
            for (int j = 0; i < currentLevel.getHeight(); i++) {
                if (acceptedEnemyTypes.contains(currentLevel.getLevelTile(i, j))) {
                    Enemy newEnemy = EnemyFactory.createEnemy(currentLevel.getLevelTile(i, j));
                    addEnemy(newEnemy);
                    grid[i][j] = newEnemy;

                } else if (acceptedBlockTypes.contains(currentLevel.getLevelTile(i, j))) {
                    Block newBlock = BlockFactory.createBlock(currentLevel.getLevelTile(i, j));
                    addBlock(newBlock);
                    grid[i][j] = BlockFactory.createBlock(currentLevel.getLevelTile(i, j));

                } else if (currentLevel.getLevelTile(i, j) == GameObjectType.PLAYER____) {
                    player = new Player();
                    grid[i][j] = player;
                } else if (currentLevel.getLevelTile(i, j) == GameObjectType.GOAL______) {
                    goalFlag = new Flag();
                }
            }   
        }
    }

    public void addEnemy(Enemy enemy){
        this.enemies.add(enemy);
    }

    public void addBlock(Block block){
        this.blocks.add(block);
    }

    public Player getPlayer(){
        return this.player;
    }

    public Collection<Enemy> getEnemies(){
        return this.enemies;
    }

    public Collection<Block> getBlocks(){
        return this.blocks;
    }

    public GameObject[][] getGrid(){
        return this.grid;
    }

    public int getWidth() {
        return grid[0].length;
    }

    public int getHeight() {
        return grid.length;
    }
}