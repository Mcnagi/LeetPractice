package problems.q0031_q0060;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import problems.Q0031_Q0060.Q0033SearchRotated;

public class Q0033Test {
  public void test(int expected, int[] input, int target) {
    var q = new Q0033SearchRotated();
    var actual = q.search(input, target);
    Assertions.assertEquals(
        expected,
        actual,
        String.format(
            "Expect to have %s but got %s with input: %s",
            expected, actual, Arrays.toString(input) + " " + target));
  }

  @Test
  public void testSimple() {
    test(0, new int[] {11}, 11);
    test(-1, new int[] {11}, 12);

    test(0, new int[] {1, 2}, 1);
    test(1, new int[] {2, 1}, 1);
    test(-1, new int[] {2, 1}, 3);
  }

  @Test
  public void testMedian() {
    test(2, new int[] {3, 5, 1}, 1);
  }

  @Test
  public void testLong() {
    test(4, new int[] {4, 5, 6, 7, 0, 1, 2}, 0);
    test(-1, new int[] {4, 5, 6, 7, 0, 1, 2}, 3);

    test(3, new int[] {6, 1, 2, 3, 4, 5}, 3);
    test(4, new int[] {5, 6, 1, 2, 3, 4}, 3);
  }
}
