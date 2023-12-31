package org.group16.Model.Level;

public class LevelFactory {
    private static final int TOTAL_LEVELS = 12;

    public static Level createLevel(int levelNumber) {
        switch (levelNumber) {
            case -2:
                return new TeleportTestLevel();
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
            case 9:
                return new NinthLevel();
            case 10:
                return new TenthLevel();
            case 11:
                return new EleventhLevel();
            case 12:
                return new TwelfthLevel();
            default:
                throw new IllegalArgumentException("Level is not supported");

        }
    }

    public static int getTotalLevels() {
        return TOTAL_LEVELS;
    }
}
