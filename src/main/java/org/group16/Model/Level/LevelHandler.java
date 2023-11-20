package org.group16.Model.Level;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Arrays;

import org.group16.Model.GameObjects.IGameObject;
import org.group16.Model.GameObjects.PowerUp;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.Blocks.Block;
import org.group16.Model.GameObjects.Blocks.BlockFactory;
import org.group16.Model.GameObjects.Enemy.Enemy;
import org.group16.Model.GameObjects.Enemy.EnemyFactory;
import org.group16.Model.GameObjects.Flag.Flag;
import org.group16.Model.GameObjects.Player.Player;
import org.group16.Model.Observers.GameObserver;

public class LevelHandler {
    private Player player;
    private Flag goalFlag;
    private Collection<Enemy> enemies;
    private Collection<Block> blocks;
    private Collection<PowerUp> powerUps;
    private boolean playerIsAtFlag;
    private IGameObject[][] grid;
    private Collection<GameObjectType> acceptedEnemyTypes = Arrays.asList(new GameObjectType[]{GameObjectType.BASIC_____, GameObjectType.SPIKE_____});
    private Collection<GameObjectType> acceptedBlockTypes = Arrays.asList(new GameObjectType[]{GameObjectType.STATIONARY});
    private Collection<GameObserver> observers;
    private int currentLevelNumber;

    private Level currentLevel;

    // width and height depending on how big the level is 

    public LevelHandler(){
        observers = new ArrayList<>();
        setLevel(1);
    }


    // collision checkers
    public void checkIfPlayerAtFlag(){
        if(player.checkCollision(goalFlag)){
            setLevel(2);
        }
    }

    public void checkIfPlayerCollidesWithBlocks(){
        for(Block block : blocks){
            //if(player.checkCollision(block) && player.isFalling()){   
               // player.stopFalling(block.getY() - player.getHeight());
            //}

            player.collision(block);
        }
    }

    public void checkIfPlayerCollidiesWithEnemies(){
        for(Enemy enemy : enemies){
            if(player.checkCollision(enemy)){
                enemy.dealDamage(player); 
                if (player.isDead()){
                    setLevel(currentLevelNumber);
                }

            }
        }
    }

    public void checkIfPlayerCollidesWithPowerUp(){
        PowerUp powerUptoremove = null;
        if (powerUps!= null){
            System.out.println(player.getHasPowerUp());

            if (!player.getHasPowerUp()){
                for (PowerUp powerUp : powerUps){
                    if(player.checkCollision(powerUp)){
                        if (!powerUp.getMovable()){
                        powerUptoremove = powerUp;
                        player.setHasPowerUp(true); 
                        }  
                    }
                }
                powerUps.remove(powerUptoremove);
                
            }
        }
    }


    public void setLevel(int levelNumber){
        enemies = new ArrayList<>();
        blocks = new ArrayList<>();
        powerUps = new ArrayList<>();
        enemies.clear();
        blocks.clear();
        powerUps.clear();

        currentLevel = LevelFactory.createLevel(levelNumber);
        currentLevelNumber = levelNumber;
        grid = new IGameObject[currentLevel.getWidth()][currentLevel.getHeight()];
        for (int i = 0; i < currentLevel.getHeight(); i++) {
            for (int j = 0; j < currentLevel.getWidth(); j++) {
                if (acceptedEnemyTypes.contains(currentLevel.getLevelTile(i, j))) {
                    Enemy newEnemy = EnemyFactory.createEnemyAt(currentLevel.getLevelTile(i, j), j*16, i*16);
                    addEnemy(newEnemy);
                    grid[j][i] = newEnemy;

                } else if (acceptedBlockTypes.contains(currentLevel.getLevelTile(i, j))) {
                    Block newBlock = BlockFactory.createBlockAt(currentLevel.getLevelTile(i, j), j*16, i*16);
                    addBlock(newBlock);
                    grid[j][i] = newBlock;

                } else if (currentLevel.getLevelTile(i, j) == GameObjectType.PLAYER____) {
                    // The grid uses /16 of the actual size
                    player = new Player(j*16, i*16);
                    grid[j][i] = player;
                } else if (currentLevel.getLevelTile(i, j) == GameObjectType.GOAL______) {
                    // will only reset if there is a new flag on next level. 
                    goalFlag = new Flag(j*16, i*16);
                    grid[j][i] = goalFlag;
                }   else if (currentLevel.getLevelTile(i,j) == GameObjectType.Powerup___){
                        PowerUp powerUp = new PowerUp(j*16,i*16,false,1);
                        this.powerUps.add(powerUp);
                }
            }   
        }
    }

    public void update(){
        player.update();
        checkIfPlayerAtFlag();
        checkIfPlayerCollidesWithBlocks();
        checkIfPlayerCollidiesWithEnemies();
        checkIfPlayerCollidesWithPowerUp();
        updateProjectilePositions();
        for (GameObserver o : observers) {
            o.updateObserver();
        }
    }

    private void updateProjectilePositions() {
        for (PowerUp powerUp: powerUps){
            powerUp.update();
        }
    }


    public void addObserver(GameObserver observer){
        observers.add(observer);
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

    public Flag getGoalFlag() {
        return goalFlag;
    }

    public Collection<Enemy> getEnemies(){
        return this.enemies;
    }

    public Collection<Block> getBlocks(){
        return this.blocks;
    }

     public Collection<PowerUp> getPowerUps(){
        return this.powerUps;
    }

    public IGameObject[][] getGrid(){
        return this.grid;
    }

    public int getWidth() {
        return grid[0].length;
    }

    public int getHeight() {
        return grid.length;
    }

    //är här då levelhandle har power ups listan som jag behöver ändra för att saker ska ritas
    public void usePowerUp (){
        if (player.getHasPowerUp()){
            System.out.println("using powerupp");
            PowerUp powerUp = new PowerUp(player.getX(), player.getY(), true, player.getXDirection());
            powerUps.add(powerUp);
            player.setHasPowerUp(false);
        }
    }
}