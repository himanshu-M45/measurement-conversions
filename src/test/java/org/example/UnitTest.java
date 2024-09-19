package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest {
    @Test
    void testToConvertKiloliterToBaseUnit () {
        double expected = 1000.0;
        Unit kiloliters = Unit.KL;
        assertEquals(expected, kiloliters.toBaseUnit());
    }

    @Test
    void testToConvertMilliliterToVolumeUnit() {
        double expected = 1000.0;
        Unit milliliter = Unit.ML;
        assertEquals(expected, milliliter.fromBaseUnit());
    }

    @Test
    void testToConvertMeterToBaseUnit() {
        double expected = 1.0;
        Unit meter = Unit.M;
        assertEquals(expected, meter.toBaseUnit());
    }

    @Test
    void testToConvertKilometerToVolumeUnit() {
        double expected = 0.001;
        Unit kilometer = Unit.KM;
        assertEquals(expected, kilometer.fromBaseUnit());
    }

    @Test
    void testToConvertKilogramToBaseUnit() {
        double expected = 1000.0;
        Unit kilogram = Unit.KG;
        assertEquals(expected, kilogram.toBaseUnit());
    }

    @Test
    void testToConvertGramToVolumeUnit() {
        double expected = 1.0;
        Unit gram = Unit.G;
        assertEquals(expected, gram.fromBaseUnit());
    }

    @Test
    void testUnitType() {
        Unit.MeasurementType expected = Unit.MeasurementType.MASS;
        Unit unit = Unit.MG;
        assertEquals(expected, unit.getUnitType());
    }

    @Test
    void testTemperatureCelsiusToBaseUnit() {
        double expected = 1.0;
        Unit celsius = Unit.CELSIUS;
        assertEquals(expected, celsius.fromBaseUnit());
    }

    @Test
    void testTemperatureFahrenheitToBaseUnit() {
        double expected = 1.0;
        Unit fahrenheit = Unit.FAHRENHEIT;
        assertEquals(expected, fahrenheit.fromBaseUnit());
    }
}