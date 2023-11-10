package src.main.java.org.group16.Model.Level;

import org.group16.Model.GameObjects.Enemy.Enemy;
import org.group16.Model.GameObjects.Platforms.Block;
import org.group16.Model.GameObjects.Player.Player;

public class Level {
    private Player player;
    private enemies = new Enemy[] {};
    private blocks = new Block[]{};
    private boolean playerIsAtFlag;
    private int currentLevel = 0;

    
    public void addEnemy(Enemy enemy){
        //todo
    }

    public void addBlock(Block block){
        //todo
    }

    public void getPlayer(){
        return this.player;
    }

    public void getEnemies(){
        return this.enemies;
    }

     public void getBlocks(){
        return this.blocks;
    }

    public void setLevel(int goToLevel){
        //todo
    }









}
