package com.example.calculator.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


public class CalculatorTest {

    @BeforeEach
    void setUp() throws Exception {
        
    }

    @Test
    void sumTest() {
        Double number1 = 30.0;
        Double number2 = 25.0;
        Calculator calculator = new Calculator();
        Double result = calculator.sum(number1, number2);
        Assertions.assertEquals(55.0, result);
    }

    @Test
    public void numbersNullSumTest() throws NullPointerException{
        Double number1 = null;
        Double number2 = null;
        Calculator calculator = new Calculator();
        Assertions.assertThrows(NullPointerException.class, () -> {calculator.sum(number1, number2);});

    }

    @Test
    void subTest() {
        Double number1 = 30.0;
        Double number2 = 25.0;
        Calculator calculator = new Calculator();
        Assertions.assertEquals(5.0, calculator.sub(number1, number2));
    }

    @Test
    void divideTest() {
        Double number1 = 10.0;
        Double number2 = 5.0;
        Calculator calculator = new Calculator();
        Assertions.assertEquals(2.0, calculator.divide(number1, number2));
    }

    @Test
    public void divisionByZeroTest() {
        Double number1 = 10.0;
        Double number2 = 0.0;
        Calculator calculator = new Calculator();
        Assertions.assertThrows(ArithmeticException.class, () -> {calculator.divide(number1, number2);});
    }

    @Test
    void factorialTest() {
        Integer factorial = 3;
        Calculator calculator = new Calculator();
        Assertions.assertEquals(6, calculator.factorial(factorial));
    }

    @Test
    void integerToBinaryTest() {
        Integer integer = 3;
        Calculator calculator = new Calculator();
        Assertions.assertEquals(11, calculator.integerToBinary(integer));
    }

    @Test
    void integerToHexadecimalTest() {
        Integer integer = 13;
        Calculator calculator = new Calculator();
        Assertions.assertEquals("d", calculator.integerToHexadecimal(integer));
    }

    @Test
    void calculeDayBetweenDateTest() {
        LocalDate date1 = LocalDate.of(2020, 3, 15);
        LocalDate date2 = LocalDate.of(2020, 3, 25);
        Calculator calculator = new Calculator();
        Assertions.assertEquals(-10, calculator.calculeDayBetweenDate(date1, date2));
    }
}
