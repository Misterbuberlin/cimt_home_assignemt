package com.example.cimt.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class MathService {

    private static final Logger logger
            = LoggerFactory.getLogger(MathService.class);

    public BigInteger calculateFiboValue(int position) {
        if (position <= 0) {
            throw new IllegalArgumentException("Die Position muss größer sein als 0.");
        }
        logger.info("Please wait... Currently computing the fibonacci value at {} ", position);
        if (position == 1 || position == 2) {
            return BigInteger.valueOf(1);
        }

        BigInteger previous = BigInteger.valueOf(1);
        BigInteger current = BigInteger.valueOf(1);
        for (int i = 3; i <= position; i++) {
            BigInteger next = previous.add(current);
            previous = current;
            current = next;
        }
        logger.info("the fibonacci value at  position {} is {} ", position, current);
        return current;
    }

    public int calculateGcd(String val1, String val2) {
        int value1 = Integer.parseInt(val1);
        int value2 = Integer.parseInt(val2);
        if (value2 == 0) {
            throw new IllegalArgumentException("val2 muss ungleich 0 sein.");
        }
        if (value1 == 0) {
            return Math.abs(value2);
        }

        value1 = Math.abs(value1);
        value2 = Math.abs(value2);
        value1 = runEuclidianAlgorithm(value1, value2);
        return value1;
    }

    private int runEuclidianAlgorithm(int val1, int val2) {
        while (val2 != 0) {
            int temp = val2;
            val2 = val1 % val2;
            val1 = temp;
        }
        return val1;
    }

}
