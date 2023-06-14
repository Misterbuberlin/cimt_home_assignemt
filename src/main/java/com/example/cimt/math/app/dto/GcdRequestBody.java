package com.example.cimt.math.app.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class GcdRequestBody {


    @NotNull(message = "Number is required")
    @Min(value = Integer.MIN_VALUE, message = "the min possible value must be -2 147 483 648")
    @Max(value = Integer.MAX_VALUE, message = "the greatest possible value must be 2 147 483 647")
    @Positive(message = "Number must be a integer")
    private String val1;

    @NotNull(message = "Number is required")
    @Min(value = Integer.MIN_VALUE, message = "the min possible value must be -2 147 483 648")
    @Max(value = Integer.MAX_VALUE, message = "the greatest possible value must be 2 147 483 647")
    private String val2;

    public String getVal1() {
        return val1;
    }

    public void setVal1(String val1) {
        //we handle the value given in the request body as a string because of validation purpose,
        //e.g. if user makes an error and enters a decimal number instead of an integer,
        //we will return an IllegalArgumentException instead of silently "losing" the decimal precision
        if (!isInteger(String.valueOf(val1))) {
            throw new IllegalArgumentException("Invalid input," + val1 + " is not an integer.");
        }
        this.val1 = val1;
    }

    public String getVal2() {
        return val2;
    }

    public void setVal2(String val2) {
        //we handle the value given in the request body as a string because of validation purpose,
        //e.g. if user makes an error and enters a decimal number (e.g. 2000.34) instead of an integer,
        //we will return an IllegalArgumentException instead of silently "losing" the decimal precision
        if (!isInteger(String.valueOf(val2))) {
            throw new IllegalArgumentException("Invalid input," + val2 + " is not an integer.");
        }
        this.val2 = val2;
    }

    private boolean isInteger(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
