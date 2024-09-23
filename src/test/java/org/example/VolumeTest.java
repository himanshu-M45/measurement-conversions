package org.example;

import org.example.enums.VolumeUnit;
import org.example.enums.WeightUnit;
import org.example.implementation.Volume;
import org.example.interfaces.Measurable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VolumeTest {
    // ------------------------------- unit test to convert units -------------------------------
    @Test
    void testOneLiterToPointZeroZeroOneKiloliters() throws Exception {
        Volume expected = new Volume(0.001, VolumeUnit.KL);
        Volume volume = new Volume(1.0, VolumeUnit.L);

        Volume actual = volume.convert(VolumeUnit.KL);

        assertEquals(expected, actual);
    }

    @Test
    void testTwoThousandMillilitersToTwoLiters() throws Exception {
        Volume expected = new Volume(2.0, VolumeUnit.L);
        Volume volume = new Volume(2000.0, VolumeUnit.ML);

        Volume actual = volume.convert(VolumeUnit.L);

        assertEquals(expected, actual);
    }

    @Test
    void testOneLiterToTenDeciliters() throws Exception {
        Volume expected = new Volume(10.0, VolumeUnit.DL);
        Volume volume = new Volume(1.0, VolumeUnit.L);

        Volume actual = volume.convert(VolumeUnit.DL);

        assertEquals(expected, actual);
    }

    @Test
    void testOneThousandLiterToOneKiloliters() throws Exception {
        Volume expected = new Volume(1.0, VolumeUnit.KL);
        Volume volume = new Volume(1000.0, VolumeUnit.L);

        Volume actual = volume.convert(VolumeUnit.KL);

        assertEquals(expected, actual);
    }

    @Test
    void testOneLiterToOneHundredCentiliters() throws Exception {
        Volume expected = new Volume(100.0, VolumeUnit.CL);
        Volume volume = new Volume(1.0, VolumeUnit.L);

        Volume actual = volume.convert(VolumeUnit.CL);

        assertEquals(expected, actual);
    }

    @Test
    void testOneHundredCentiliterToOneThousandMilliliters() throws Exception {
        Volume expected = new Volume(1000.0, VolumeUnit.ML);
        Volume volume = new Volume(100.0, VolumeUnit.CL);

        Volume actual = volume.convert(VolumeUnit.ML);

        assertEquals(expected, actual);
    }

    @Test
    void testOneHundredDeciliterToOneThousandCentiliter() throws Exception {
        Volume expected = new Volume(1000.0, VolumeUnit.CL);
        Volume volume = new Volume(100.0, VolumeUnit.DL);

        Volume actual = volume.convert(VolumeUnit.CL);

        assertEquals(expected, actual);
    }

    @Test
    void testFiveKilolitersToFiveLacCentiliter() throws Exception {
        Volume expected = new Volume(500000.0, VolumeUnit.CL);
        Volume volume = new Volume(5.0, VolumeUnit.KL);

        Volume actual = volume.convert(VolumeUnit.CL);

        assertEquals(expected, actual);
    }

    @Test
    void testFiveLacCentilitersToFiveThousandLiter() throws Exception {
        Volume expected = new Volume(5000.0, VolumeUnit.L);
        Volume volume = new Volume(500000.0, VolumeUnit.CL);

        Volume actual = volume.convert(VolumeUnit.L);

        assertEquals(expected, actual);
    }

    @Test
    void testInputCannotBeNegative() throws IllegalAccessException {
        assertThrows(IllegalAccessException.class, () -> new Volume(-9.0, VolumeUnit.L));
    }

    // ------------------------------- unit test to add two units -------------------------------
    @Test
    void testAddOneMilliliterToOneLiter() throws Exception {
        Volume expected = new Volume(1.001, VolumeUnit.L);

        Volume liter = new Volume(1.0, VolumeUnit.L);
        Volume milliliter = new Volume(1.0, VolumeUnit.ML);

        Measurable actual = liter.add(milliliter);

        assertEquals(expected, actual);
    }

    @Test
    void testAddOneDeciliterToTwoThousandMilliliter() throws Exception {
        Volume expected = new Volume(2100.0, VolumeUnit.ML);

        Volume deciliter = new Volume(1.0, VolumeUnit.DL);
        Volume milliliter = new Volume(2000.0, VolumeUnit.ML);

        Measurable actual = milliliter.add(deciliter);

        assertEquals(expected, actual);
    }

    @Test
    void testAddFiveThousandMilliliterToTwoCentiliter() throws Exception {
        Volume expected = new Volume(501., VolumeUnit.CL);

        Volume milliliter = new Volume(5000.0, VolumeUnit.ML);
        Volume centiliter = new Volume(1.0, VolumeUnit.CL);

        Measurable actual = centiliter.add(milliliter);

        assertEquals(expected, actual);
    }

    // ------------------------------- unit test to subtract two units -------------------------------
    @Test
    void testSubOneMilliliterFromOneLiter() throws Exception {
        Volume expected = new Volume(0.5, VolumeUnit.L);

        Volume liter = new Volume(1.0, VolumeUnit.L);
        Volume milliliter = new Volume(500, VolumeUnit.ML);

        Measurable actual = liter.sub(milliliter);

        assertEquals(expected, actual);
    }

    // ------------------------------- unit test to subtract two units -------------------------------
    /*
        1 -> calling object's value is greater than the argument
        0 -> calling object's value is equal to the argument
       -1 -> calling object's value is less than the argument
    */
    @Test
    void testCompareOneLiterWithOneThousandMilliliter() throws Exception {
        int expected = 0; // 1000ML == 1.0L

        Volume milliliter = new Volume(1000.0, VolumeUnit.ML);
        Volume liter = new Volume(1.0, VolumeUnit.L);

        int actual = milliliter.compare(liter);

        assertEquals(expected, actual);
    }

    // ------------------------------- unit test to check error while using incompatible unit types -------------------------------
    @Test
    void testConvertWithIncompatibleUnitThrowsExceptionForVolume() throws Exception {
        Volume liter = new Volume(1.0, VolumeUnit.L);

        assertThrows(ClassCastException.class, () -> {
            liter.convert(WeightUnit.KG);
        });
    }
}