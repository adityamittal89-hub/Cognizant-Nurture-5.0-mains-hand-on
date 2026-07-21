// src/test/java/com/example/CalculatorTest.java
package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class Calculatortest {

    private final Calculator calculator = new Calculator();

    @Test
    public void testAdd() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    public void testSubtract() {
        assertEquals(1, calculator.subtract(3, 2));
    }

    @Test
    public void testDivide() {
        assertEquals(2, calculator.divide(10, 5));
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        calculator.divide(10, 0);
    }
}