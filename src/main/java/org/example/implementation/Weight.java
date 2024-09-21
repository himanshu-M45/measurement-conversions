package org.example.implementation;

import org.example.enums.WeightUnit;
import org.example.interfaces.Measurable;

public class Weight extends Measurement<WeightUnit> {
    public Weight(double value, WeightUnit unit) throws IllegalAccessException {
        super(value, unit);
    }

    @Override
    public Weight convert(Enum<?> toUnit) throws Exception {
        return(Weight) super.convert(toUnit);
    }

    @Override
    public Measurable add(Measurable additionValue) throws Exception {
       return super.add(additionValue);
    }

    @Override
    public Measurable sub(Measurable subtractionValue) throws Exception {
       return super.sub(subtractionValue);
    }

    @Override
    public int compare(Measurable compareTo) throws Exception {
        return super.compare(compareTo);
    }

    @Override
    protected double convertToBaseUnit(double value, WeightUnit unit) {
        return value * unit.toBaseUnit();
    }

    @Override
    protected double convertFromBaseUnit(double value, WeightUnit unit) {
        return value * unit.fromBaseUnit();
    }

    @Override
    protected Measurable createInstance(double value, WeightUnit unit) throws IllegalAccessException {
        return new Weight(value, unit);
    }
}
