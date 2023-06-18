package com.example.cimt.math.app.service;

import com.example.cimt.math.app.service.MathService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class MathServiceFiboTest {

    private MathService mathService;

    @BeforeEach
    public void setUp() {
        mathService = new MathService();
    }

    @Test
    public void testFibonacci() {
        assertThat(mathService.calculateFiboValue(1), is(equalTo(BigInteger.ONE)));
        assertThat(mathService.calculateFiboValue(2), is(equalTo(BigInteger.ONE)));
        assertThat(mathService.calculateFiboValue(7), is(equalTo(BigInteger.valueOf(13))));
        assertThat(mathService.calculateFiboValue(10), is(equalTo(BigInteger.valueOf(55))));

    }

    @Test

    public void testFibonacciPositionZero_ThrowsIllegalArgumentException() {
        int invalidFibonacciPosition = 0;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            mathService.calculateFiboValue(invalidFibonacciPosition);
        });
    }
}
