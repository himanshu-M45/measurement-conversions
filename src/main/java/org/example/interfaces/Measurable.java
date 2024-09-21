package org.example.interfaces;

import org.example.implementation.Weight;

public interface Measurable {
    Measurable convert(Enum<?> toUnit) throws Exception;
    Measurable add(Measurable additionValue) throws Exception;
    Measurable sub(Measurable subtractionValue) throws Exception;
    int compare(Measurable compareTo) throws Exception;
}
