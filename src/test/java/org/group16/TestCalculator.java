package org.group16;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCalculator {

    @Test
    void testAdd(){
        assertEquals(2, Calculator.add(1,1));
    }

}