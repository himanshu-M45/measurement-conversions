package org.example;

public enum Unit {
    // Volume Units
    L(1.0, MeasurementType.VOLUME),
    DL(0.1, MeasurementType.VOLUME),
    CL(0.01, MeasurementType.VOLUME),
    ML(0.001, MeasurementType.VOLUME),
    KL(1000.0, MeasurementType.VOLUME),

    // Length Units
    M(1.0, MeasurementType.LENGTH),
    CM(0.01, MeasurementType.LENGTH),
    MM(0.001, MeasurementType.LENGTH),
    KM(1000.0, MeasurementType.LENGTH),


    // Mass Units
    G(1.0, MeasurementType.MASS),
    MG(0.001, MeasurementType.MASS),
    KG(1000.0, MeasurementType.MASS);

    private final double currentUnit;
    private final MeasurementType measurementType;

    Unit(double currentUnit, MeasurementType measurementType) {
        this.currentUnit = currentUnit;
        this.measurementType = measurementType;
    }

    public double toBaseUnit() {
        return currentUnit;
    }

    public double fromBaseUnit() {
        return 1 / currentUnit;
    }

    public MeasurementType getUnitType() {
        return measurementType;
    }

    public enum MeasurementType {
        VOLUME,
        LENGTH,
        MASS,
    }
}
