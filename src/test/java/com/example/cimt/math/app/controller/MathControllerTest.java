package com.example.cimt.math.app.controller;

import com.example.cimt.math.app.dto.GcdRequestBody;
import com.example.cimt.math.app.service.MathService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigInteger;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest
@WebMvcTest(controllers = MathController.class)
//@AutoConfigureMockMvc
public class MathControllerTest {

    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    MathService mathService;
    @Autowired
    private MockMvc mvc;

    @Test
    void testGcdHandlerMethod() throws Exception {

        when(mathService.calculateGcd("42", "140")).thenReturn(14);
        GcdRequestBody gcdRequestBody = new GcdRequestBody();
        gcdRequestBody.setVal1(String.valueOf(42));
        gcdRequestBody.setVal2(String.valueOf(140));
        mvc.perform(MockMvcRequestBuilders.post("/values/gcd")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(gcdRequestBody)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("14"));
    }

    @Test
    void testFibonacciHandlerMethod() throws Exception {
        when(mathService.calculateFiboValue(BigInteger.ONE)).thenReturn(BigInteger.ONE);
        mvc.perform(MockMvcRequestBuilders.get("/values/fibonacci/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
    }
}
