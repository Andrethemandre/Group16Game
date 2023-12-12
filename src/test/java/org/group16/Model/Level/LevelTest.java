package org.group16.Model.Level;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.group16.Model.GameObjects.GameObjectType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class LevelTest {
    static Stream<Level> levelProvider() {
        // When more levels are added to the game, add them here to test them. 
        return Stream.of(new TeleportTestLevel(), 
                        new TestLevel(), 
                        new FirstLevel(), 
                        new SecondLevel(), 
                        new ThirdLevel(), 
                        new FourthLevel(),
                        new FifthLevel(),
                        new SixthLevel(),
                        new SeventhLevel(),
                        new EighthLevel(),
                        new NinthLevel(),
                        new TenthLevel());
    }

    @ParameterizedTest
    @MethodSource("levelProvider")
    void testPlayerExistsInLevel(Level levelUnderTest) {
        boolean playerExists = false;
        for (int i = 0; i < levelUnderTest.getHeight(); i++) {
            for (int j = 0; j < levelUnderTest.getWidth(); j++) {
                if (levelUnderTest.getLevelTile(i, j) == GameObjectType.PLAYER____) {
                    playerExists = true;
                }
            }
        }
        assertTrue(playerExists);
    }

    @ParameterizedTest
    @MethodSource("levelProvider")
    void testIfGoalExistsInLevel(Level levelUnderTest) {
        boolean goalExists = false;
        for (int i = 0; i < levelUnderTest.getHeight(); i++) {
            for (int j = 0; j < levelUnderTest.getWidth(); j++) {
                if (levelUnderTest.getLevelTile(i, j) == GameObjectType.GOAL______) {
                    goalExists = true;
                }
            }
        }
        assertTrue(goalExists);
    }
}