package problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import problems.Q0031_Q0060.Q0043MultiplyStrings;

public class Q0043Test {
  public void test(String expected, String a, String b) {
    var q = new Q0043MultiplyStrings();
    var actual = q.multiply(a, b);
    Assertions.assertEquals(
        expected,
        actual,
        String.format(
            "Expect to have %s but got %s with input: %s", expected, actual, a + " and " + b));
  }

  @Test
  public void testSimple() {
    test("1", "1", "1");
    test("2", "2", "1");
    test("3", "3", "1");
    test("6", "2", "3");
    test("10", "2", "5");
    test("81", "9", "9");
    test("56", "7", "8");
  }

  @Test
  public void testMedian() {
    test("121", "11", "11");
    test("144", "12", "12");
    test("165", "15", "11");
    test("200", "10", "20");
  }

  @Test
  public void testHard() {
    test("9801", "99", "99");
    test("5332114", "1234", "4321");
  }

  @Test
  public void testZero() {
    test("0", "0", "0");
    test("0", "1000", "0");
  }
}
