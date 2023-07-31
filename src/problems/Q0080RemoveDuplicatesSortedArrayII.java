package problems;

public class Q0080RemoveDuplicatesSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        int count = 0;
        int prev = Integer.MIN_VALUE;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == prev) {
                count ++;
                if (count > 2) {
                    i ++;
                    continue;
                }
            }
            else count = 1;
            nums[k] = nums[i];
            prev = nums[k];
            k ++;


            i ++;
        }
        return k;
    }
}
