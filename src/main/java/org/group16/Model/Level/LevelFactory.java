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
            case 3:
                return new Level3();
            case 7:
                return new Level7();
            case 8:
                return new Level8();
            default:
                throw new IllegalArgumentException("Level is not supported");
        }
    }
}
