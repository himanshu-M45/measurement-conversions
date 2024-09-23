package org.example.implementation;

import org.example.enums.LengthUnit;
import org.example.interfaces.Measurable;


public class Length extends Measurement<LengthUnit> {
    public Length(double value, LengthUnit unit) throws IllegalAccessException {
        super(value, unit);
    }

    @Override
    public Length convert(Enum<?> toUnit) throws Exception {
        return (Length) super.convert(toUnit);
    }

    protected Measurable createInstance(double value, LengthUnit unit) throws IllegalAccessException {
        return new Length(value, unit);
    }

}
