package org.example;

import java.util.Objects;

public class Unit {
    // to convert liter to milliliters
    private final Double value;
    private final Units unit;



    public Unit(double value, Units unit) throws Exception {
        if (value <= 0) {
            throw new Exception("Input should be a non zero positive value");
        }
        this.value = value;
        this.unit = unit;
    }

    public Unit convert(Units toUnit) throws Exception {
        if (this.unit.getUnitType() != toUnit.getUnitType()) {
            throw new Exception("Cannot convert between different Units");
        }
        double valueInBaseUnit = unit.toBaseUnit() * value;
        return new Unit(toUnit.fromBaseUnit() * valueInBaseUnit, toUnit);
    }

    public Unit add(Unit otherUnit, Units resultUnit) throws Exception {
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

        return new Unit(resultValue, resultUnit);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Unit unit = (Unit) obj;
        return Objects.equals(value, unit.value) && Objects.equals(this.unit, unit.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }
}
