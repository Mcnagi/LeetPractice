package problems.Q0031_Q0060;

import java.util.Arrays;

public class Q0031NextPermutation {
  public void nextPermutation(int[] nums) {
    if (nums.length == 1) return;
    if (nums.length == 2) {
      swap(nums, 0, 1);
      return;
    }
    int j = nums.length - 1;
    while (j >= 1 && nums[j - 1] >= nums[j]) j -= 1;
    if (j == 0) {
      Arrays.sort(nums, 0, nums.length);
      return;
    }
    int value = nums[j - 1];
    int index = j;
    int successor = Integer.MAX_VALUE;
    for (int i = j; i < nums.length; i++) {
      if (nums[i] > value && nums[i] < successor) {
        successor = nums[i];
        index = i;
      }
    }
    swap(nums, j - 1, index);
    Arrays.sort(nums, j, nums.length);
  }

  public void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
