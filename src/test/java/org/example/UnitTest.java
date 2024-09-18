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

    @Test
    void testOneLiterToOneCentimeters() throws Exception {
        Unit liter = new Unit(1.0, Units.L);

        Exception exception = assertThrows(Exception.class, () -> {
            liter.convert(Units.CM);
        });
        assertEquals("Cannot convert between different Units", exception.getMessage());
    }
}