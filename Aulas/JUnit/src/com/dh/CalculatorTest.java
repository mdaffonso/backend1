package com.dh;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    public void equalsZero() {
        Assertions.assertEquals(0, Calculator.sum());
    }

    @Test
    public void equalsFour() {
        Assertions.assertEquals(4, Calculator.sum(1, 2, 1));
    }
}
