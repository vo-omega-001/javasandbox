package sated.platform.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LibTest {

    @BeforeAll
    public static void setup() {
        System.out.println("SETUP");
    }

    @Test
    public void printTest() {
        new Lib().print("test JUPITER Junit 5");
    }
}
