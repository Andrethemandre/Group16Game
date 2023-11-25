package org.group16.Model.Level;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Arrays;

import org.group16.Model.GameObjects.IGameObject;
import org.group16.Model.GameObjects.PowerUp;
import org.group16.Model.GameObjects.Spear_Power;
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
import org.group16.Model.Observers.GameObserver;
import org.group16.Model.GameObjects.Movable;

public class LevelHandler {
    private Player player;
    private Flag goalFlag;
    private Collection<Enemy> enemies;
    private Collection<Block> blocks;
    private Collection<PowerUp> powerUps;
    private boolean playerIsAtFlag;
    private IGameObject[][] grid;
    private Collection<GameObjectType> acceptedEnemyTypes = Arrays
            .asList(new GameObjectType[] { GameObjectType.BASIC_____, GameObjectType.SPIKE_____ });
    private Collection<GameObjectType> acceptedBlockTypes = Arrays
            .asList(new GameObjectType[] { GameObjectType.STATIONARY, GameObjectType.MOVABLE___ });
    private Collection<GameObserver> observers;
    private int currentLevelNumber;
    private int score = 0;
    private Level currentLevel;
    private long levelStartTime;
    private int levelAttempts = 0;
    private static int SCORE_LIMIT = 9999;
    private GameState gameState;
    // width and height depending on how big the level is

    public LevelHandler() {
        observers = new ArrayList<>();
        gameState = GameState.START;
        setLevel(1);

      
        // directions of blocks on level 1
        setxandydirectionofmovableblocks(20, 0);

        // Schedule the movable blocks movement at fixed intervals
    }
    public GameState getGameState() {
        return gameState;
    }

    private void setGameState(GameState gameState) {
        this.gameState = gameState;
    }   

    public int getCurrentLevelNumber(){
        return this.currentLevelNumber;
    }

    private void addScore(int points){
        this.score += points;
    }

    private void calculateScore() {
        //int baseScore = 9999;
        int pointsPerSecond = 100; // Number of points per second

        // Calculate the number of seconds that have passed
        int secondsPassed = (int) ((System.currentTimeMillis() - levelStartTime) / 1000);

        // Add points for each second that has passed
        int timeBonus = secondsPassed * pointsPerSecond;

        // Some points deducted for each attempt
        int attemptsPenalty = levelAttempts * 500; 
    
        int totalScore = SCORE_LIMIT - timeBonus - attemptsPenalty;
        addScore(totalScore - score);

        if (score < -SCORE_LIMIT) {
            score = -SCORE_LIMIT;
        }
        else if (score > SCORE_LIMIT) {
            score = SCORE_LIMIT;
        }
    }

    public int getScore(){
        calculateScore();
        return this.score;
    }

    public int getCurrentAttempts(){
        return this.levelAttempts;
    }

    // collision checkers
    public void checkIfPlayerAtFlag(){
        if(player.collidesWith(goalFlag)){
            setLevel(2);
        }
    }

    public void checkIfPlayerCollidesWithBlocks(){
        for (Block block : blocks){
            player.collision(block);
        }
    }

    public void checkIfPlayerCollidiesWithEnemies() {

        for (Enemy enemy : enemies) {
            if (player.collidesWith(enemy)) {
                enemy.dealDamage(player);
            }
        }
    }

    public void checkIfPlayerCollidesWithPowerUp(){
        PowerUp powerUptoremove = null;
        if (powerUps!= null){
            if (player.getHasPowerUp() == null){
                for (PowerUp powerUp : powerUps){
                    if(player.collidesWith(powerUp)){
                        System.out.println("touched power");
                        if (!powerUp.getMovable()){
                        powerUptoremove = powerUp;
                        player.setHasPowerUp(powerUp.getType());
                        }
                    }
                }
                powerUps.remove(powerUptoremove);

            }
        }
    }

    public void checkIfPowerUpsCollidesWithEnemies (){
        for (PowerUp powerUp : powerUps){
            for (Enemy enemy : enemies){
                if (powerUp.collidesWith(enemy)){
                    powerUp.triggerPowerUp(enemy);
                }
            }
        }
    }

    private void checkIfPlayerIsDead() {
        if (player.isDead()){
            setLevel(currentLevelNumber);
            this.levelAttempts++;
        }
    }

