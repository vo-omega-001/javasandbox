package org.voomega.sandbox.services.translator;

import org.voomega.sandbox.services.translator.inout.Input01;
import org.voomega.sandbox.services.translator.inout.Input02;
import org.voomega.sandbox.services.translator.inout.Output;

import java.util.ArrayList;
import java.util.List;

public class MyTranslator implements Translator {
    @Override
    public List<Class<?>> getInputClass() {
        List<Class<?>> Clazzes = new ArrayList<>();
        Clazzes.add(Input01.class);
        Clazzes.add(Input02.class);
        return Clazzes;
    }

    @Override
    public Class<?> getOutputClass() {
        return Output.class;
    }

    @Override
    public Object translate(String context, Object inputObject) {
        System.out.println(String.format("translate [%s] input to [%s] output ",
                inputObject.getClass(), getOutputClass()));
        return null;
    }
}
