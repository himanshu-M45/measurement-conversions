package org.example;

public enum Units {
    // Volume Units
    L(1.0, UnitType.VOLUME),
    DL(0.1, UnitType.VOLUME),
    CL(0.01, UnitType.VOLUME),
    ML(0.001, UnitType.VOLUME),
    KL(1000.0, UnitType.VOLUME),

    // Length Units
    M(1.0, UnitType.LENGTH),
    CM(0.01, UnitType.LENGTH),
    MM(0.001, UnitType.LENGTH),
    KM(1000.0, UnitType.LENGTH),


    // Mass Units
    G(1.0, UnitType.MASS),
    MG(0.001, UnitType.MASS),
    KG(1000.0, UnitType.MASS);

    private final double currentUnit;
    private final UnitType unitType;

    Units(double currentUnit, UnitType unitType) {
        this.currentUnit = currentUnit;
        this.unitType = unitType;
    }

    public double toBaseUnit() {
        return currentUnit;
    }

    public double fromBaseUnit() {
        return 1 / currentUnit;
    }

    public UnitType getUnitType() {
        return unitType;
    }

    public enum UnitType{
        VOLUME,
        LENGTH,
        MASS,
    }
}
