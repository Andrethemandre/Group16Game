package org.group16.Model.Level;

import org.group16.Model.GameObjects.Blocks.Block;
import org.group16.Model.GameObjects.Enemy.Enemy;
import org.group16.Model.GameObjects.Player.Player;

public class Level {
    private Player player;
    private Enemy[] enemies = {};
    private Block[] blocks = {};
    private boolean playerIsAtFlag;
    private int currentLevel = 0;

    
    public void addEnemy(Enemy enemy){
        //todo
    }

    public void addBlock(Block block){
        //todo
    }

    public Player getPlayer(){
        return this.player;
    }

    public Enemy[] getEnemies(){
        return this.enemies;
    }

     public Block[] getBlocks(){
        return this.blocks;
    }

    public void setLevel(int goToLevel){
        //todo
    }









}
