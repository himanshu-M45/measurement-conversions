package org.example;

public enum VolumeUnit {
    // Volume Units
    L(1.0),
    DL(0.1),
    CL(0.01),
    ML(0.001),
    KL(1000.0),

    // Length Units
    M(1.0),
    CM(0.01),
    MM(0.001),
    KM(1000.0),


    // Mass Units
    G(1.0),
    MG(0.001),
    KG(1000.0);

    private final double currentUnit;

    VolumeUnit(double currentUnit) {
        this.currentUnit = currentUnit;
    }

    public double toBaseUnit() {
        return currentUnit;
    }

    public double fromBaseUnit() {
        return 1 / currentUnit;
    }
}
