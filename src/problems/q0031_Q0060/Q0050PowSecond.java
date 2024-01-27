package problems.q0031_Q0060;

public class Q0050PowSecond {
  public double myPow(double x, int n) {
    long N = n;
    if (N < 0) {
      x = 1 / x;
      N = -N;
    }
    return powerHelper(x, N);
  }

  private double powerHelper(double x, long n) {
    if (n == 0) return 1;
    if (n == 1) return x;
    if (n % 2 == 0) return powerHelper(x * x, n / 2);
    return x * powerHelper(x * x, n / 2);
  }
}
