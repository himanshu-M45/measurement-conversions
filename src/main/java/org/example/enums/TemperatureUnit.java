package org.example.enums;

public enum TemperatureUnit {
    CELSIUS() {
        public double toBaseUnit(double value) {
            return value;
        }

        public double fromBaseUnit(double value) {
            return value;
        }
    },
    FAHRENHEIT() {
        public double toBaseUnit(double value) {
            return (value - constant) * 5 / 9;
        }

        public double fromBaseUnit(double value) {
            return (value * 9 / 5) + constant;
        }
    };

    public final int constant = 32;
}
