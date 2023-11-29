package org.group16.Model.Level;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        // Test which you can which gives an example of how to test the meta data. 
        // int testX = 26;
        // int testY = 10;

        // assertEquals(40, firstLevelUnderTest.getMetadata(new Tuple(testX, testY)).getDistance());
    }

}
