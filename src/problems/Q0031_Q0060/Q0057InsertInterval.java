package problems.Q0031_Q0060;

public class Q0057InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        return new int[0][0];
    }

    /**
     * finds the index in the source, that
     * first element is no greater than target.
     */
    private int binarySearch(int[][] source, int target) {
        if (source.length == 0) return -1;
        int s = 0, e = source.length - 1;
        while(s < e) {
            int i = (s + e) / 2;
            int comp = Integer.compare(source[i][0], target);
            if(comp == 0) return i;
            else if (comp < 0) e = i - 1;
            else s = i + 1;
        }
        return s;
    }
}
