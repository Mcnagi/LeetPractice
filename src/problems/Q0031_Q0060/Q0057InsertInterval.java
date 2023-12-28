package problems.Q0031_Q0060;

import java.util.LinkedList;

public class Q0057InsertInterval {

    // maybe no need for binary search, but can be done looping through inputs linearly.

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][]{newInterval};

        int index = binarySearch(intervals, newInterval[0]);
        LinkedList<int[]> linkedList = new LinkedList<>();
        int i = 0;
        while (i < intervals.length) {
            if (i == index) addInterval(linkedList, newInterval);
            addInterval(linkedList, intervals[i]);
            i ++;
        }
        if (i == index) addInterval(linkedList, newInterval);
        int[][] output = new int[linkedList.size()][2];
        i = 0;
        while (linkedList.size() > 0) {
            output[i ++] = linkedList.pollFirst();
        }
        return output;
    }

    /**
     * finds the index in the source, that
     * first element is no greater than target.
     */
    int binarySearch(int[][] source, int target) {
        if (source.length == 0) return 0;
        int s = 0, e = source.length - 1;
        while(s < e) {
            int i = (s + e) / 2;
            int comp = Integer.compare(source[i][0], target);
            if(comp == 0) return i;
            else if (comp > 0) e = i - 1;
            else s = i + 1;
        }
        if (s == source.length - 1 && target > source[s][0]) return s + 1;
        if (source[s][0] < target && target < source[s + 1][0]) return s + 1;
        return s;
    }

    private void addInterval(LinkedList<int[]> list, int[] newInterval) {
        if (list.size() == 0) {
            list.add(newInterval);
        }
        else if (list.peekLast()[1] >= newInterval[0]) {
            list.peekLast()[1] = Math.max(list.peekLast()[1], newInterval[1]);
        }
        else {
            list.add(newInterval);
        }
    }
}
