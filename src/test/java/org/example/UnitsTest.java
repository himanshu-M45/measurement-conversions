package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitsTest {
    @Test
    void testToConvertKiloliterToBaseUnit () {
        double expected = 1000.0;
        Units kiloliters = Units.KL;
        assertEquals(expected, kiloliters.toBaseUnit());
    }

    @Test
    void testToConvertMilliliterToVolumeUnit() {
        double expected = 1000.0;
        Units milliliter = Units.ML;
        assertEquals(expected, milliliter.fromBaseUnit());
    }

    @Test
    void testToConvertMeterToBaseUnit() {
        double expected = 1.0;
        Units meter = Units.M;
        assertEquals(expected, meter.toBaseUnit());
    }

    @Test
    void testToConvertKilometerToVolumeUnit() {
        double expected = 0.001;
        Units kilometer = Units.KM;
        assertEquals(expected, kilometer.fromBaseUnit());
    }

    @Test
    void testToConvertKilogramToBaseUnit() {
        double expected = 1000.0;
        Units kilogram = Units.KG;
        assertEquals(expected, kilogram.toBaseUnit());
    }

    @Test
    void testToConvertGramToVolumeUnit() {
        double expected = 1.0;
        Units gram = Units.G;
        assertEquals(expected, gram.fromBaseUnit());
    }

    @Test
    void testUnitType() {
        Units.UnitType expected = Units.UnitType.MASS;
        Units unit = Units.MG;
        assertEquals(expected, unit.getUnitType());
    }

}