package problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class Q0004Test {

    public void testDouble(double expected, int[] array1, int[] array2) {
        Assertions.assertTrue(Math.abs(Q0004MedianOfTwoSortedArrays.
                findMedianSortedArrays(array1, array2) - expected) < 0.0001);
    }
    public void testFind(int expected, int target, int[] array) { // fromLeft == 1 means smaller or equal to
        Assertions.assertEquals(expected, Q0004MedianOfTwoSortedArrays.
                approximate(target, array, true));
    }

    @Test
    public void testSmall() {
        int [] array1 = new int[]{1,3};
        int [] array2 = new int[]{2};
        testDouble(2.0, array1, array2);
        testDouble(2.5, new int[]{1,2}, new int[]{3,4});
        // test swapping order
        testDouble(4, new int[]{1}, new int[]{2,3,4,5,6,7});
        testDouble(4, new int[]{2,3,4,5,6,7}, new int[]{1});
    }

    @Disabled@Test
    public void testApproximate() {
        int[] array = new int[]{0, 2, 5, 23, 24, 100};
        testFind(0, 0, array);

        testFind(1, 1, array);

        testFind(3, 23, array);
        testFind(4, 24, array);
        testFind(5, 25, array);

//        testFind(0, 0, array, 1);
//        testFind(0, 0, array, 0);
//        testFind(1, 0, array, -1);
//
//        testFind(0, 1, array, 1);
//        testFind(1, 1, array ,-1);
//
//        testFind(3, 23, array, 1);
//        testFind(3, 23, array ,-1);
//        testFind(4, 24, array, 1);
//        testFind(4, 24, array ,-1);
////        testFind(4, 25, array, 1);
//        testFind(5, 25, array ,-1);

    }


}
