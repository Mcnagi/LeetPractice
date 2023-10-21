package problems.Q0001_Q0030;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import problems.Q0001_Q0030.Q0029DivideTwoIntegers;

public class Q0029Test {

  public void test(int expected, int dividend, int divisor) {
    var q = new Q0029DivideTwoIntegers();
    var actual = q.divide(dividend, divisor);
    Assertions.assertEquals(
        expected,
        actual,
        String.format(
            "Expect to have %s but got %s with input: %s",
            expected, actual, dividend + " and " + divisor));
  }

  @Test
  public void testPositive() {
    test(1, 4, 3);
    test(1, 4, 4);
    test(0, 4, 5);

    test(3, 10, 3);
    test(4, 19, 4);
    test(100, 10001, 100);
  }

  @Test
  public void testNegative() {
    test(-2, 7, -3);
    test(-2, -7, 3);
    test(2, -7, -3);

    test(2, -6, -3);
    test(-2, 6, -3);
  }

  @Test
  public void testOverflow() {
    test(2147483647, -2147483648, -1);
    test(2147483647, 2147483647, 1);
    test(-2147483648, -2147483648, 1);
    //        test(-1073741824, -2147483648, 2);

    test(1, -2147483648, -2147483648);
    test(1, -2147483648, -2147483647);
    test(0, -2147483647, -2147483648);
    test(0, 2147483647, -2147483648);
    test(715827882, -2147483648, -3);
  }
}
