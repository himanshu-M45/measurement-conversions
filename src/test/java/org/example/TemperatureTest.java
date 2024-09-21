package org.example;

import org.example.enums.TemperatureUnit;
import org.example.enums.VolumeUnit;
import org.example.implementation.Temperature;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureTest {
    // ------------------------------- unit test to convert units -------------------------------
    @Test
    void testConvertTenCelsiusToFiftyFahrenheit() throws Exception {
        Temperature expected = new Temperature(50.0, TemperatureUnit.FAHRENHEIT);
        Temperature fahrenheit = new Temperature(10.0, TemperatureUnit.CELSIUS);

        Temperature actual = fahrenheit.convert(TemperatureUnit.FAHRENHEIT);

        assertEquals(expected, actual);
    }

    @Test
    void testConvertEightySixFahrenheitToThirtyCelsius() throws Exception {
        Temperature expected = new Temperature(30.0, TemperatureUnit.CELSIUS);
        Temperature fahrenheit = new Temperature(86.0, TemperatureUnit.FAHRENHEIT);

        Temperature actual = fahrenheit.convert(TemperatureUnit.CELSIUS);

        assertEquals(expected, actual);
    }

    @Test
    void testConvertTenFahrenheitToCelsius() throws Exception { // expecting negative output
        Temperature expected = new Temperature(-12.222222222222221, TemperatureUnit.CELSIUS);
        Temperature fahrenheit = new Temperature(10.0, TemperatureUnit.FAHRENHEIT);

        Temperature actual = fahrenheit.convert(TemperatureUnit.CELSIUS);

        assertEquals(expected, actual);
    }

    // ------------------------------- unit test to compare two units -------------------------------
    /*
        1 -> calling object's value is greater than the argument
        0 -> calling object's value is equal to the argument
       -1 -> calling object's value is less than the argument
    */
    @Test
    void testCompareFiftyNineFahrenheitWithFifteenCelsius() throws Exception {
        int expected = 0; // 15C == 59F

        Temperature celsius = new Temperature(15.0, TemperatureUnit.CELSIUS);
        Temperature fahrenheit = new Temperature(59.0, TemperatureUnit.FAHRENHEIT);

        int actual = celsius.compare(fahrenheit);

        assertEquals(expected, actual);
    }

    // ------------------------------- unit test to check error while using add() & sub() -------------------------------
    @Test
    void testAddThrowsException() throws Exception {
        Temperature temperature1 = new Temperature(10.0, TemperatureUnit.CELSIUS);
        Temperature temperature2 = new Temperature(5.0, TemperatureUnit.CELSIUS);

        assertThrows(UnsupportedOperationException.class, () -> {
            temperature1.add(temperature2);
        });
    }

    @Test
    void testSubThrowsException() throws Exception {
        Temperature temperature1 = new Temperature(10.0, TemperatureUnit.CELSIUS);
        Temperature temperature2 = new Temperature(5.0, TemperatureUnit.CELSIUS);

        assertThrows(UnsupportedOperationException.class, () -> {
            temperature1.sub(temperature2);
        });
    }

    // ------------------------------- unit test to check error while using incompatible unit types -------------------------------
    @Test
    void testConvertWithIncompatibleUnitThrowsException() throws Exception {
        Temperature celsius = new Temperature(10.0, TemperatureUnit.CELSIUS);

        assertThrows(ClassCastException.class, () -> {
            celsius.convert(VolumeUnit.L);
        });
    }
}