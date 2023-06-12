package com.example.springboot;

import com.example.springboot.service.MathService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class MathServiceTest {

    private MathService mathService;

    @BeforeEach
    public void setUp() {
        mathService = new MathService();
    }

    @Test
    public void testGcdFirstValIsZero() throws Exception {
         int result = mathService.calculateGcd(0, 1);
         assertThat(result, is(equalTo(1)));
    }

    @Test
    public void testGcdBothValuesArePositive() throws Exception {
        int result = mathService.calculateGcd(42, 140);
        assertThat(result, is(equalTo(14)));
         result = mathService.calculateGcd(140, 42);
        assertThat(result, is(equalTo(14)));
    }

    @Test
    public void testFibonacci() throws Exception
    {
        assertThat(mathService.calculateFiboValue(1), is(equalTo(1)));
        assertThat(mathService.calculateFiboValue(2), is(equalTo(1)));
        assertThat(mathService.calculateFiboValue(7), is(equalTo(13)));
        assertThat(mathService.calculateFiboValue(10), is(equalTo(55)));

    }

    @Test

    public void testFibonacciPositionZero_ThrowsIllegalArgumentException()
    {
        int invalidFibonacciPosition = 0;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            mathService.calculateFiboValue(invalidFibonacciPosition);
        });
    }

    @Test
    public void testGcdVal2EqualsZero_ThrowsIllegalArgumentException()
    {
        int val1 = -1;
        int val2 = 0;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            mathService.calculateGcd(val1, val2);
        });
    }
}
