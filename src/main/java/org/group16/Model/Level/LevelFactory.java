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
                return new ThirdLevel();
            case 4:
                return new FourthLevel();
            case 5:
                return new FifthLevel();
            case 6:
                return new SixthLevel();   
            case 7:
                return new SeventhLevel();
            case 8:
                return new EighthLevel();
            default:
                throw new IllegalArgumentException("Level is not supported");

        }
    }
}
