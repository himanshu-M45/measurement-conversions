package org.example.implementation;

import org.example.enums.VolumeUnit;
import org.example.enums.WeightUnit;
import org.example.interfaces.Measurable;

import java.util.Objects;

public class Volume extends AbstractMeasurable<VolumeUnit> {
    public Volume(double value, VolumeUnit unit) throws IllegalAccessException {
        super(value, unit);
    }

    @Override
    public Volume convert(Enum<?> toUnit) throws Exception {
        return(Volume) super.convert(toUnit);
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
    protected double convertToBaseUnit(double value, VolumeUnit unit) {
        return value * unit.toBaseUnit();
    }

    @Override
    protected double convertFromBaseUnit(double value, VolumeUnit unit) {
        return value * unit.fromBaseUnit();
    }

    @Override
    protected Measurable createInstance(double value, VolumeUnit unit) {
        try {
            return new Volume(value, unit);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
