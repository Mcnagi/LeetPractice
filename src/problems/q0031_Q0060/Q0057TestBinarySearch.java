package problems.q0031_Q0060;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class Q0057TestBinarySearch {
    static Q0057InsertInterval q;
    @BeforeAll
    public static void init() {
        q = new Q0057InsertInterval();
    }

    @Test
    public void testEmpty() {
        int[][] input = new int[0][0];
        Assertions.assertEquals(0, q.binarySearch(input, 1));
        Assertions.assertEquals(0, q.binarySearch(input, 2));
        Assertions.assertEquals(0, q.binarySearch(input, -1));
        Assertions.assertEquals(0, q.binarySearch(input, 0));
    }

    @Test
    public void testOne() {
        int[][] input = new int[][] {new int[] {1,5}};
        Assertions.assertEquals(0, q.binarySearch(input, 0));
        Assertions.assertEquals(0, q.binarySearch(input, -1));
        Assertions.assertEquals(0, q.binarySearch(input, 1));
        Assertions.assertEquals(1, q.binarySearch(input, 2));
        Assertions.assertEquals(1, q.binarySearch(input, 5));
        Assertions.assertEquals(1, q.binarySearch(input, 10));

        input = new int[][] {new int[] {1,1}};
        Assertions.assertEquals(0, q.binarySearch(input, 1));
        Assertions.assertEquals(0, q.binarySearch(input, -1));
        Assertions.assertEquals(1, q.binarySearch(input, 10));
    }

    @Test
    public void testComplex() {
        int[][] input = new int[][] {new int[] {1,5}, {3, 5}, {6, 6}};
        Assertions.assertEquals(0, q.binarySearch(input, -1));
        Assertions.assertEquals(0, q.binarySearch(input, 0));
        Assertions.assertEquals(0, q.binarySearch(input, 1));
        Assertions.assertEquals(1, q.binarySearch(input, 2));
        Assertions.assertEquals(1, q.binarySearch(input, 3));
        Assertions.assertEquals(2, q.binarySearch(input, 4));
        Assertions.assertEquals(2, q.binarySearch(input, 5));
        Assertions.assertEquals(2, q.binarySearch(input, 6));
        Assertions.assertEquals(3, q.binarySearch(input, 7));
    }

    @Test
    public void testLong() {
        int[][] input = new int[][] {new int[] {1,2},
                new int[] {3,5},
                new int[] {6,7},
                new int[] {8,10},
                new int[] {12,16}};
        Assertions.assertEquals(2, q.binarySearch(input, 4));
    }
}
