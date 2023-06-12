package problems;

import javafx.util.Pair;

import java.util.Arrays;

public class Q0016ThreeSumClosest {
    // FIXME Runtime 30 ms Beats 12.64%
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        Pair<Integer, Integer> result = new Pair<>(Integer.MAX_VALUE, 0);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                int diff = sum - target;
                if (diff == 0) return target;
                if (Math.abs(diff) < result.getKey()) {
                    result = new Pair<>(Math.abs(diff), sum);
                }
                if (diff < 0)
                    do {
                        l++;
                    } while (l < r && nums[l] == nums[l - 1]);
                else if (diff > 0)
                    do {
                        r--;
                    } while (l < r && nums[r] == nums[r + 1]);
            }
        }
        return result.getValue();
    }

}
