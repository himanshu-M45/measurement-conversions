package org.example.implementation;

import org.example.enums.TemperatureUnit;
import org.example.interfaces.Measurable;

import java.util.Objects;

public abstract class AbstractMeasurable<T extends Enum<T>> implements Measurable {
    protected double value;
    protected T unit;

    public AbstractMeasurable(double value, T unit) throws IllegalAccessException {
        if (value < 0 && !(unit instanceof TemperatureUnit)) {
            throw new IllegalAccessException("Value cannot be negative");
        }
        this.value = value;
        this.unit = unit;
    }

    @Override
    public Measurable convert(Enum<?> toUnit) throws Exception {
        double valueInBaseUnit = convertToBaseUnit(this.value, this.unit);
        double convertedValue = convertFromBaseUnit(valueInBaseUnit, castToGenericType(toUnit));
        return createInstance(convertedValue, castToGenericType(toUnit));
    }

    @Override
    public Measurable add(Measurable additionValue) throws Exception {
        AbstractMeasurable<?> measurableToAdd = (AbstractMeasurable<?>) additionValue;
        AbstractMeasurable<?> convertedValue = (AbstractMeasurable<?>) measurableToAdd.convert(this.unit);
        return createInstance(this.value + convertedValue.value, this.unit);
    }

    @Override
    public Measurable sub(Measurable subtractionValue) throws Exception {
        AbstractMeasurable<?> measurableToSub = (AbstractMeasurable<?>) subtractionValue;
        AbstractMeasurable<?> convertedValue = (AbstractMeasurable<?>) measurableToSub.convert(this.unit);
        return createInstance(this.value - convertedValue.value, this.unit);
    }

    @Override
    public int compare(Measurable compareTo) throws Exception {
        AbstractMeasurable<?> measurableToCompare = (AbstractMeasurable<?>) compareTo;
        AbstractMeasurable<?> convertedValue = (AbstractMeasurable<?>) measurableToCompare.convert(this.unit);
        return Double.compare(this.value, convertedValue.value);
    }

    protected abstract Measurable createInstance(double value, T unit);

    protected abstract double convertToBaseUnit(double value, T unit);

    protected abstract double convertFromBaseUnit(double value, T unit);

    /*
            Unchecked cast: 'java. lang. Enum<capture<?>>' to 'T'
            Reason: The warning "Unchecked cast: 'java.lang.Enum<capture<#comment #comment="?"></#comment>>'
            to 'T'" occurs because the cast from `Enum<#comment #comment="?"></#comment>toTis not type-safe.
            To resolve this, you can use a type-safe approach by adding a method to theAbstractMeasurable`
            class that performs the cast safely.  Here's how you can modify the convert method to avoid the
            unchecked cast warning:
                1. Add a method to safely cast Enum<?> to T.
                2. Use this method in the convert method.
        */
    @SuppressWarnings("unchecked")
    private T castToGenericType(Enum<?> toUnit) {
        return (T) toUnit;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AbstractMeasurable<?> that = (AbstractMeasurable<?>) obj;
        return Double.compare(that.value, value) == 0 && unit.equals(that.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }
}
