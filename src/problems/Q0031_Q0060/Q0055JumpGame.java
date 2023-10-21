package problems.Q0031_Q0060;

public class Q0055JumpGame {
  public boolean canJump(int[] nums) {
    int last = nums.length - 1;
    for (int i = nums.length - 2; i >= 0; i--) {
      if (nums[i] + i >= last) last = i;
    }
    return last == 0;
  }
}
