package problems.Q0031_Q0060;

public class Q0045JumpGameII {
  public int jump(int[] nums) {
    if (nums.length <= 2) return nums.length - 1;
    int[] dp = new int[nums.length];

    for (int i = dp.length - 2; i >= 0; i--) {
      if (nums[i] + i >= nums.length - 1) dp[i] = 1;
      else {
        int min = Integer.MAX_VALUE;
        for (int j = 1; j <= nums[i]; j++) {
          if (dp[i + j] < min) min = dp[i + j] + 1;
        }
        dp[i] = min;
      }
    }
    return dp[0];
  }

  public static void main(String[] args) {
    var q = new Q0045JumpGameII();
    System.out.println(q.jump(new int[]{2, 3, 0, 1, 4}));
  }
}
