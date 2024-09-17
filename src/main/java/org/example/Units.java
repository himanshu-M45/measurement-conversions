package org.example;

public enum Units {
    LITER(1.0),
    DECILITER(0.1),
    CENTILITER(0.01),
    MILLILITER(0.001),
    KILOLITER(1000.0);

    private final double toLiterFactor;

    Units(double toLiterFactor) {
        this.toLiterFactor = toLiterFactor;
    }

    public double toLiter(double value) {
        return value * toLiterFactor;
    }

    public double fromLiter(double valueInLiter) {
        return valueInLiter / toLiterFactor;
    }
}
