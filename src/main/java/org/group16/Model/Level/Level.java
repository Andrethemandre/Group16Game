package org.group16.Model.Level;

import java.util.ArrayList;
import java.util.Collection;

import org.group16.Model.GameObjects.GameObject;
import org.group16.Model.GameObjects.Blocks.Block;
import org.group16.Model.GameObjects.Enemy.Enemy;
import org.group16.Model.GameObjects.Player.Player;

public abstract class Level {
    private Player player;
    private Collection<Enemy> enemies;
    private Collection<Block> blocks;
    private boolean playerIsAtFlag;
    private GameObject[][] grid;

    // width and height depending on how big the level is 
    public static final int WIDTH = 45;
    public static final int HEIGHT = 30;

    public Level(){
        grid = new GameObject[WIDTH][HEIGHT];
        player = new Player();
        enemies = new ArrayList<>();
        blocks = new ArrayList<>();
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
