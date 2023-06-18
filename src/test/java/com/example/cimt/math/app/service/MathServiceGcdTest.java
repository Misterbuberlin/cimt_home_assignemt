package com.example.cimt.math.app.service;

import com.example.cimt.math.app.service.MathService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class MathServiceGcdTest {

    private MathService mathService;

    @BeforeEach
    public void setUp() {
        mathService = new MathService();
    }

    @Test
    public void testGcdFirstValIsZero() {
        int result = mathService.calculateGcd("0", "1");
        assertThat(result, is(equalTo(1)));
    }

    @Test
    public void testGcdVal2EqualsZero_ThrowsIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            mathService.calculateGcd("-1", "0");
        });
    }

    @Test
    public void testGcdBothValuesArePositive() {
        int result = mathService.calculateGcd("42", "140");
        assertThat(result, is(equalTo(14)));
        result = mathService.calculateGcd("140", "42");
        assertThat(result, is(equalTo(14)));
    }

    @Test
    public void testGcdBothValuesAreNegative()  {
        int result = mathService.calculateGcd("-42", "-140");
        assertThat(result, is(equalTo(14)));
        result = mathService.calculateGcd("-140", "-42");
        assertThat(result, is(equalTo(14)));
    }
}
