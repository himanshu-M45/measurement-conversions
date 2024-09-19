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
    KG(1000.0, MeasurementType.MASS),

    // Temperature Units
    CELSIUS(1.0, MeasurementType.TEMPERATURE),
    FAHRENHEIT(1.0, MeasurementType.TEMPERATURE);

    private final double conversionFactor;
    private final MeasurementType measurementType;

    Unit(double conversionFactor, MeasurementType measurementType) {
        this.conversionFactor = conversionFactor;
        this.measurementType = measurementType;
    }

    public double toBaseUnit() {
        return conversionFactor;
    }

    public double fromBaseUnit() {
        return 1 / conversionFactor;
    }

    public MeasurementType getUnitType() {
        return measurementType;
    }

    public enum MeasurementType {
        VOLUME,
        LENGTH,
        MASS,
        TEMPERATURE,
    }
}
