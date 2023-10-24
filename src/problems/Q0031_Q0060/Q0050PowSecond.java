package problems.Q0031_Q0060;

public class Q0050PowSecond {
  double[] powered;
  int[] twos;

  public double myPow(double x, int n) {
    if (x == 1) return 1;
    if (x == -1) return n % 2 == 0 ? 1 : -1;
    if (x == 0) return 0;
    if (n == 0) return 1;
    if (n == 1) return x;
    powered = new double[32];
    twos = new int[32];
    twos[0] = 0;
    twos[1] = 1;
    powered[0] = 1;
    powered[1] = n > 0 ? x : 1 / x;
    return calPow(x, n);
  }

  private double calPow(double x, int n) {
    long absN = Math.abs((long) n);
    int i = 2;
    for (; i < powered.length; i++) {
      powered[i] = powered[i - 1] * powered[i - 1];
      twos[i] = twos[i - 1] * 2;
      if (twos[i] >= absN) break;
    }
    return calPowerHelper(absN, i);
  }

  private double calPowerHelper(long n, int index) {
    if (n <= 0 || index < 0) return 1;
    while (index >= twos.length || twos[index] > n) index--;
    return powered[index] * calPowerHelper(n - twos[index], index - 1);
  }

}
