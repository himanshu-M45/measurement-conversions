package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest {
    @Test
    void testOneLiterToOneThousandMilliliters() throws Exception {
        Unit expected = new Unit(0.001, Units.KL);
        Unit unit = new Unit(1.0, Units.L);

        Unit actual = unit.convert(Units.KL);

        assertEquals(expected, actual);
    }

    @Test
    void testTwoThousandMillilitersToOneLiters() throws Exception {
        Unit expected = new Unit(2.0, Units.L);
        Unit unit = new Unit(2000.0, Units.ML);

        Unit actual = unit.convert(Units.L);

        assertEquals(expected, actual);
    }

    @Test
    void testOneLiterToTenDeciliters() throws Exception {
        Unit expected = new Unit(10.0, Units.DL);
        Unit unit = new Unit(1.0, Units.L);

        Unit actual = unit.convert(Units.DL);

        assertEquals(expected, actual);
    }

    @Test
    void testOneThousandLiterToOneKiloliters() throws Exception {
        Unit expected = new Unit(1.0, Units.KL);
        Unit unit = new Unit(1000.0, Units.L);

        Unit actual = unit.convert(Units.KL);

        assertEquals(expected, actual);
    }

    @Test
    void testOneLiterToOneHundredCentiliters() throws Exception {
        Unit expected = new Unit(100.0, Units.CL);
        Unit unit = new Unit(1.0, Units.L);

        Unit actual = unit.convert(Units.CL);

        assertEquals(expected, actual);
    }

    @Test
    void testOneHundredCentiliterToOneThousandMilliliters() throws Exception {
        Unit expected = new Unit(1000.0, Units.ML);
        Unit unit = new Unit(100.0, Units.CL);

        Unit actual = unit.convert(Units.ML);

        assertEquals(expected, actual);
    }

    @Test
    void testOneHundredDeciliterToOneThousandCentiliter() throws Exception {
        Unit expected = new Unit(1000.0, Units.CL);
        Unit unit = new Unit(100.0, Units.DL);

        Unit actual = unit.convert(Units.CL);

        assertEquals(expected, actual);
    }

    @Test
    void testFiveKilolitersToFiveLacCentiliter() throws Exception {
        Unit expected = new Unit(500000.0, Units.CL);
        Unit unit = new Unit(5.0, Units.KL);

        Unit actual = unit.convert(Units.CL);

        assertEquals(expected, actual);
    }

    @Test
    void testFiveLacCentilitersToFiveThousandLiter() throws Exception {
        Unit expected = new Unit(5000.0, Units.L);
        Unit unit = new Unit(500000.0, Units.CL);

        Unit actual = unit.convert(Units.L);

        assertEquals(expected, actual);
    }

    @Test
    void testInputCannotBe0Value() throws Exception {
        assertThrows(Exception.class, () -> new Unit(0.0, Units.L));
    }

    @Test
    void testInputCannotBeNegative() throws Exception {
        assertThrows(Exception.class, () -> new Unit(-9.0,  Units.L));
    }

    // tests for mass unit
    @Test
    void testFiveHundredGramToHalfKilogram() throws Exception {
        Unit expected = new Unit(0.5, Units.KG);
        Unit kilogram = new Unit(500, Units.G);

        Unit actual = kilogram.convert(Units.KG);

        assertEquals(expected, actual);
    }

    @Test
    void testTenGramsToOneThousandMilligram() throws Exception {
        Unit expected = new Unit(1000.0, Units.MG);
        Unit kilogram = new Unit(1, Units.G);

        Unit actual = kilogram.convert(Units.MG);

        assertEquals(expected, actual);
    }

    // tests for length unit
    @Test
    void testOneMeterToOneHundredCentimeters() throws Exception {
        Unit expected = new Unit(100.0, Units.CM);
        Unit centimeters = new Unit(1.0, Units.M);

        Unit actual = centimeters.convert(Units.CM);

        assertEquals(expected, actual);
    }

    @Test
    void testOneKilometerToOneThousandMeter() throws Exception {
        Unit expected = new Unit(1000.0, Units.M);
        Unit centimeters = new Unit(1.0, Units.KM);

        Unit actual = centimeters.convert(Units.M);

        assertEquals(expected, actual);
    }

    // unit test to check how function responds to different conversion types
    @Test
    void testConvertOneLiterToOneCentimeters() throws Exception {
        Unit liter = new Unit(1.0, Units.L);

        Exception exception = assertThrows(Exception.class, () -> {liter.convert(Units.CM);});

        assertEquals("Cannot convert between different Units", exception.getMessage());
    }

    @Test
    void testAddOneMilliliterToOneLiter() throws Exception {
        Unit expected = new Unit(1.001, Units.L);

        Unit liter = new Unit(1.0, Units.L);
        Unit milliliter = new Unit(1.0, Units.ML);

        Unit actual = liter.add(milliliter, Units.L);

        assertEquals(expected, actual);
    }

    @Test
    void testAddFiveHundredMetersToOneKilometers() throws Exception {
        Unit expected = new Unit(1.5, Units.KM);

        Unit kilometer = new Unit(1.0, Units.KM);
        Unit meter = new Unit(500.0, Units.M);

        Unit actual = kilometer.add(meter, Units.KM);

        assertEquals(expected, actual);
    }

    @Test
    void testAddSevenHundredGramToOneKilogram() throws Exception {
        Unit expected = new Unit(1.7, Units.KG);

        Unit kilogram = new Unit(1, Units.KG);
        Unit gram = new Unit(700.0, Units.G);

        Unit actual = kilogram.add(gram, Units.KG);

        assertEquals(expected, actual);
    }

    // unit test to check how function responds to different conversion types
    @Test
    void testAddOneLiterToOneCentimeters() throws Exception {
        Unit liter = new Unit(1.0, Units.L);
        Unit centimeters = new Unit(1.0, Units.CM);

        Exception exception = assertThrows(Exception.class, () -> {liter.add(centimeters, Units.CM);});

        assertEquals("Cannot convert between different Units", exception.getMessage());
    }
}