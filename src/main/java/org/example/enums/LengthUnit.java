package org.example.enums;

public enum LengthUnit {
    // Length Units
    M(1.0),
    CM(0.01),
    MM(0.001),
    KM(1000.0);

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double toBaseUnit() {
        return conversionFactor;
    }

    public double fromBaseUnit() {
        return 1 / conversionFactor;
    }
}
