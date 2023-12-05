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
            case 13:
                return new TeleportTestLevel();
            default:
                throw new IllegalArgumentException("Level is not supported");
        }
    }
}
