package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VolumeTest {
    @Test
    void testValidLitersToMillilitersConversion() throws Exception {
        Volume expected = new Volume(1000.0, "ml");
        Volume volume = new Volume(1.0, "l");

        Volume actual = volume.convert();

        assertEquals(expected, actual);
        assertEquals(expected, actual);
    }

    @Test
    void testOneThousandMillilitersToOneLiters() throws Exception {
        Volume expected = new Volume(1.0, "l");
        Volume volume = new Volume(1000.0, "ml");

        Volume actual = volume.convert();

        assertEquals(expected, actual);
        assertEquals(expected, actual);
    }

    @Test
    void testInputCannotBe0Value() throws Exception {
        assertThrows(Exception.class, () -> new Volume(0.0, "l"));
    }

    @Test
    void testInputCannotBeNegative() throws Exception {
        assertThrows(Exception.class, () -> new Volume(-9.0, "l"));
    }

}