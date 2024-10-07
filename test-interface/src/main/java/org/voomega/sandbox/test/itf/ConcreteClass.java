package org.voomega.sandbox.test.itf;

import org.voomega.sandbox.test.itf.def.Interface01;

public class ConcreteClass<I, O> extends AbstractClass<I, O> implements Interface01 {
    @Override
    O tutu(I arg) {
        return null;
    }


    @Override
    public String fun01(int arg) {
        return super.fun01(arg);
    }

    @Override
    public void fun02(String arg) {
        super.fun02(arg);
    }


}
