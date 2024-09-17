package org.example;

import java.util.Objects;

public class Volume{
    // to convert liter to milliliters
    private final Double value;
    private final String unit;



    public Volume(double value, String unit) throws Exception {
        if (value <= 0) {
            throw new Exception("Input should be a non zero positive value");
        }
        this.value = value;
        this.unit = unit;
    }

    public Volume convert() throws Exception {
        if (unit == "l")
            return new Volume(value * 1000, "ml");

        return new Volume(value / 1000, "l");
    }
}
