package com.example.cimt.math.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class MathService {

    private static final Logger logger
            = LoggerFactory.getLogger(MathService.class);

    public BigInteger calculateFiboValue(BigInteger position) {
        if (position.compareTo(BigInteger.ZERO) <= 0) {
            throw new IllegalArgumentException("Die Position muss größer sein als 0.");
        }
        logger.info("Please wait... Currently computing the fibonacci value at {} ", position);
        if (position.equals(BigInteger.ONE) || position.equals(BigInteger.TWO)) {
            return BigInteger.valueOf(1);
        }

        BigInteger previous = BigInteger.valueOf(1);
        BigInteger current = BigInteger.valueOf(1);

        BigInteger start = BigInteger.valueOf(3);
        BigInteger end = position;
        BigInteger step = BigInteger.ONE;

        for (BigInteger counter = start; counter.compareTo(end) <= 0; counter = counter.add(step)) {
            BigInteger next = previous.add(current);
            previous = current;
            current = next;
        }
        logger.info("the fibonacci value at  position {} is {} ", position, current);
        return current;
    }

    public int calculateGcd(String firstVal, String secondVal) {
        int value1 = Integer.parseInt(firstVal);
        int value2 = Integer.parseInt(secondVal);
        if (value2 == 0) {
            throw new IllegalArgumentException("val2 muss ungleich 0 sein.");
        }
        if (value1 == 0) {
            return Math.abs(value2);
        }

        value1 = Math.abs(value1);
        value2 = Math.abs(value2);
        BigInteger v1 = BigInteger.valueOf(value1);
        BigInteger v2 = BigInteger.valueOf(value2);
        BigInteger gcd = v1.gcd(v2);
        logger.info("The greatest common denominator for {} and {} is {}.", value1, value2, gcd);
        return gcd.intValue();
    }

}
