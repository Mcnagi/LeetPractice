package problems;

public class Q0238ProductExceptSelf {
  public int[] productExceptSelf(int[] nums) {
    int exceptZero = 1;
    int whichZero = -1;
    int[] result = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        if (whichZero != -1) return result;
        else whichZero = i;
      } else exceptZero *= nums[i];
    }
    if (whichZero != -1) {
      result[whichZero] = exceptZero;
      return result;
    }
    for (int i = 0; i < result.length; i++) {
      result[i] = exceptZero / nums[i];
    }
    return result;
  }
}
