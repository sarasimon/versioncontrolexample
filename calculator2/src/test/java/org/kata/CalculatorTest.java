package org.kata;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testWhenExpressionIsANumberReturnsIt(){
        Calculator calculator = new Calculator();
        assertTrue(calculator.evaluate("5") == 5);
    }

    @Test
    public void testWhenExpressionIsANegativeNumberReturnsIt(){
        Calculator calculator = new Calculator();
        assertTrue(calculator.evaluate("-5") == -5);
    }


    @Test
    public void testWhenExpressionIsTwoDigitsNumberReturnsIt(){
        Calculator calculator = new Calculator();
        assertTrue(calculator.evaluate("57") == 57);
    }

    @Test
    public void testSimpleSum(){
        Calculator calculator = new Calculator();
        assertTrue(calculator.evaluate("2 7 +") == 9);
    }

    @Test
    public void testSimpleSubtraction(){
        Calculator calculator = new Calculator();
        Assert.assertEquals(-5, calculator.evaluate("2 7 -"));
    }
    @Test
    public void testSimpleMultiply(){
        Calculator calculator = new Calculator();
        Assert.assertEquals(14, calculator.evaluate("2 7 *"));
    }
    @Test
    public void testSimpleDivides(){
        Calculator calculator = new Calculator();
        Assert.assertEquals(2, calculator.evaluate("14 7 /"));
    }

    @Test
    public void testSimpleWtf(){
        Calculator calculator = new Calculator();
        Assert.assertEquals(0, calculator.evaluate("14 7 @"));
    }

    @Test
    public void testComplexWtf(){
        Calculator calculator = new Calculator();
        Assert.assertEquals(3, calculator.evaluate("4 3 + 3 -"));
    }





}