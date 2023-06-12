package com.example.springboot.controller;

import com.example.springboot.dto.GcdRequestBody;
import com.example.springboot.service.MathService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/values")
public class MathController {

	@Autowired
	MathService mathService;


	@GetMapping("/fibonacci/{position}")
	public ResponseEntity<Integer> getFibonacciNumber(@PathVariable int position) {
		 int fiboValue = mathService.calculateFiboValue(position);
		 return ResponseEntity.ok(fiboValue);
	}



	@PostMapping("/gcd")
	public ResponseEntity<Integer> calculateGCD(@RequestBody @Valid GcdRequestBody request) {

		int gcdValue = mathService.calculateGcd(request.getVal1(), request.getVal2());
		return ResponseEntity.ok(gcdValue);
	}



}
