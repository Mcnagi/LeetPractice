package problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Q1475Test {

    public void test(int[] expected, int[] input) {
        var q = new Q1475FinalPricesDiscount();
        var actual = q.finalPrices(input);
        Assertions.assertArrayEquals(expected, actual,
                String.format("Expect to have %s but got %s with input: %s",
                        Arrays.toString(expected),
                        Arrays.toString(actual),
                        Arrays.toString(input)));
    }

    @Test
    public void testOne() {
        for (int i = 1; i < 100; i++) {
            test(new int[]{i}, new int[]{i});
        }
    }

    @Test
    public void testTwo() {
        test(new int[]{1, 2}, new int[]{1, 2});
        test(new int[]{1, 1}, new int[]{2, 1});
        test(new int[]{0, 2}, new int[]{2, 2});
        test(new int[]{1, 99}, new int[]{100, 99});
        test(new int[]{0, 100}, new int[]{100, 100});
        test(new int[]{100, 101}, new int[]{100, 101});
    }

    @Test
    public void testMultiple() {
        test(new int[]{4,2,4,2,3}, new int[]{8,4,6,2,3});
        test(new int[]{1,2,3,4,5}, new int[]{1,2,3,4,5});
        test(new int[]{9,0,1,6}, new int[]{10,1,1,6});
    }
}
