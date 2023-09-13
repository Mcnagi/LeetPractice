package problems;

public class Q0029DivideTwoIntegers {
  public int divide(int dividend, int divisor) {
    // if (divisor == 0) throw new InvalidParameterException();
    if (divisor == 1) return dividend;
    if (divisor == -1) {
      if (dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;
      return -1 * dividend;
    }

    int sign = dividend < 0 ^ divisor < 0 ? -1 : 1;
    int result = 0;
    long longDividend = Math.abs((long) dividend);
    long longDivisor = Math.abs((long) divisor);
    while (longDividend >= longDivisor) {
      longDividend -= longDivisor;
      result += 1;
    }
    return result * sign;
  }
}
