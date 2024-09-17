package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LitersToMillilitersTest {
    @Test
    void testValidLitersToMillilitersConversion() throws Exception {
        double expected = 1000.0;
        LitersToMilliliters litersToMilliliters = new LitersToMilliliters(1.0);

        double actual = litersToMilliliters.convert();

        assertEquals(expected, actual);
    }

    @Test
    void testInputCannotBe0Value() throws Exception {
        assertThrows(Exception.class, () -> new LitersToMilliliters(0.0));
    }

    @Test
    void testInputCannotBeNegative() throws Exception {
        assertThrows(Exception.class, () -> new LitersToMilliliters(-9.0));
    }

}