package problems.q0031_Q0060;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q0056MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt((int[] o) -> o[0]).thenComparingInt(o -> o[1]));
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].length != 2) {
                System.out.println();
            } //error
            int[] prev = list.get(list.size() - 1);
            if (intervals[i][0] <= prev[1]) prev[1] = Math.max(prev[1], intervals[i][1]);
            else list.add(intervals[i]);
        }
        return list.stream().toArray(int[][]::new);
    }
}
