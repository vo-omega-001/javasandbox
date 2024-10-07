package org.voomega.sandbox.services.translator;

import org.apache.poi.ss.formula.functions.T;

import java.util.List;

public interface Translator<E, T> {

    List<Class<E>> getInputClass();
    Class<T> getOutputClass();
    T translate(String context, E inputObject);
}
