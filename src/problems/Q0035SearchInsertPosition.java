package problems;

public class Q0035SearchInsertPosition {
  public int searchInsert(int[] nums, int target) {
    int lower = 0, upper = nums.length;
    int index = upper / 2;
    while (lower + 1 < upper) {
      if (nums[index] == target) break;
      if (nums[index] < target) {
        lower = index;
      } else {
        upper = index;
      }
      index = (lower + upper) / 2;
    }

    return target <= nums[index] ? index : index + 1;
  }
}
