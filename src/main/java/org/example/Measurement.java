package org.example;

import java.util.Objects;

public class Measurement {
    // to convert liter to milliliters
    private final Double value;
    private final Unit unit;



    public Measurement(double value, Unit unit) throws Exception {
        if (value <= 0) {
            throw new Exception("Input should be a non zero positive value");
        }
        this.value = value;
        this.unit = unit;
    }

    public Measurement convert(Unit toUnit) throws Exception {
        if (this.unit.getUnitType() != toUnit.getUnitType()) {
            throw new Exception("Different types of measurements");
        }
        double valueInBaseUnit = unit.toBaseUnit() * value;
        return new Measurement(toUnit.fromBaseUnit() * valueInBaseUnit, toUnit);
    }

    public Measurement add(Measurement otherUnit, Unit resultUnit) throws Exception {
        if (this.unit.getUnitType() != resultUnit.getUnitType() && this.unit.getUnitType() != otherUnit.unit.getUnitType()) {
            throw new Exception("Cannot convert between different Units");
        }

        // convert both units to base unit
        double currentValueInBaseUnit = unit.toBaseUnit() * value;
        double otherUnitInBaseUnit = otherUnit.unit.toBaseUnit() * otherUnit.value;

        // sum in base unit
        double sumInBaseUnit = currentValueInBaseUnit + otherUnitInBaseUnit;

        // convert the sum to target unit
        double resultValue = sumInBaseUnit * resultUnit.fromBaseUnit();

        return new Measurement(resultValue, resultUnit);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Measurement measurement = (Measurement) obj;
        return Objects.equals(value, measurement.value) && Objects.equals(this.unit, measurement.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }
}
