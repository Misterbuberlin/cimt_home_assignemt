package com.example.springboot.dto;

import jakarta.validation.constraints.NotNull;

public class GcdRequestBody {


    @NotNull
    private Integer val1;

    @NotNull
   // @DecimalMin(value = "0.1", inclusive = false, message = "Value must be greater than zero")
    private Integer val2;

    public Integer getVal1() {
        return val1;
    }

    public void setVal1(Integer val1) {
        this.val1 = val1;
    }

    public Integer getVal2() {
        return val2;
    }

    public void setVal2(Integer val2) {
        this.val2 = val2;
    }
}
