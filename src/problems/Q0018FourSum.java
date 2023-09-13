package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q0018FourSum {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> result = new ArrayList<>();
    if (nums.length < 4) return result;
    Arrays.sort(nums);
    int len = nums.length;
    if ((long) nums[0] + (long) nums[1] + (long) nums[2] + (long) nums[3] > target
        || ((long) nums[len - 1]
                + (long) nums[len - 2]
                + (long) nums[len - 3]
                + (long) nums[len - 4])
            < target) return result;

    for (int first = 0; first < len - 3; first++) {
      if (first > 0 && nums[first] == nums[first - 1]) continue;
      for (int second = first + 1; second < len - 2; second++) {
        if (second > first + 1 && nums[second] == nums[second - 1]) continue;
        int third = second + 1;
        int last = len - 1;
        while (third < last) {
          long sum =
              (long) nums[first] + (long) nums[second] + (long) nums[third] + (long) nums[last];
          if (sum == target) {
            result.add(
                new ArrayList<>(List.of(nums[first], nums[second], nums[third], nums[last])));
            do {
              third += 1;
            } while (third < last && nums[third] == nums[third - 1]);
            do {
              last -= 1;
            } while (third < last && nums[last] == nums[last + 1]);
          } else if (sum < target) {
            do {
              third += 1;
            } while (third < last && nums[third] == nums[third - 1]);
          } else {
            do {
              last -= 1;
            } while (third < last && nums[last] == nums[last + 1]);
          }
        }
      }
    }
    return result;
  }
}
