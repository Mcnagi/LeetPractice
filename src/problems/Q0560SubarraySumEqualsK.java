package problems;

import java.util.ArrayList;
import java.util.List;

public class Q0560SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int[] sums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                sums[j] += nums[i];
                if (sums[j] == k) count += 1;
            }
        }
        return count;
    }
}
