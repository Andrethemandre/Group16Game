package org.group16.Model.Level;

import java.util.HashMap;
import java.util.Map;

public class StatsManager {
    private int score;
    private static final int SCORE_LIMIT = 9999;
    private Map<Integer,Stats> recordedLevelStats;

    private long pauseStartTime;
    private long totalPauseTime;

    private int levelAttempts;
    private long levelStartTime;

    StatsManager() {
        this.recordedLevelStats = new HashMap<>();
        this.score = 0;
        this.levelAttempts = 0;
    }

    public void incrementLevelAttempts() {
        levelAttempts++;
    }

    public int getLevelAttempts() {
        return levelAttempts;
    }

    public void recordStats(int levelNumber, Stats stats) {
        if (recordedLevelStats.containsKey(levelNumber)) {
            recordedLevelStats.put(levelNumber, new Stats(calculateScore()));
        } else {
            recordedLevelStats.put(levelNumber, stats);
        }
    }

    public Stats getStats(int levelNumber) {
        Stats levelStats = null;
        if (recordedLevelStats.containsKey(levelNumber)) {
            levelStats = recordedLevelStats.get(levelNumber);
        }

        return levelStats;
    }

    private int calculateScore() {
        // int baseScore = 9999;
        int pointsPerSecond = 100; // Number of points per second

        // Calculate the number of seconds that have passed
        int secondsPassed = (int) ((System.currentTimeMillis() - levelStartTime - totalPauseTime) / 1000);

        // Add points for each second that has passed
        int timeBonus = secondsPassed * pointsPerSecond;

        // Some points deducted for each attempt
        int attemptsPenalty = levelAttempts * 500;
        int totalScore = SCORE_LIMIT - timeBonus - attemptsPenalty;
        addPoints(totalScore - score);

        if (score < -SCORE_LIMIT) {
            score = -SCORE_LIMIT;
        } else if (score > SCORE_LIMIT) {
            score = SCORE_LIMIT;
        }
        return score;
    }

    private void addPoints(int points) {
        score += points;
    }

    private void subtractPoints(int points) {
        score -= points;
    }

    public void resetScore() {
        totalPauseTime = 0;
        pauseStartTime = 0;
        levelAttempts = 0;
        levelStartTime = System.currentTimeMillis();
        score = 0;
    }

    public int getScore() {
        score = calculateScore();
        return score;
    }
        // if (gameState == GameState.PLAYING) {
        //     // pauseStartTime = System.currentTimeMillis();
        //     gameState = GameState.PAUSED;
        // } else if (gameState == GameState.PAUSED) {
        //    // totalPauseTime += System.currentTimeMillis() - pauseStartTime;
        //     gameState = GameState.PLAYING;
        // }

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