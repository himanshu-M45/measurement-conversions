package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VolumeTest {
    @Test
    void testOneLiterToOneThousandMilliliters() throws Exception {
        double expected = 0.001;
        Volume volume = new Volume(1.0, VolumeUnit.L);

        double actual = volume.convert(VolumeUnit.KL);

        assertEquals(expected, actual);
    }

    @Test
    void testTwoThousandMillilitersToOneLiters() throws Exception {
        double expected = 2.0;
        Volume volume = new Volume(2000.0, VolumeUnit.ML);

        double actual = volume.convert(VolumeUnit.L);

        assertEquals(expected, actual);
    }

    @Test
    void testOneLiterToTenDeciliters() throws Exception {
        double expected = 10.0;
        Volume volume = new Volume(1.0, VolumeUnit.L);

        double actual = volume.convert(VolumeUnit.DL);

        assertEquals(expected, actual);
    }

    @Test
    void testOneThousandLiterToOneKiloliters() throws Exception {
        double expected = 1.0;
        Volume volume = new Volume(1000.0, VolumeUnit.L);

        double actual = volume.convert(VolumeUnit.KL);

        assertEquals(expected, actual);
    }

    @Test
    void testOneLiterToOneHundredCentiliters() throws Exception {
        double expected = 100.0;
        Volume volume = new Volume(1.0, VolumeUnit.L);

        double actual = volume.convert(VolumeUnit.CL);

        assertEquals(expected, actual);
    }

    @Test
    void testOneHundredCentiliterToOneThousandMilliliters() throws Exception {
        double expected = 1000.0;
        Volume volume = new Volume(100.0, VolumeUnit.CL);

        double actual = volume.convert(VolumeUnit.ML);

        assertEquals(expected, actual);
    }

    @Test
    void testOneHundredDeciliterToOneThousandCentiliter() throws Exception {
        double expected = 1000.0;
        Volume volume = new Volume(100.0, VolumeUnit.DL);

        double actual = volume.convert(VolumeUnit.CL);

        assertEquals(expected, actual);
    }

    @Test
    void testFiveKilolitersToFiveLacCentiliter() throws Exception {
        double expected = 500000.0;
        Volume volume = new Volume(5.0, VolumeUnit.KL);

        double actual = volume.convert(VolumeUnit.CL);

        assertEquals(expected, actual);
    }

    @Test
    void testFiveLacCentilitersToFiveThousandLiter() throws Exception {
        double expected = 5000.0;
        Volume volume = new Volume(500000.0, VolumeUnit.CL);

        double actual = volume.convert(VolumeUnit.L);

        assertEquals(expected, actual);
    }

    @Test
    void testInputCannotBe0Value() throws Exception {
        assertThrows(Exception.class, () -> new Volume(0.0, VolumeUnit.L));
    }

    @Test
    void testInputCannotBeNegative() throws Exception {
        assertThrows(Exception.class, () -> new Volume(-9.0,  VolumeUnit.L));
    }

    // tests for mass unit
    @Test
    void testFiveHundredGramToHalfKilogram() throws Exception {
        double expected = 0.5;
        Volume kilogram = new Volume(500, VolumeUnit.G);

        double actual = kilogram.convert(VolumeUnit.KG);

        assertEquals(expected, actual);
    }

    @Test
    void testTenGramsToOneThousandMilligram() throws Exception {
        double expected = 1000.0;
        Volume kilogram = new Volume(1, VolumeUnit.G);

        double actual = kilogram.convert(VolumeUnit.MG);

        assertEquals(expected, actual);
    }

    // tests for length unit
    @Test
    void testOneMeterToOneHundredCentimeters() throws Exception {
        double expected = 100.0;
        Volume centimeters = new Volume(1.0, VolumeUnit.M);

        double actual = centimeters.convert(VolumeUnit.CM);

        assertEquals(expected, actual);
    }

    @Test
    void testOneKilometerToOneThousandMeter() throws Exception {
        double expected = 1000.0;
        Volume centimeters = new Volume(1.0, VolumeUnit.KM);

        double actual = centimeters.convert(VolumeUnit.M);

        assertEquals(expected, actual);
    }
}