package problems;

public class Q0004MedianOfTwoSorted {

    /**
     * Get the value from the array that
     * is closest to target.
     * @param target the value needs to approximate
     * @param array integers to look into
     * @param fromLeft 1 for larger or equal to target,
     *                 -1 for smaller or equal to target,
     *                 no good with 0;
     */
    @Deprecated
    public static int approximate(int target, int[] array, int fromLeft) {
        assert fromLeft == 1 || fromLeft == -1 || fromLeft == 0;
        if (array.length == 0) return -1;
        int l = 0;
        int r = array.length;
        int index = r / 2;
        while (true) {
            if (index == 0) return 0;
            if (array[index] < target) {
                l = index;
                index = (index + r) / 2; // increase index
                continue;
            }
            // decrease index
            r = index;
            index = (l + index) / 2;
        }
//        return index;
    }

    public static int approximate(int target, int[] array, boolean greaterEqual) {
        if (array.length == 0
                || (greaterEqual && array[array.length - 1] < target)
                || (!greaterEqual && array[0] > target)) return -1;

        int left = 0;
        int right = array.length;
        int index = right / 2;
        while (true) {
            if (index == 0) break;
            if (array[index] == target) return index;
            if (array[index] < target) {
                // increase index
                left = index;
                index = (index + right) / 2;
            } else {
                // decrease index
                right = index;
                index = (left + index) / 2;
            }
            if (right - left <= 1) break;
        }
        if (greaterEqual) {
            if (index > 0 && array[index] >= target) return index - 1;
            if (array[index] < target) return Math.min(index + 1, array.length - 1);
        }
        else if (array[index] > target) return Math.max(index - 1, 0);
        return index;
    }



//    public static void main(String[] args) {
//        int[] array = new int[]{11, 22, 23, 44, 125,526};
//        System.out.println(rightApproximate(45, array, 4));
//    }
    /**
     * @return -1 if and only if length is 0;
     *  the correct index bounded by length.
     */
    public static int boundIndex(int index, int length) {
        return Math.min(Math.max(0, index), length - 1);
    }

    public static double median(int[] array) {
        if (array.length == 0) return -1;
        int i = array.length / 2;
        int j = (array.length - 1) / 2;
        return ((double) array[i] + (double) array[j]) / 2;
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0) return median(nums2);
        if (nums2.length == 0) return median(nums1);
        final int TOTAL_LENGTH = nums1.length + nums2.length;
        int i = 0;
        int j = 0;
        int index = 0;
        int value1 = 0;
        int value2 = 0;
        while (index < TOTAL_LENGTH / 2 + 1) {
            if (i == nums1.length || (j < nums2.length && nums1[i] > nums2[j])) {
                value1 = value2;
                value2 = nums2[j];
                index += 1;
                j += 1;
            } else {
                value1 = value2;
                value2 = nums1[i];
                index += 1;
                i+= 1;
            }
        }
        return TOTAL_LENGTH % 2 == 1 ? (double) value2  : ((double) value1 + (double) value2) / 2;
    }
}
