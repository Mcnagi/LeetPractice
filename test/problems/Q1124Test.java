package problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

// Used 0 and 16 to make it easy to read.
// Expect the program to take working hour
// strictly greater than 8 as a tiring day.
public class Q1124Test {
    public void test(int expected, int[] input) {
        var q = new Q1124LongestWPI();
        var actual = q.longestWPI(input);
        Assertions.assertEquals(expected, actual,
                String.format("Expect to have %s but got %s with input: %s", expected, actual, Arrays.toString(input)));
    }

    @Test
    public void testNone() {
        test(0, new int[]{6, 6, 6});
        test(0, new int[]{6, 7, 8});

    }

    @Test
    public void testOne() {
        test(1, new int[]{16, 8, 8, 0, 1});
        test(1, new int[]{16, 8, 8, 16, 8});
        test(1, new int[]{0, 16, 0});
        test(1, new int[]{0, 0, 0, 0, 16, 0});
        test(1, new int[]{0, 16, 0, 0, 16});
    }

    @Test
    public void testTwo() {
        test(2, new int[]{16, 16});
        test(2, new int[]{16, 10});
        test(2, new int[]{9, 12});
    }

    @Test
    public void testHard() {
        // non-tiring on the left
        test(3, new int[]{0, 16, 16});
        // non-tiring on the right
        test(3, new int[]{16, 16, 0, 0});
        // non-tiring in between
        test(3, new int[]{0, 16, 0, 16});

        test(5, new int[]{0, 16, 0, 16, 16});
        test(5, new int[]{0, 0, 16, 16, 16});
        test(3, new int[]{0, 0, 16, 16});

        // two non-tiring days
        test(5, new int[]{0, 0, 16, 16, 0, 0, 16});

        test(9, new int[]{0, 16, 16, 16, 0, 0, 0, 0, 0, 0, 0, 0, 16, 16, 16, 16, 0, 16});
        test(5, new int[]{0, 16, 16, 16, 0, 0, 0, 0, 0, 0, 0, 0, 16, 0, 0, 0, 0, 16});

        test(9, new int[]{0, 16, 0, 16, 0, 16, 0, 16, 0, 16});
        test(9, new int[]{16, 0, 16, 0, 16, 0, 16, 0, 16, 0});

        test(7, new int[]{16, 16, 16, 0, 0, 0, 0, 0, 0, 16, 0, 16, 0, 16, 0, 16, 0});

        test(29, new int[]{11, 2, 4, 14, 2, 15, 7, 10, 1, 16, 9, 0, 2, 8, 4, 14, 6, 12, 2, 8, 6, 4, 14, 13, 7, 16, 14, 2, 3, 2, 8, 3, 12, 3, 3, 9, 14, 1, 5, 3, 12, 0, 15, 5, 0, 2, 3, 16, 7, 2, 1, 1, 4, 9, 0, 11, 9, 16, 15, 7, 0, 5, 6, 4, 12, 1, 1, 2, 13, 8, 3, 9, 12, 9, 3, 11, 4, 14, 7, 5, 16, 0, 11, 8, 8, 14, 1, 5, 0, 6, 5, 8, 10, 15, 9, 14, 16, 11, 1, 13});

//        [11,2,4,14,2,15,7,10,1,16,9,0,2,8,4,14,6,12,2,8,6,4,14,13,7,16,14,2,3,2,8,3,12,3,3,9,14,1,5,3,12,0,15,5,0,2,3,16,7,2,1,1,4,9,0,11,9,16,15,7,0,5,6,4,12,1,1,2,13,8,3,9,12,9,3,11,4,14,7,5,16,0,11,8,8,14,1,5,0,6,5,8,10,15,9,14,16,11,1,13]
        // 1, 0 ,0, 1,0,1,0,1,0,1,1,0,0,  0, 0, 1,0,1,0,0,0,0,1, 1, 0, 1, 1 ,0,0,0,0,0,1,0,0,1,1, 0, 0,0,1,0,1,0,0,0,0,  1,0,0,0,0,0,1,0,1, 1, 1, 1,0, 0,0,0,0,1,0,0,0,1, 0, 0, 1,1,1,0, 1,0,1,0,0, 1, 0, 1,0,0,1,0,0,0,0,0,0, 1, 1, 1, 1,1,1, 0, 1
    }

    @Test
    public void testTiredLater() {
        test(14, new int[]{16, 0, 0, 16, 0, 0, 16, 0, 0, 16, 16, 16, 16, 16});
        test(15, new int[]{0, 0, 0, 0, 16, 0, 0, 16, 0, 0, 16, 0, 0, 16, 16, 16, 16, 16});
    }
}
