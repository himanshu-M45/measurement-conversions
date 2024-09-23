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
    protected Measurable createInstance(double value, WeightUnit unit) throws IllegalAccessException {
        return new Weight(value, unit);
    }
}
