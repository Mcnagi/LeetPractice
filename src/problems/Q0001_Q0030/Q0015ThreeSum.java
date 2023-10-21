package problems.Q0001_Q0030;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q0015ThreeSum {
  // FIXME time complexity no good
  int[] nums;
  int left;
  int right;

  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    this.nums = nums;
    List<List<Integer>> result = new ArrayList<>();
    if (this.nums[0] * this.nums[this.nums.length - 1] > 0)
      return result; // all positive or all negative
    int prev = Integer.MIN_VALUE;
    for (int i = 0; i < this.nums.length - 2; i++) {
      if (nums[i] == prev) continue;
      prev = nums[i];
      this.left = i + 1;
      this.right = this.nums.length - 1;
      while (left < right) {
        int currentSum = sum(i);
        if (currentSum == 0) {
          result.add(new ArrayList<>(List.of(this.nums[i], this.nums[left], this.nums[right])));
          if (!getNextIndices()) break;
        } else if (currentSum < 0) {
          getNextLeft();
        } else {
          getNextRight();
        }
      }
    }
    return result;
  }

  public int sum(int index) {
    return nums[index] + nums[left] + nums[right];
  }

  public boolean getNextIndices() {
    int oldLeft = left;
    int oldRight = right;
    if (nums[oldLeft] == nums[oldRight]) return false;
    while (left < right && nums[left] == nums[oldLeft]) {
      left++;
    }
    if (nums[left] == nums[oldLeft]) return false;
    while (left < right && nums[right] == nums[oldRight]) {
      right--;
    }
    if (nums[right] == nums[oldRight]) return false;
    return true;
  }

  public boolean getNextRight() {
    int oldRight = right;
    while (left < right && nums[right] == nums[oldRight]) {
      right--;
    }
    if (nums[right] == nums[oldRight]) return false;
    return true;
  }

  public boolean getNextLeft() {
    int oldLeft = left;
    while (left < right && nums[left] == nums[oldLeft]) {
      left++;
    }
    if (nums[left] == nums[oldLeft]) return false;
    return true;
  }

  public static void main(String[] args) {
    var q15 = new Q0015ThreeSum();
    var tmp = q15.threeSum(new int[] {0, 0, 0});
    System.out.println(tmp);
  }
}
