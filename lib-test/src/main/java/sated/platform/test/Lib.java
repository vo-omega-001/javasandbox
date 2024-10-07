package sated.platform.test;

public class Lib {

    public Lib() {
        System.out.println("Lib constructor");
    }

    public void print(String term) {
        System.out.println(String.format("Lib printing: %s", term));
    }
}
