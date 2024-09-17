package org.example;

import java.util.Objects;

public class Volume{
    // to convert liter to milliliters
    private final Double value;
    private final Units unit;



    public Volume(double value, Units unit) throws Exception {
        if (value <= 0) {
            throw new Exception("Input should be a non zero positive value");
        }
        this.value = value;
        this.unit = unit;
    }

    public double convert(String toUnit) throws Exception {
        Units outputUnit = Units.valueOf(toUnit);
        double valueInLiters = unit.toLiter(value);
        return outputUnit.fromLiter(valueInLiters);
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
