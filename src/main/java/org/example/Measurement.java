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
        validateMeasurementType(toUnit);
        double valueInBaseUnit = unit.toBaseUnit() * value;
        return new Measurement(toUnit.fromBaseUnit() * valueInBaseUnit, toUnit);
    }

    public Measurement add(Measurement additionValue) throws Exception {
        validateMeasurementType(additionValue.unit);

        // convert additionValue into same unit type as calling object
        Measurement convertAdditionValueInBaseUnit = additionValue.convert(this.unit);

        return new Measurement(this.value + convertAdditionValueInBaseUnit.value, this.unit);
    }

    public Measurement sub(Measurement subtractionValue) throws Exception {
        validateMeasurementType(subtractionValue.unit);

        // convert subtractionValue into same unit type as calling object
        Measurement convertSubtractionValueInBaseUnit = subtractionValue.convert(this.unit);

        return new Measurement(this.value - convertSubtractionValueInBaseUnit.value, this.unit);
    }

    public int compare(Measurement compareTo) throws Exception {
        validateMeasurementType(compareTo.unit);

        // convert compareTo unit value into base unit value
        Measurement convertCompareToInBaseUnit = compareTo.convert(this.unit);

        return Double.compare(this.value, convertCompareToInBaseUnit.value);
    }

    private void validateMeasurementType(Unit measurementType) throws Exception {
        if (this.unit.getUnitType() != measurementType.getUnitType())
            throw new Exception("Different types of measurements");
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
