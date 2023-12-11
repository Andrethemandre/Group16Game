package org.group16.Model.Level;

public class LevelStats {
    private int score;
    private int enemiesDefeated;
    private int powerUpsUsed;
    private long timePlayed;

    public LevelStats(int score, int enemiesDefeated, int powerUpsUsed, long timePlayed) {
        this.score = score;
        this.enemiesDefeated = enemiesDefeated;
        this.powerUpsUsed = powerUpsUsed;
        this.timePlayed = timePlayed;
    }

    public int getScore() {
        return score;
    }

    public int getEnemiesDefeated() {
        return enemiesDefeated;
    }

    public int getPowerUpsUsed() {
        return powerUpsUsed;
    }

    public long getTimePlayed() {
        return timePlayed;
    } 
}
