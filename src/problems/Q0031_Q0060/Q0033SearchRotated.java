package problems.Q0031_Q0060;

public class Q0033SearchRotated {
  public int search(int[] nums, int target) {
    int pivot = 0;
    if (nums[0] > nums[nums.length - 1]) {
      int s = 0;
      int e = nums.length - 1;
      pivot = (s + e) / 2;
      while (pivot < nums.length) {
        if (nums[pivot] > nums[pivot + 1]) break;
        if (nums[pivot] < nums[nums.length - 1]) e = pivot - 1;
        else s = pivot + 1;
        pivot = (s + e) / 2;
      }
    }
    int result = search(nums, target, 0, pivot);
    if (result != -1) return result;
    return search(nums, target, pivot + 1, nums.length - 1);
  }

  private int search(int[] nums, int target, int s, int e) {
    if (s >= nums.length) return -1;
    int i = (s + e) / 2;
    while (s <= e) {
      if (nums[i] == target) return i;
      if (nums[i] > target) e = i - 1;
      else s = i + 1;
      i = (s + e) / 2;
    }
    return -1;
  }
}
