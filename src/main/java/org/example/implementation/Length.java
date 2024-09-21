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
    protected double convertToBaseUnit(double value, LengthUnit unit) {
        return value * unit.toBaseUnit();
    }

    @Override
    protected double convertFromBaseUnit(double value, LengthUnit unit) {
        return value * unit.fromBaseUnit();
    }

    @Override
    protected Measurable createInstance(double value, LengthUnit unit) throws IllegalAccessException {
        return new Length(value, unit);
    }

}
