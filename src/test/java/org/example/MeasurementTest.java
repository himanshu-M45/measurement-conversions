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

    // ------------------------------- unit test to add two units -------------------------------
    // unit test to check how function responds to different Measurement types of addition
    @Test
    void testAddOneLiterToOneCentimeters() throws Exception {
        Measurement liter = new Measurement(1.0, Unit.L);
        Measurement centimeters = new Measurement(1.0, Unit.CM);

        Exception exception = assertThrows(Exception.class, () -> {liter.add(centimeters);});

        assertEquals("Cannot convert between different Units", exception.getMessage());
    }

    @Test
    void testAddOneMilliliterToOneLiter() throws Exception {
        Measurement expected = new Measurement(1.001, Unit.L);

        Measurement liter = new Measurement(1.0, Unit.L);
        Measurement milliliter = new Measurement(1.0, Unit.ML);

        Measurement actual = liter.add(milliliter);

        assertEquals(expected, actual);
    }

    @Test
    void testAddOneDeciliterToTwoThousandMilliliter() throws Exception {
        Measurement expected = new Measurement(2100.0, Unit.ML);

        Measurement deciliter = new Measurement(1.0, Unit.DL);
        Measurement milliliter = new Measurement(2000.0, Unit.ML);

        Measurement actual = milliliter.add(deciliter);

        assertEquals(expected, actual);
    }

    @Test
    void testAddFiveThousandMilliliterToTwoCentiliter() throws Exception {
        Measurement expected = new Measurement(501., Unit.CL);

        Measurement milliliter = new Measurement(5000.0, Unit.ML);
        Measurement centiliter = new Measurement(1.0, Unit.CL);

        Measurement actual = centiliter.add(milliliter);

        assertEquals(expected, actual);
    }

    @Test
    void testAddFiveHundredMetersToOneKilometers() throws Exception {
        Measurement expected = new Measurement(1.5, Unit.KM);

        Measurement kilometer = new Measurement(1.0, Unit.KM);
        Measurement meter = new Measurement(500.0, Unit.M);

        Measurement actual = kilometer.add(meter);

        assertEquals(expected, actual);
    }

    @Test
    void testAdd2KilometerToOneThousandMillimeters() throws Exception {
        Measurement expected = new Measurement(2000500.0, Unit.MM);

        Measurement kilometer = new Measurement(2.0, Unit.KM);
        Measurement millimeter = new Measurement(500.0, Unit.MM);

        Measurement actual = millimeter.add(kilometer);

        assertEquals(expected, actual);
    }

    @Test
    void testAddSevenHundredGramToOneKilogram() throws Exception {
        Measurement expected = new Measurement(1.7, Unit.KG);

        Measurement kilogram = new Measurement(1, Unit.KG);
        Measurement gram = new Measurement(700.0, Unit.G);

        Measurement actual = kilogram.add(gram);

        assertEquals(expected, actual);
    }

    @Test
    void testAddSevenKilogramToOneThousandGrams() throws Exception {
        Measurement expected = new Measurement(8000.0, Unit.G);

        Measurement kilogram = new Measurement(7, Unit.KG);
        Measurement gram = new Measurement(1000.0, Unit.G);

        Measurement actual = gram.add(kilogram);

        assertEquals(expected, actual);
    }

    // ------------------------------- unit test to subtract two units -------------------------------
    // unit test to check how function responds to different Measurement types of subtraction
    @Test
    void testSubOneLiterToOneCentimeters() throws Exception {
        Measurement liter = new Measurement(1.0, Unit.L);
        Measurement centimeters = new Measurement(1.0, Unit.CM);

        Exception exception = assertThrows(Exception.class, () -> {liter.sub(centimeters);});

        assertEquals("Cannot convert between different Units", exception.getMessage());
    }

    @Test
    void testSubOneMilliliterFromOneLiter() throws Exception {
        Measurement expected = new Measurement(0.5, Unit.L);

        Measurement liter = new Measurement(1.0, Unit.L);
        Measurement milliliter = new Measurement(500, Unit.ML);

        Measurement actual = liter.sub(milliliter);

        assertEquals(expected, actual);
    }

    @Test
    void testSubFiveHundredMetersFromOneKilometers() throws Exception {
        Measurement expected = new Measurement(0.5, Unit.KM);

        Measurement kilometer = new Measurement(1.0, Unit.KM);
        Measurement meter = new Measurement(500.0, Unit.M);

        Measurement actual = kilometer.sub(meter);

        assertEquals(expected, actual);
    }

    @Test
    void testSubHalfKilometersFromTwoThousandMeters() throws Exception {
        Measurement expected = new Measurement(0.5, Unit.KM);

        Measurement kilometer = new Measurement(1.0, Unit.KM);
        Measurement meter = new Measurement(500.0, Unit.M);

        Measurement actual = kilometer.sub(meter);

        assertEquals(expected, actual);
    }

    @Test
    void testSubTwoKilometersFromFiveThousandMeters() throws Exception {
        Measurement expected = new Measurement(3000.0, Unit.M);

        Measurement kilometer = new Measurement(2.0, Unit.KM);
        Measurement meter = new Measurement(5000.0, Unit.M);

        Measurement actual = meter.sub(kilometer);

        assertEquals(expected, actual);
    }

    @Test
    void testSubTenThousandMillimetersFromFiveThousandMeters() throws Exception {
        Measurement expected = new Measurement(4990.0, Unit.M);

        Measurement millimeter = new Measurement(10000.0, Unit.MM);
        Measurement meter = new Measurement(5000.0, Unit.M);

        Measurement actual = meter.sub(millimeter);

        assertEquals(expected, actual);
    }

    @Test
    void testSubTenKilogramFromFifteenThousandGrams() throws Exception {
        Measurement expected = new Measurement(5000.0, Unit.G);

        Measurement gram = new Measurement(15000.0, Unit.G);
        Measurement kilogram = new Measurement(10.0, Unit.KG);

        Measurement actual = gram.sub(kilogram);

        assertEquals(expected, actual);
    }

    @Test
    void testSubTenThousandMilligramFromTenGrams() throws Exception {
        Measurement expected = new Measurement(0.0, Unit.G);

        Measurement gram = new Measurement(10.0, Unit.G);
        Measurement milligram = new Measurement(10000.0, Unit.MG);

        Measurement actual = gram.sub(milligram);

        assertEquals(expected, actual);
    }

    // ------------------------------- unit test to subtract two units -------------------------------
    /*
        1 -> calling object's value is greater than the argument
        0 -> calling object's value is equal to the argument
       -1 -> calling object's value is less than the argument
    */
    // unit test to check how function responds to different Measurement types of comparison
    @Test
    void testCompareOneLiterToOneCentimeters() throws Exception {
        Measurement liter = new Measurement(1.0, Unit.L);
        Measurement centimeters = new Measurement(1.0, Unit.CM);

        Exception exception = assertThrows(Exception.class, () -> {liter.compare(centimeters);});

        assertEquals("Cannot convert between different Units", exception.getMessage());
    }

    @Test
    void testCompareOneLiterToOneThousandMilliliter() throws Exception {
        int expected = 0; // 1000ML == 1.0L

        Measurement milliliter = new Measurement(1000.0, Unit.ML);
        Measurement liter = new Measurement(1.0, Unit.L);

        int actual = milliliter.compare(liter);

        assertEquals(expected, actual);
    }

    @Test
    void testCompareOneThousandFiveHundredGramToOneKilogram() throws Exception {
        int expected = -1; // 1500G > 1KG

        Measurement kilogram = new Measurement(1.0, Unit.KG);
        Measurement gram = new Measurement(1500.0, Unit.G);

        int actual = kilogram.compare(gram);

        assertEquals(expected, actual);
    }

    @Test
    void testCompareOneMeterToOneHundredCentimeter() throws Exception {
        int expected = 1; // 1.0M < 2000CM

        Measurement centimeter = new Measurement(2000.0, Unit.CM);
        Measurement meter = new Measurement(1.0, Unit.M);

        int actual = centimeter.compare(meter);

        assertEquals(expected, actual);
    }
}