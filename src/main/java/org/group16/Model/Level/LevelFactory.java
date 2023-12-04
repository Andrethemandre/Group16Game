package org.group16.Model.Level;

public class LevelFactory {
    public static Level createLevel(int levelNumber) {
        switch (levelNumber) {
            // Not used.
            case -1:
                return new TestLevel();
            case 1:
                return new FirstLevel();
            case 2:
                return new SecondLevel();
            case 6:
                return new SixthLevel();
            default:
                throw new IllegalArgumentException("Level is not supported");

        }
    }
}
