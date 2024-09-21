package org.example.enums;

public enum VolumeUnit {
    // Volume Units
    L(1.0),
    DL(0.1),
    CL(0.01),
    ML(0.001),
    KL(1000.0);

    private final double conversionFactor;

    VolumeUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double toBaseUnit() {
        return conversionFactor;
    }

    public double fromBaseUnit() {
        return 1 / conversionFactor;
    }
}
