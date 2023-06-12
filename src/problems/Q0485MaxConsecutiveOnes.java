package problems;

public class Q0485MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count ++;
            }
            else {
                if (count > max) max = count;
                count = 0;
            }
        }
        return Math.max(max, count);
    }
}
