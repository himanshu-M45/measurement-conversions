package org.example;

import java.util.Objects;

public class Volume{
    // to convert liter to milliliters
    private final Double value;
    private final VolumeUnit unit;



    public Volume(double value, VolumeUnit unit) throws Exception {
        if (value <= 0) {
            throw new Exception("Input should be a non zero positive value");
        }
        this.value = value;
        this.unit = unit;
    }

    public double convert(VolumeUnit toUnit) throws Exception {
        double valueInBaseUnit = unit.toBaseUnit() * value;
        return toUnit.fromBaseUnit() * valueInBaseUnit;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Volume volume = (Volume) obj;
        return Objects.equals(value, volume.value) && Objects.equals(unit, volume.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }
}
