package problems;

import java.util.HashMap;
import java.util.Map;

public class Q0220ContainsDuplicateIII {
  public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
    Map<Integer, Integer> mapIndex = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int group = (nums[i] + 1_000_000_000) / (valueDiff + 1);
      if (mapIndex.containsKey(group) && i - mapIndex.get(group) <= indexDiff) return true;
      if (mapIndex.containsKey(group + 1)
          && i - mapIndex.get(group + 1) <= indexDiff
          && Math.abs(nums[mapIndex.get(group + 1)] - nums[i]) <= valueDiff) return true;
      if (mapIndex.containsKey(group - 1)
          && i - mapIndex.get(group - 1) <= indexDiff
          && Math.abs(nums[mapIndex.get(group - 1)] - nums[i]) <= valueDiff) return true;

      mapIndex.put(group, i);
    }
    return false;
  }
}
