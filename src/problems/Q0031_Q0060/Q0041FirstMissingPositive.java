package problems.Q0031_Q0060;

public class Q0041FirstMissingPositive {
  public int firstMissingPositive(int[] nums) {
    boolean[] exists = new boolean[nums.length];
    for (int value : nums) {
      if (value > 0 && value <= nums.length) exists[value - 1] = true;
    }
    int i = 0;
    for (; i < exists.length; i++) {
      if (!exists[i]) return i + 1;
    }
    return i + 1;
  }
}
