package org.group16.Model.Level;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Arrays;

import org.group16.Model.GameObjects.IGameObject;
import org.group16.Model.GameObjects.GameObjectType;
import org.group16.Model.GameObjects.GameState;
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
    private boolean playerIsAtFlag;
    private IGameObject[][] grid;
    private Collection<GameObjectType> acceptedEnemyTypes = Arrays.asList(new GameObjectType[]{GameObjectType.BASIC_____, GameObjectType.SPIKE_____});
    private Collection<GameObjectType> acceptedBlockTypes = Arrays.asList(new GameObjectType[]{GameObjectType.STATIONARY});
    private Collection<GameObserver> observers;
    private int currentLevelNumber;
    private int score = 0;
    private Level currentLevel;
    private long levelStartTime;
    private int levelAttempts = 0;
    private static int SCORE_LIMIT = 9999;

    private GameState gameState;

    public LevelHandler(){
        observers = new ArrayList<>();
        gameState = GameState.START;
        setLevel(1);
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
        if(player.checkCollision(goalFlag)){
            setLevel(2);
        }
    }

    public void checkIfPlayerCollidesWithBlocks(){
        for(Block block : blocks){
            player.collision(block);
        }
    }

    public void checkIfPlayerCollidiesWithEnemies(){
        for(Enemy enemy : enemies){
            if(player.checkCollision(enemy)){
                enemy.dealDamage(player); 
                if (player.isDead()){
                    setLevel(currentLevelNumber);
                    addScore(100);
                    this.levelAttempts++;
                }   
            }
        }
    }

    private void setLevel(int levelNumber){
        gameState = GameState.PLAYING;
        if(levelNumber != currentLevelNumber){
            levelAttempts = 0;
            score = 0;
            levelStartTime = System.currentTimeMillis();
        }

        enemies = new ArrayList<>();
        blocks = new ArrayList<>();
        enemies.clear();
        blocks.clear();
        currentLevel = LevelFactory.createLevel(levelNumber);

        // GameStats
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
                }
            }   
        }
    }

    public long getElapsedTime() {
        return System.currentTimeMillis() - levelStartTime;
    }

    public void update(){
        player.update();
        checkIfPlayerAtFlag();
        checkIfPlayerCollidesWithBlocks();
        checkIfPlayerCollidiesWithEnemies();
        
        for (GameObserver o : observers) {
            o.updateObserver();
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

    public void togglePause(){
        GameState currentGameState = getGameState();
        if(currentGameState == GameState.PLAYING){
            setGameState(GameState.PAUSED);
        }
        else if(currentGameState == GameState.PAUSED){
            setGameState(GameState.PLAYING);
        }

        for (GameObserver o : observers) {
            o.updateObserver();
        }
    }
}