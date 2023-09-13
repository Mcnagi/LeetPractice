package problems;

public class Q0070ClimbingStairs {
  static int[] results = new int[46];

  static {
    results[0] = 0;
    results[1] = 1;
    results[2] = 2;
    results[3] = 3;
    results[4] = 5;
  }

  public int climbStairs(int n) {
    double alpha = (Math.sqrt(5) + 1) / 2;
    return (int) ((Math.pow(alpha, n) - Math.pow(1 - alpha, n)) / Math.sqrt(5));
  }

  public static void main(String[] args) {
    var q = new Q0070ClimbingStairs();
    for (int i = 1; i < 10; i++) {
      System.out.println("i: " + i + ", " + q.climbStairs(i + 1));
    }
  }
}
