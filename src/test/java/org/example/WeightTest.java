package org.example;

import org.example.enums.VolumeUnit;
import org.example.enums.WeightUnit;
import org.example.implementation.Weight;
import org.example.interfaces.Measurable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeightTest {
    // ------------------------------- unit test to convert units -------------------------------
    @Test
    void testFiveHundredGramToHalfKilogram() throws Exception {
        Weight expected = new Weight(0.5, WeightUnit.KG);
        Weight kilogram = new Weight(500, WeightUnit.G);

        Measurable actual = kilogram.convert(WeightUnit.KG);

        assertEquals(expected, actual);
    }

    @Test
    void testTenGramsToOneThousandMilligram() throws Exception {
        Weight expected = new Weight(1000.0, WeightUnit.MG);
        Weight kilogram = new Weight(1, WeightUnit.G);

        Measurable actual = kilogram.convert(WeightUnit.MG);

        assertEquals(expected, actual);
    }

    // ------------------------------- unit test to add two units -------------------------------
    @Test
    void testAddSevenHundredGramToOneKilogram() throws Exception {
        Weight expected = new Weight(1.07, WeightUnit.KG);

        Weight kilogram = new Weight(1, WeightUnit.KG);
        Weight gram = new Weight(70.0, WeightUnit.G);

        Measurable actual = kilogram.add(gram);

        assertEquals(expected, actual);
    }

    @Test
    void testAddSevenKilogramToOneThousandGrams() throws Exception {
        Weight expected = new Weight(8000.0, WeightUnit.G);

        Weight kilogram = new Weight(7, WeightUnit.KG);
        Weight gram = new Weight(1000.0, WeightUnit.G);

        Measurable actual = gram.add(kilogram);

        assertEquals(expected, actual);
    }

    // ------------------------------- unit test to subtract two units -------------------------------
    @Test
    void testSubTenKilogramFromFifteenThousandGrams() throws Exception {
        Weight expected = new Weight(5000.0, WeightUnit.G);

        Weight gram = new Weight(15000.0, WeightUnit.G);
        Weight kilogram = new Weight(10.0, WeightUnit.KG);

        Measurable actual = gram.sub(kilogram);

        assertEquals(expected, actual);
    }

    @Test
    void testSubTenThousandMilligramFromTenGrams() throws Exception {
        Weight expected = new Weight(0.0, WeightUnit.G);

        Weight gram = new Weight(10.0, WeightUnit.G);
        Weight milligram = new Weight(10000.0, WeightUnit.MG);

        Measurable actual = gram.sub(milligram);

        assertEquals(expected, actual);
    }

    // ------------------------------- unit test to subtract two units -------------------------------
    /*
        1 -> calling object's value is greater than the argument
        0 -> calling object's value is equal to the argument
       -1 -> calling object's value is less than the argument
    */
    @Test
    void testCompareOneThousandFiveHundredGramWithOneKilogram() throws Exception {
        int expected = -1; // 1500G > 1KG

        Weight kilogram = new Weight(1.0, WeightUnit.KG);
        Weight gram = new Weight(1500.0, WeightUnit.G);

        int actual = kilogram.compare(gram);

        assertEquals(expected, actual);
    }

    // ------------------------------- unit test to check error while using incompatible unit types -------------------------------
    @Test
    void testConvertWithIncompatibleUnitThrowsException() throws Exception {
        Weight kilogram = new Weight(1.0, WeightUnit.KG);

        assertThrows(ClassCastException.class, () -> {
            kilogram.convert(VolumeUnit.L);
        });
    }
}