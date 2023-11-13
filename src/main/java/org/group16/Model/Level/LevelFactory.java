package org.group16.Model.Level;

public class LevelFactory {
    public static Level createLevel(int levelNumber) {
        switch (levelNumber) {
            case 1:
                return new FirstLevel();
            case 2:
                return new SecondLevel();
            default:
                throw new IllegalArgumentException("Level is not supported");
        }
    }
}