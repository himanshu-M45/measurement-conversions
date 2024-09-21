package org.example.enums;

public enum TemperatureUnit {
    CELSIUS(1.0),
    FAHRENHEIT(1.0);

    private final double conversionFactor;
    public final int constant = 32;

    TemperatureUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double toBaseUnit() {
        return conversionFactor;
    }

    public double fromBaseUnit() {
        return 1 / conversionFactor;
    }
}
