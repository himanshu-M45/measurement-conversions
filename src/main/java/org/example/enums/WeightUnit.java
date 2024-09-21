package org.example.enums;

public enum WeightUnit {
    // Mass Units
    G(1.0),
    MG(0.001),
    KG(1000.0);

    private final double conversionFactor;

    WeightUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double toBaseUnit() {
        return conversionFactor;
    }

    public double fromBaseUnit() {
        return 1 / conversionFactor;
    }
}
