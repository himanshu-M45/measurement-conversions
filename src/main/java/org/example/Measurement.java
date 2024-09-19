package org.example;

import java.util.Objects;

public class Measurement {
    // to convert liter to milliliters
    private final Double value;
    private final Unit unit;



    public Measurement(double value, Unit unit) throws Exception {
        if (value < 0) {
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

    public Measurement add(Measurement additionAmount) throws Exception {
        if (this.unit.getUnitType() != additionAmount.unit.getUnitType()) {
            throw new Exception("Different types of measurements");
        }

        // convert additionAmount into base unit
        double additionAmountInBaseUnit = additionAmount.unit.toBaseUnit() * additionAmount.value;

        // result
        double resultantSumValue = (unit.toBaseUnit() * value + additionAmountInBaseUnit) * this.unit.fromBaseUnit();

        return new Measurement(resultantSumValue, this.unit);
    }

    public Measurement sub(Measurement subtractionAmount) throws Exception {
        if (this.unit.getUnitType() != subtractionAmount.unit.getUnitType()) {
            throw new Exception("Different types of measurements");
        }

        // convert subtractionAmount into base unit
        double subtractionAmountInBaseUnit = subtractionAmount.unit.toBaseUnit() * subtractionAmount.value;

        // result
        double resultantSubValue = (unit.toBaseUnit() * value - subtractionAmountInBaseUnit) * this.unit.fromBaseUnit();

        return new Measurement(resultantSubValue, this.unit);
    }

    public int compare(Measurement compareTo) throws Exception {
        if (this.unit.getUnitType() != compareTo.unit.getUnitType()) {
            throw new Exception("Different types of measurements");
        }

        // convert compareTo unit value into base unit value
        Measurement convertCompareToInBaseUnit = compareTo.convert(this.unit);

        return Double.compare(this.value, convertCompareToInBaseUnit.value);
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
