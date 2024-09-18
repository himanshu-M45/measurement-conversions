package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeasurementTest {
    @Test
    void testOneLiterToOneThousandMilliliters() throws Exception {
        Measurement expected = new Measurement(0.001, Unit.KL);
        Measurement measurement = new Measurement(1.0, Unit.L);

        Measurement actual = measurement.convert(Unit.KL);

        assertEquals(expected, actual);
    }

    @Test
    void testTwoThousandMillilitersToOneLiters() throws Exception {
        Measurement expected = new Measurement(2.0, Unit.L);
        Measurement measurement = new Measurement(2000.0, Unit.ML);

        Measurement actual = measurement.convert(Unit.L);

        assertEquals(expected, actual);
    }

    @Test
    void testOneLiterToTenDeciliters() throws Exception {
        Measurement expected = new Measurement(10.0, Unit.DL);
        Measurement measurement = new Measurement(1.0, Unit.L);

        Measurement actual = measurement.convert(Unit.DL);

        assertEquals(expected, actual);
    }

    @Test
    void testOneThousandLiterToOneKiloliters() throws Exception {
        Measurement expected = new Measurement(1.0, Unit.KL);
        Measurement measurement = new Measurement(1000.0, Unit.L);

        Measurement actual = measurement.convert(Unit.KL);

        assertEquals(expected, actual);
    }

    @Test
    void testOneLiterToOneHundredCentiliters() throws Exception {
        Measurement expected = new Measurement(100.0, Unit.CL);
        Measurement measurement = new Measurement(1.0, Unit.L);

        Measurement actual = measurement.convert(Unit.CL);

        assertEquals(expected, actual);
    }

    @Test
    void testOneHundredCentiliterToOneThousandMilliliters() throws Exception {
        Measurement expected = new Measurement(1000.0, Unit.ML);
        Measurement measurement = new Measurement(100.0, Unit.CL);

        Measurement actual = measurement.convert(Unit.ML);

        assertEquals(expected, actual);
    }

    @Test
    void testOneHundredDeciliterToOneThousandCentiliter() throws Exception {
        Measurement expected = new Measurement(1000.0, Unit.CL);
        Measurement measurement = new Measurement(100.0, Unit.DL);

        Measurement actual = measurement.convert(Unit.CL);

        assertEquals(expected, actual);
    }

    @Test
    void testFiveKilolitersToFiveLacCentiliter() throws Exception {
        Measurement expected = new Measurement(500000.0, Unit.CL);
        Measurement measurement = new Measurement(5.0, Unit.KL);

        Measurement actual = measurement.convert(Unit.CL);

        assertEquals(expected, actual);
    }

    @Test
    void testFiveLacCentilitersToFiveThousandLiter() throws Exception {
        Measurement expected = new Measurement(5000.0, Unit.L);
        Measurement measurement = new Measurement(500000.0, Unit.CL);

        Measurement actual = measurement.convert(Unit.L);

        assertEquals(expected, actual);
    }

    @Test
    void testInputCannotBe0Value() throws Exception {
        assertThrows(Exception.class, () -> new Measurement(0.0, Unit.L));
    }

    @Test
    void testInputCannotBeNegative() throws Exception {
        assertThrows(Exception.class, () -> new Measurement(-9.0,  Unit.L));
    }

    // tests for mass unit
    @Test
    void testFiveHundredGramToHalfKilogram() throws Exception {
        Measurement expected = new Measurement(0.5, Unit.KG);
        Measurement kilogram = new Measurement(500, Unit.G);

        Measurement actual = kilogram.convert(Unit.KG);

        assertEquals(expected, actual);
    }

    @Test
    void testTenGramsToOneThousandMilligram() throws Exception {
        Measurement expected = new Measurement(1000.0, Unit.MG);
        Measurement kilogram = new Measurement(1, Unit.G);

        Measurement actual = kilogram.convert(Unit.MG);

        assertEquals(expected, actual);
    }

    // tests for length unit
    @Test
    void testOneMeterToOneHundredCentimeters() throws Exception {
        Measurement expected = new Measurement(100.0, Unit.CM);
        Measurement centimeters = new Measurement(1.0, Unit.M);

        Measurement actual = centimeters.convert(Unit.CM);

        assertEquals(expected, actual);
    }

    @Test
    void testOneKilometerToOneThousandMeter() throws Exception {
        Measurement expected = new Measurement(1000.0, Unit.M);
        Measurement centimeters = new Measurement(1.0, Unit.KM);

        Measurement actual = centimeters.convert(Unit.M);

        assertEquals(expected, actual);
    }

    // unit test to check how function responds to different conversion types
    @Test
    void testConvertOneLiterToOneCentimeters() throws Exception {
        Measurement liter = new Measurement(1.0, Unit.L);

        Exception exception = assertThrows(Exception.class, () -> {liter.convert(Unit.CM);});

        assertEquals("Different types of measurements", exception.getMessage());
    }

    @Test
    void testAddOneMilliliterToOneLiter() throws Exception {
        Measurement expected = new Measurement(1.001, Unit.L);

        Measurement liter = new Measurement(1.0, Unit.L);
        Measurement milliliter = new Measurement(1.0, Unit.ML);

        Measurement actual = liter.add(milliliter, Unit.L);

        assertEquals(expected, actual);
    }

    @Test
    void testAddFiveHundredMetersToOneKilometers() throws Exception {
        Measurement expected = new Measurement(1.5, Unit.KM);

        Measurement kilometer = new Measurement(1.0, Unit.KM);
        Measurement meter = new Measurement(500.0, Unit.M);

        Measurement actual = kilometer.add(meter, Unit.KM);

        assertEquals(expected, actual);
    }

    @Test
    void testAddSevenHundredGramToOneKilogram() throws Exception {
        Measurement expected = new Measurement(1.7, Unit.KG);

        Measurement kilogram = new Measurement(1, Unit.KG);
        Measurement gram = new Measurement(700.0, Unit.G);

        Measurement actual = kilogram.add(gram, Unit.KG);

        assertEquals(expected, actual);
    }

    // unit test to check how function responds to different conversion types
    @Test
    void testAddOneLiterToOneCentimeters() throws Exception {
        Measurement liter = new Measurement(1.0, Unit.L);
        Measurement centimeters = new Measurement(1.0, Unit.CM);

        Exception exception = assertThrows(Exception.class, () -> {liter.add(centimeters, Unit.CM);});

        assertEquals("Cannot convert between different Units", exception.getMessage());
    }
}