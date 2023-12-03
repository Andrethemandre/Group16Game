package org.group16.Model.Level;

public class ScoreManager {
    private int score;

    public ScoreManager() {
        score = 0;
    }

    public void addPoints(int points) {
        score += points;
    }

    public void subtractPoints(int points) {
        score -= points;
    }

    public void resetScore() {
        score = 0;
    }

    public int getScore() {
        return score;
    }
}