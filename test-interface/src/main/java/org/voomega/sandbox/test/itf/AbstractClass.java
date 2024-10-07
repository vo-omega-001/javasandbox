package org.voomega.sandbox.test.itf;

public abstract class AbstractClass <I,O> {

    abstract O tutu(I arg);

    String fun01(int arg) {
        System.out.println(String.format("AbstractClass printing int: %s", arg));
        return String.valueOf(arg);
    }
    void fun02(String arg) {
        System.out.println(String.format("AbstractClass printing string: %s", arg));
    }
}
