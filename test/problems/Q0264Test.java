package problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import problems.other.Q0264UglyNumberII;

public class Q0264Test {
  public void test(int expected, int input) {
    var q = new Q0264UglyNumberII();
    var actual = q.nthUglyNumber(input);
    Assertions.assertEquals(
        expected,
        actual,
        String.format("Expect to have %s but got %s with input: %s", expected, actual, input));
  }

  @Test
  public void testSimple() {
    test(1, 1);
    test(2, 2);
    test(12, 10);
    test(16, 12);
  }

  @Test
  public void testMedian() {
    test(36, 20);
    test(40, 21);
    test(45, 22);
    test(48, 23);
    test(50, 24);
    test(54, 25);
  }

  @Test
  public void testHard() {
    test(1536, 100);
    test(16200, 200);
    test(51_200_000, 1000);
    test(402_653_184, 1352);
    test(1_382_400_000, 1599);
    test(1_399_680_000, 1600);
  }
}
