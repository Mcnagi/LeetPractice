package problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import problems.other.Q0224BasicCalculator;

public class Q0224Test {
  public void test(int expected, String input) {
    var q = new Q0224BasicCalculator();
    var actual = q.calculate(input);
    Assertions.assertEquals(
        expected,
        actual,
        String.format("Expect to have %s but got %s with input: %s", expected, actual, input));
  }

  @Test
  public void testSimple() {
    test(2, "1 + 1");
    test(2, "1+1");
    test(2, " 1 + 1 ");
    test(2, " 1+1 ");
    test(3, " 2+1 ");
    test(3, "1+2");
    test(19, "10+9");
    test(200, "99+101");
    test(1, "1");
    test(1, "(1)");
    test(1, "((1))");
    test(1, "-(-(1))");
    test(-1, "-(-(-1))");
  }

  @Test
  public void testMedian() {
    test(6, "1 + 2 + 3");
    test(44, "27 + 8 + 9");
    test(2126, "5 + 101 + 2020");
    test(-11, "- (5 + 6)");
    test(-11, "-5 - 6");
    test(8, "(5+6) - (1+ 2)");
    test(-21, "(5+6) - (11+ 21)");
  }

  @Test
  public void testHard() {
    test(23, "(1+(4+5+2)-3)+(6+8)");
    test(31, "(12 + 23 - (1 + 2)) + 5 - 6");
    test(-33, "-(12 + 23 - (1 + 2)) + 5 - 6");
    test(37, "(12 + 23 - (1 + 2)) + 5 - 6 + (10 -4 )");
  }
}
