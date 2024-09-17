package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VolumeTest {
    @Test
    void testOneLiterToOneThousandMilliliters() throws Exception {
        double expected = 1000.0;
        Volume volume = new Volume(1.0, Units.LITER);

        double actual = volume.convert(String.valueOf(Units.MILLILITER));

        assertEquals(expected, actual);
    }

    @Test
    void testTwoThousandMillilitersToOneLiters() throws Exception {
        double expected = 2.0;
        Volume volume = new Volume(2000.0, Units.MILLILITER);

        double actual = volume.convert(String.valueOf(Units.LITER));

        assertEquals(expected, actual);
    }

    @Test
    void testOneLiterToTenDeciliters() throws Exception {
        double expected = 10.0;
        Volume volume = new Volume(1.0, Units.LITER);

        double actual = volume.convert(String.valueOf(Units.DECILITER));

        assertEquals(expected, actual);
    }

    @Test
    void testOneThousandLiterToOneKiloliters() throws Exception {
        double expected = 1.0;
        Volume volume = new Volume(1000.0, Units.LITER);

        double actual = volume.convert(String.valueOf(Units.KILOLITER));

        assertEquals(expected, actual);
    }

    @Test
    void testOneLiterToOneHundredCentiliters() throws Exception {
        double expected = 100.0;
        Volume volume = new Volume(1.0, Units.LITER);

        double actual = volume.convert(String.valueOf(Units.CENTILITER));

        assertEquals(expected, actual);
    }

    @Test
    void testInputCannotBe0Value() throws Exception {
        assertThrows(Exception.class, () -> new Volume(0.0, Units.LITER));
    }

    @Test
    void testInputCannotBeNegative() throws Exception {
        assertThrows(Exception.class, () -> new Volume(-9.0,  Units.LITER));
    }

}