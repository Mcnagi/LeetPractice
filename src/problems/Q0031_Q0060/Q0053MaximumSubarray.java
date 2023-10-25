package problems.Q0031_Q0060;

public class Q0053MaximumSubarray {
  public int maxSubArray(int[] nums) {
    int max = nums[0];
    int i = 0;
    while (i < nums.length && nums[i] < 0) {
      if (nums[i] > max) max = nums[i];
      i++;
    }
    if (i < nums.length) max = 0;
    int cumulativeSum = 0;
    while (i < nums.length) {
      cumulativeSum += nums[i++];
      if (cumulativeSum < 0) cumulativeSum = 0;
      if (cumulativeSum > max) max = cumulativeSum;
    }
    return max;
  }
}
