package org.voomega.sandbox.services.translator;

import org.voomega.sandbox.services.translator.inout.Input01;
import org.junit.Test;

public class TranslatorsTest {

    @Test
    public void test() {
        Input01 input01 = new Input01("Vincent", "OLIVIER");
        Translators.translate(input01);
    }
}
