package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VolumeUnitTest {
    @Test
    void testToConvertKiloliterToBaseUnit () {
        double expected = 1000.0;
        VolumeUnit kiloliters = VolumeUnit.KL;
        assertEquals(expected, kiloliters.toBaseUnit());
    }

    @Test
    void testToConvertMilliliterToVolumeUnit() {
        double expected = 1000.0;
        VolumeUnit milliliter = VolumeUnit.ML;
        assertEquals(expected, milliliter.fromBaseUnit());
    }

    @Test
    void testToConvertMeterToBaseUnit() {
        double expected = 1.0;
        VolumeUnit meter = VolumeUnit.M;
        assertEquals(expected, meter.toBaseUnit());
    }

    @Test
    void testToConvertKilometerToVolumeUnit() {
        double expected = 0.001;
        VolumeUnit kilometer = VolumeUnit.KM;
        assertEquals(expected, kilometer.fromBaseUnit());
    }

    @Test
    void testToConvertKilogramToBaseUnit() {
        double expected = 1000.0;
        VolumeUnit kilogram = VolumeUnit.KG;
        assertEquals(expected, kilogram.toBaseUnit());
    }

    @Test
    void testToConvertGramToVolumeUnit() {
        double expected = 1.0;
        VolumeUnit gram = VolumeUnit.G;
        assertEquals(expected, gram.fromBaseUnit());
    }

}