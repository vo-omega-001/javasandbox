package org.voomega.sandbox.test.itf;

import org.voomega.sandbox.test.itf.model.Input;
import org.voomega.sandbox.test.itf.model.Output;
import org.junit.Test;

public class ConcreteClassTest {

    @Test
    public void test() {
        ConcreteClass<Input, Output> concrete = new ConcreteClass();
        concrete.fun01(1);
        concrete.fun02("test");
    }
}
