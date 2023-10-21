package problems.Q0001_Q0030;

import java.util.HashMap;

public class Q0001TwoSum {
  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement)) {
        return new int[] {map.get(complement), i};
      }
      map.put(nums[i], i);
    }

    return null;
  }
}
