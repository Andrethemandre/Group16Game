package org.group16.Model.Level;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.group16.Model.GameObjects.Positionable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FirstLevelTest {
    private FirstLevel firstLevelUnderTest;

    @BeforeEach
    void setUp() {
        firstLevelUnderTest = new FirstLevel();
    }

    @Test
    void testMetadata() {
        firstLevelUnderTest.getMetadata(new Positionable(26, 10));
        assertEquals(40, firstLevelUnderTest.getMetadata(new Positionable(26, 10)).getDistance());
    }

}
