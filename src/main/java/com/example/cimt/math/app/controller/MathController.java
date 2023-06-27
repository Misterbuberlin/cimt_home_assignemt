package com.example.cimt.math.app.controller;

import com.example.cimt.math.app.dto.GcdRequestBody;
import com.example.cimt.math.app.service.MathService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("/values")
public class MathController {

    @Autowired
    private MathService mathService;


    @GetMapping("/fibonacci/{position}")
    public ResponseEntity<BigInteger> getFibonacciNumber(@PathVariable BigInteger position) {
        BigInteger fiboValue = mathService.calculateFiboValue(position);
        return ResponseEntity.ok(fiboValue);
    }


    @PostMapping("/gcd")
    public ResponseEntity<Integer> calculateGCD(@RequestBody @Valid GcdRequestBody request) {
        int gcdValue = mathService.calculateGcd(request.getVal1(), request.getVal2());
        return ResponseEntity.ok(gcdValue);
    }


}
