package org.voomega.sandbox.services.translator;

import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Translators {

    private static final Map<Class<?>, Translator> translatorDictionary = new LinkedHashMap<>();

    private static final List<Translator>  translators = new ArrayList<>();

    static {
        translators.add(new MyTranslator());
    }


    private Translators() {}

    private static <E> void load () {
        translators.forEach(translator -> {
            translator.getInputClass().forEach(clazz -> translatorDictionary.put((Class<E>) clazz, translator));
        });
    }

    public static <E> Translator getTranslator(Class<E> inputClass) {
        load();
        return translatorDictionary.get(inputClass);
    }

    public static <T, E> T translate(E inputObject) {

        Translator<E, T> translator = getTranslator(inputObject.getClass());

        return translator.translate("CTX", inputObject);
    }
}
