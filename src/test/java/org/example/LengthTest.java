package org.example;

import org.example.enums.TemperatureUnit;
import org.example.implementation.Length;
import org.example.enums.LengthUnit;
import org.example.interfaces.Measurable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthTest {
    // ------------------------------- Unit test to convert units -------------------------------
    @Test
    void testOneMeterToOneHundredCentimeters() throws Exception {
        Length expected = new Length(100.0, LengthUnit.CM);
        Length centimeters = new Length(1.0, LengthUnit.M);

        Length actual = centimeters.convert(LengthUnit.CM);

        assertEquals(expected, actual);
    }

    @Test
    void testOneKilometerToOneThousandMeter() throws Exception {
        Length expected = new Length(1000.0, LengthUnit.M);
        Length centimeters = new Length(1.0, LengthUnit.KM);

        Length actual = centimeters.convert(LengthUnit.M);

        assertEquals(expected, actual);
    }

    // ------------------------------- Unit test to add two units -------------------------------
    @Test
    void testAddFiveHundredMetersToOneKilometers() throws Exception {
        Length expected = new Length(1.5, LengthUnit.KM);

        Length kilometer = new Length(1.0, LengthUnit.KM);
        Length meter = new Length(500.0, LengthUnit.M);

        Measurable actual = kilometer.add(meter);

        assertEquals(expected, actual);
    }

    @Test
    void testAdd2KilometerToOneThousandMillimeters() throws Exception {
        Length expected = new Length(2000500.0, LengthUnit.MM);

        Length kilometer = new Length(2.0, LengthUnit.KM);
        Length millimeter = new Length(500.0, LengthUnit.MM);

        Measurable actual = millimeter.add(kilometer);

        assertEquals(expected, actual);
    }

    // ------------------------------- Unit test to subtract two units -------------------------------
    @Test
    void testSubFiveHundredMetersFromOneKilometers() throws Exception {
        Length expected = new Length(0.5, LengthUnit.KM);

        Length kilometer = new Length(1.0, LengthUnit.KM);
        Length meter = new Length(500.0, LengthUnit.M);

        Measurable actual = kilometer.sub(meter);

        assertEquals(expected, actual);
    }

    @Test
    void testSubHalfKilometersFromTwoThousandMeters() throws Exception {
        Length expected = new Length(0.5, LengthUnit.KM);

        Length kilometer = new Length(1.0, LengthUnit.KM);
        Length meter = new Length(500.0, LengthUnit.M);

        Measurable actual = kilometer.sub(meter);

        assertEquals(expected, actual);
    }

    @Test
    void testSubTwoKilometersFromFiveThousandMeters() throws Exception {
        Length expected = new Length(3000.0, LengthUnit.M);

        Length kilometer = new Length(2.0, LengthUnit.KM);
        Length meter = new Length(5000.0, LengthUnit.M);

        Measurable actual = meter.sub(kilometer);

        assertEquals(expected, actual);
    }

    @Test
    void testSubTenThousandMillimetersFromFiveThousandMeters() throws Exception {
        Length expected = new Length(4990.0, LengthUnit.M);

        Length millimeter = new Length(10000.0, LengthUnit.MM);
        Length meter = new Length(5000.0, LengthUnit.M);

        Measurable actual = meter.sub(millimeter);

        assertEquals(expected, actual);
    }

    // ------------------------------- Unit test to compare two units -------------------------------
    /*
        1 -> calling object's value is greater than the argument
        0 -> calling object's value is equal to the argument
       -1 -> calling object's value is less than the argument
    */
    @Test
    void testCompareOneMeterWithOneHundredCentimeter() throws Exception {
        int expected = 1; // 1.0M < 2000CM

        Length centimeter = new Length(2000.0, LengthUnit.CM);
        Length meter = new Length(1.0, LengthUnit.M);

        int actual = centimeter.compare(meter);

        assertEquals(expected, actual);
    }

    // ------------------------------- unit test to check error while using incompatible unit types -------------------------------
    @Test
    void testConvertWithIncompatibleUnitThrowsExceptionForVolume() throws Exception {
        Length centimeter = new Length(1.0, LengthUnit.CM);

        assertThrows(ClassCastException.class, () -> {
            centimeter.convert(TemperatureUnit.CELSIUS);
        });
    }
}