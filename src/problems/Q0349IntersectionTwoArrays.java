package problems;

import java.util.*;

public class Q0349IntersectionTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> resultSet = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        for (var value : nums1) set1.add(value);
        for (var value : nums2) if (set1.contains(value)) resultSet.add(value);

        int[] result = new int[resultSet.size()];
        int index = 0;
        for (var value : resultSet) {
            result[index] = value;
            index += 1;
        }
        return result;
    }

//    int[] result;
//    public int[] intersection(int[] nums1, int[] nums2) {
//        int[] array = new int[1000];
//        for (var value : nums1) {
//            array[value] += 1;
//        }
//        result = new int[nums2.length];
//        for (var value : nums2) {
//            if (array[value] > 0) addResult(value);
//        }
//        return result;
//    }
//    public void addResult(int x) {
//        if ()
//    }
}
