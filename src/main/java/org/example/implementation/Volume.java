package org.example.implementation;

import org.example.enums.VolumeUnit;
import org.example.interfaces.Measurable;

public class Volume extends Measurement<VolumeUnit> {
    public Volume(double value, VolumeUnit unit) throws IllegalAccessException {
        super(value, unit);
    }

    @Override
    public Volume convert(Enum<?> toUnit) throws Exception {
        return (Volume) super.convert(toUnit);
    }

    @Override
    protected Measurable createInstance(double value, VolumeUnit unit) throws IllegalAccessException {
        return new Volume(value, unit);
    }
}
