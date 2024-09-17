package org.example;

public class LitersToMilliliters extends Convert{
    private final Double liters;

    LitersToMilliliters(Double liters) throws Exception {
        if (liters <= 0) {
            throw new Exception("Input should be a non zero positive value");
        }
        this.liters = liters;
    }
    @Override
    public double convert() {
        return liters * 1000;
    }
}
