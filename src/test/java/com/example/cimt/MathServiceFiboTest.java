package com.example.cimt;

import com.example.cimt.service.MathService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    public void testFibonacci() throws Exception {
        assertThat(mathService.calculateFiboValue(1), is(equalTo(1)));
        assertThat(mathService.calculateFiboValue(2), is(equalTo(1)));
        assertThat(mathService.calculateFiboValue(7), is(equalTo(13)));
        assertThat(mathService.calculateFiboValue(10), is(equalTo(55)));

    }

    @Test

    public void testFibonacciPositionZero_ThrowsIllegalArgumentException() {
        int invalidFibonacciPosition = 0;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            mathService.calculateFiboValue(invalidFibonacciPosition);
        });
    }
}
