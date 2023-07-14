package problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Q1248Test {
    public void test(int expected, int[] array, int k) {
        var q = new Q1248NiceSubarrays();
        var actual = q.numberOfSubarrays(array, k);
        Assertions.assertEquals(expected, actual,
                String.format("Expect to have %s but got %s with input: %s",
                        expected, actual, Arrays.toString(array) + " k: " + k));
    }

//    @Test
//    public void testSimple() {
//
//    }
//
//    @Test
//    public void testMedian() {
//
//    }

    @Test
    public void testHard() {
        test(2, new int[]{1,1,2,1,1}, 3);
        test(0, new int[]{2,4,6}, 1);
        test(16, new int[]{2,2,2,1,2,2,1,2,2,2}, 2);
        test(6, new int[]{91473,45388,24720,35841,29648,77363,86290,58032,53752,87188,34428,85343,19801,73201}, 4);
    }
}
