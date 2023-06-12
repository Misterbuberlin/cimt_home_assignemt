package com.example.springboot;

import com.example.springboot.dto.GcdRequestBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MathControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testGcdHandlerMethod() throws Exception {

        GcdRequestBody gcdRequestBody = new GcdRequestBody();
        gcdRequestBody.setVal1(42);
        gcdRequestBody.setVal2(140);
        mvc.perform(MockMvcRequestBuilders.post("/values/gcd")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(gcdRequestBody)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("14"));
    }

    @Test
    void testFibonacciHandlerMethod() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/values/fibonacci/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
    }
}
