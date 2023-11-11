package org.group16.Model.Level;

import java.util.ArrayList;
import java.util.Collection;

import org.group16.Model.GameObjects.GameObject;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.Blocks.Block;
import org.group16.Model.GameObjects.Enemy.Enemy;
import org.group16.Model.GameObjects.Player.Player;

public class LevelHandler {
    private Player player;
    private Collection<Enemy> enemies;
    private Collection<Block> blocks;
    private boolean playerIsAtFlag;
    private GameObjectType[][] grid;
    private LevelFactory levelFactory;
    private Level currentLevel;

    // width and height depending on how big the level is 
    public final int WIDTH = 45;
    public final int HEIGHT = 30;

    public LevelHandler(){
        grid = new GameObjectType[WIDTH][HEIGHT];
        levelFactory = new LevelFactory();
        enemies = new ArrayList<>();
        blocks = new ArrayList<>();
    }
    
    public void setLevel(int levelNumber){
        currentLevel = levelFactory.createLevel(levelNumber);
        grid = currentLevel.getLevel();
        //forloopar och annat
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
}