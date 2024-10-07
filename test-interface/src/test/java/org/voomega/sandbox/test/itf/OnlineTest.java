package org.voomega.sandbox.test.itf;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class OnlineTest {

    @Test
    public void test01() {

        try {
            findLargest(null);
            Assert.fail("Exception expected when param is null");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            findLargest(new int[]{});
            Assert.fail("Exception expected when int array is empty");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            findLargest(new int[]{1,15,12,17,5,6,78,1,2,3,6});

        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
        System.out.println("java Echo Hello you !\nHello\nyou\n!");
    }

    @Test
    public void test02() {
        String res = concat(new String[]{"fo","ob", "ar", "ru"});
        System.out.println("res="+res);
    }

    static int findLargest(int[] numbers) throws Exception {

        if (null != numbers && 0 < numbers.length) {
            int res = 0;

            for (int val : numbers) {
                if (res < val) {
                    res = val;
                }
            }

            return res;
        }
        throw new Exception("invalid size");
    }

    static public String concat(String[] strings) {

        StringBuilder sb = new StringBuilder("");
        if (null != strings && 0 < strings.length)
            sb.append(strings);

        return sb.toString();
    }
}
