package com.example.cimt.service;

import org.springframework.stereotype.Service;

@Service
public class MathService {

    public int calculateFiboValue(int position) {
        if (position <= 0) {
            throw new IllegalArgumentException("Die Position muss größer als 0 sein.");
        }

        if (position == 1 || position == 2) {
            return 1;
        }

        int prev = 1;
        int curr = 1;
        for (int i = 3; i <= position; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }

        return curr;
    }

    public int calculateGcd(int val1, int val2) {

        if (val2 == 0) {
            throw new IllegalArgumentException("val2 muss ungleich 0 sein.");
        }
        if (val1 == 0) {
            return Math.abs(val2);
        }

        val1 = Math.abs(val1);
        val2 = Math.abs(val2);
        //euclidian algorithm
        while (val2 != 0) {
            int temp = val2;
            val2 = val1 % val2;
            val1 = temp;
        }
        return val1;
    }
}
