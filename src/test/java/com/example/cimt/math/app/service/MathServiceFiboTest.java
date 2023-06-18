package com.example.cimt.math.app.service;

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
        assertThat(mathService.calculateFiboValue(BigInteger.ONE), is(equalTo(BigInteger.ONE)));
        assertThat(mathService.calculateFiboValue(BigInteger.TWO), is(equalTo(BigInteger.ONE)));
        assertThat(mathService.calculateFiboValue(BigInteger.valueOf(3)), is(equalTo(BigInteger.TWO)));
        assertThat(mathService.calculateFiboValue(BigInteger.valueOf(7)), is(equalTo(BigInteger.valueOf(13))));
        assertThat(mathService.calculateFiboValue(BigInteger.TEN), is(equalTo(BigInteger.valueOf(55))));

    }

    @Test
    public void testFibonacciPositionZero_ThrowsIllegalArgumentException() {
        BigInteger invalidFibonacciPosition = BigInteger.ZERO;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            mathService.calculateFiboValue(invalidFibonacciPosition);
        });
    }
}
