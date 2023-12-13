package org.group16.Model.LevelHandling;

import java.util.HashMap;
import java.util.Map;

public class StatsManager {
    private static final int SCORE_LIMIT = 9999;
    private Map<Integer,LevelStats> recordedLevelStats;

    private long pauseStartTime;
    private long totalPauseTime;

    private int levelAttempts;
    private long levelStartTime;

    private int spearPowerUpPicked;
    private int freezePowerUpPicked;

    private int spearPowerUpsKills;
    private int freezePowerUpsFroze;

    private int basicEnemiesDefeated;
    private int flyingEnemiesDefeated;

    private final static int BASIC_ENEMY_SCORE = 50;
    private final static int FLYING_ENEMY_SCORE = 100;
    private final static int SPEAR_POWERUP_SCORE = 50;
    private final static int FREEZE_POWERUP_SCORE = 25;

    private final static int GOAL_SCORE = 1000;
    private final static int ATTEMPTS_SCORE = 50;

    StatsManager() {
        this.recordedLevelStats = new HashMap<>();
        this.levelAttempts = 0;

        this.basicEnemiesDefeated = 0;
        this.flyingEnemiesDefeated = 0;

        this.spearPowerUpsKills = 0;
        this.freezePowerUpsFroze = 0;
    }

    public void incrementSpearPowerUpPicked() {
        spearPowerUpPicked++;
    }

    public void incrementFreezePowerUpPicked() {
        freezePowerUpPicked++;
    }

    public void incrementLevelAttempts() {
        levelAttempts++;
    }

    public void incrementBasicEnemiesDefeated() {
        basicEnemiesDefeated++;
    }

    public void incrementFlyingEnemiesDefeated() {
        flyingEnemiesDefeated++;
    }

    public void incrementSpearPowerUpsKills() {
        spearPowerUpsKills++;
    }

    public void incrementFreezePowerUpsFroze() {
        freezePowerUpsFroze++;
    }

    public int getLevelAttempts() {
        return levelAttempts;
    }

    public int getPowerUpsPicked() {
        return spearPowerUpPicked + freezePowerUpPicked;
    }

    public int getEnemiesDefeated() {
        return basicEnemiesDefeated + flyingEnemiesDefeated;
    }

    public void recordStats(int levelNumber, LevelStats stats) {
        // If the level has already been played, update the recorded stats

        if (recordedLevelStats.containsKey(levelNumber)) {
            recordedLevelStats.put(levelNumber, new LevelStats(calculateEndScore(), getEnemiesDefeated(), getPowerUpsPicked(), getElapsedTime()));
        } else {
            recordedLevelStats.put(levelNumber, stats);
        }
    }

    public void resetStats() {
        for (Integer levelNumber : recordedLevelStats.keySet()) {
            recordedLevelStats.put(levelNumber, new LevelStats(0, 0, 0, 0));
        }
    }

    public LevelStats getStats(int levelNumber) {
        LevelStats levelStats = null;
        if (recordedLevelStats.containsKey(levelNumber)) {
            levelStats = recordedLevelStats.get(levelNumber);
        }

        return levelStats;
    }

    private double calculateTimeBonusMultiplier() {
        double decayRate = 0.05; // Adjust this value to change how quickly the multiplier decreases
    
        // Calculate the number of seconds that have passed
        int secondsPassed = (int) ((System.currentTimeMillis() - levelStartTime - totalPauseTime) / 1000);
    
        // Calculate the time bonus multiplier using an exponential decay function
        double timeBonusMultiplier = Math.exp(-decayRate * secondsPassed);
    
        return timeBonusMultiplier;
    }

    private double calculateAttemptsMultiplier() {
        double penaltyPerAttempt = 0.05; // Adjust this value to change how much the multiplier decreases
    
        // Calculate the attempts multiplier
        double attemptsMultiplier = Math.max(0, 1 - penaltyPerAttempt * levelAttempts);
        return attemptsMultiplier;
    }

    public void resetScore() {
        totalPauseTime = 0;
        pauseStartTime = 0;
        levelAttempts = 0;
        levelStartTime = System.currentTimeMillis();

        basicEnemiesDefeated = 0;
        flyingEnemiesDefeated = 0;

        spearPowerUpsKills = 0;
        freezePowerUpsFroze = 0;
    }

    private int calculateEndScore(){
        // Calculate the end score for when getting to goal
        int baseScore = GOAL_SCORE + getCurrentScore();

        int timeBonus = (int) (baseScore *  calculateTimeBonusMultiplier()); 
        int attemptsPenalty = ATTEMPTS_SCORE * (int) calculateAttemptsMultiplier();

        int totalScore = baseScore - attemptsPenalty + timeBonus;

        if (totalScore > SCORE_LIMIT) {
            totalScore = SCORE_LIMIT;
        }
        else if(totalScore < 0){
            totalScore = 0;
        }

        return totalScore;
    }

    public int getEndScore() {
        int totalScore = calculateEndScore();

        return totalScore;
    }

    public int getCurrentScore(){
        int score = calculateCurrentScore();
        if (score > SCORE_LIMIT) {
            score = SCORE_LIMIT;
        }
        else if(score < 0){
            score = 0;
        }

        return score;
    }

    private int calculateCurrentScore() {
        int currentScore = 0;
        currentScore = basicEnemiesDefeated * BASIC_ENEMY_SCORE + flyingEnemiesDefeated * FLYING_ENEMY_SCORE + spearPowerUpsKills * SPEAR_POWERUP_SCORE + freezePowerUpsFroze * FREEZE_POWERUP_SCORE;
        
        if (currentScore > SCORE_LIMIT) {
            currentScore = SCORE_LIMIT;
        }
        else if(currentScore < 0){
            currentScore = 0;
        }

        return currentScore;
    }

    public void setPauseStartTime(){
        pauseStartTime = System.currentTimeMillis();
    }

    public void setTotalPauseTime(){
        totalPauseTime += System.currentTimeMillis() - pauseStartTime;
    }

    public long getElapsedTime() {
        return System.currentTimeMillis() - levelStartTime - totalPauseTime;
    }
}