    public void updateEnemies(){
        for (Enemy enemy : enemies) {
            enemy.update();
        }
    }

    private void setLevel(int levelNumber) {
        gameState = GameState.PLAYING;
        if (levelNumber != currentLevelNumber) {
            levelAttempts = 0;
            score = 0;
            levelStartTime = System.currentTimeMillis();
        }

        enemies = new ArrayList<>();
        blocks = new ArrayList<>();
        powerUps = new ArrayList<>();
        enemies.clear();
        blocks.clear();
        powerUps.clear();
        currentLevel = LevelFactory.createLevel(levelNumber);

        // GameStats
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
                    player = new Player(j*16, i*16, getHeight()*16, getWidth()*16);
                    grid[j][i] = player;
                } else if (currentLevel.getLevelTile(i, j) == GameObjectType.GOAL______) {
                    // will only reset if there is a new flag on next level.
                    goalFlag = new Flag(j * 16, i * 16);
                    grid[j][i] = goalFlag;
                }   else if (currentLevel.getLevelTile(i,j) == GameObjectType.SPEAR_____){
                        PowerUp powerUp = new Spear_Power(j*16,i*16,false, Direction.RIGHT);
                        this.powerUps.add(powerUp);
                }
            }
        }
    }

    public long getElapsedTime() {
        return System.currentTimeMillis() - levelStartTime;
    }
    public void update() {
        moveMovableBlocks();
        player.update();

        checkIfPlayerAtFlag();
        checkIfPlayerCollidesWithBlocks();
        checkIfPlayerCollidiesWithEnemies();
        checkIfPlayerCollidesWithPowerUp();
        checkIfPowerUpsCollidesWithEnemies();

        updateProjectilePositions();
        removeDeadEntities();
        updateEnemies();

        for (GameObserver o : observers) {
            o.updateObserver();
        }
        checkIfPlayerIsDead();
    }


    private void updateProjectilePositions() {
        for (PowerUp powerUp: powerUps){
            powerUp.update();
        }
    }

    private void removeDeadEntities(){
        removeDeadEnemy();
        removeUsedPowerups();
    }

    private void removeDeadEnemy(){
        Enemy enemyToRemove = null;
        for (Enemy enemy : enemies){
            if (enemy.getIsDead()){
                enemyToRemove = enemy;
            }
        }
        if (enemyToRemove != null){
            enemies.remove(enemyToRemove);
        }
    }

    private void removeUsedPowerups(){
        PowerUp powerUpToRemove = null;
        for (PowerUp powerUp : powerUps){
            if (powerUp.getRemove()){
                powerUpToRemove = powerUp;
            }
        }
        if (powerUpToRemove != null){
            powerUps.remove(powerUpToRemove);
        }
    }



    public void addObserver(GameObserver observer){
        observers.add(observer);
    }

    public void addEnemy(Enemy enemy){
        this.enemies.add(enemy);
    }

    public void removeEnemy (Enemy enemy){
        this.enemies.remove(enemy);
    }

    public void addBlock(Block block){
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

    public IGameObject[][] getGrid(){
        return this.grid;
    }

    public int getWidth() {
        return grid[0].length;
    }

    public int getHeight() {
        return grid.length;
    }

    public GameState getPauseState() {
        return this.gameState;
    }

    public void togglePause() {
        GameState currentGameState = getGameState();
        if(currentGameState == GameState.PLAYING){
            setGameState(GameState.PAUSED);
        }
        else if(currentGameState == GameState.PAUSED) {
            setGameState(GameState.PLAYING);
        }

        for (GameObserver o : observers) {
            o.updateObserver();
        }
    }

    // is here because levelHandler has the power ups list that I need to change for things to be drawn
    public void usePowerUp() {
        if (player.getHasPowerUp() == GameObjectType.SPEAR_____){
            PowerUp powerUp = new Spear_Power(player.getX(), player.getY(), true, player.getDirection());
            powerUps.add(powerUp);
            player.setHasPowerUp(null);
        }
    }

    public void moveMovableBlocks() {
        for (Block block : blocks) {
            if (block instanceof MovableBlock) {
                ((MovableBlock) block).move();
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