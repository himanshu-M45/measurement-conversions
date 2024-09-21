package org.example.implementation;

import org.example.enums.TemperatureUnit;
import org.example.interfaces.Measurable;

public class Temperature extends Measurement<TemperatureUnit> {
    public Temperature(double value, TemperatureUnit unit) throws IllegalAccessException{
        super(value, unit);
    }

    @Override
    public Temperature convert(Enum<?> toUnit) throws Exception {
        TemperatureUnit targetUnit = (TemperatureUnit) toUnit; // extract target unit

        if (targetUnit == TemperatureUnit.CELSIUS) {
            return new Temperature((this.value - targetUnit.constant) * 5 / 9, targetUnit); // F -> C
        }
        return new Temperature((value * 9 / 5) + targetUnit.constant, targetUnit); // C -> F
    }

    @Override
    public int compare(Measurable compareTo) throws Exception {
        return super.compare(compareTo);
    }

    @Override
    public Measurable add(Measurable additionValue) {
        throw new UnsupportedOperationException("Addition is not supported for Temperature");
    }

    @Override
    public Measurable sub(Measurable subtractionValue) {
        throw new UnsupportedOperationException("Subtraction is not supported for Temperature");
    }

    @Override
    protected double convertToBaseUnit(double value, TemperatureUnit unit) {
        return value * unit.toBaseUnit();
    }

    @Override
    protected double convertFromBaseUnit(double value, TemperatureUnit unit) {
        return value * unit.fromBaseUnit();
    }

    @Override
    protected Measurable createInstance(double value, TemperatureUnit unit) throws IllegalAccessException {
        return new Temperature(value, unit);
    }
}
