package problems.q0031_Q0060;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import problems.q0031_Q0060.Q0042TrappingRainWater;

public class Q0042Test {
  public void test(int expected, int[] input) {
    var q = new Q0042TrappingRainWater();
    var actual = q.trap(input);
    Assertions.assertEquals(
        expected,
        actual,
        String.format(
            "Expect to have %s but got %s with input: %s",
            expected, actual, Arrays.toString(input)));
  }

  @Test
  public void testZero() {
    test(0, new int[] {0, 0, 0, 0});
    test(0, new int[] {1, 1, 1, 1});
    test(0, new int[] {10, 10, 10, 10});
    test(0, new int[] {0, 0, 1, 1, 2, 3, 4});
    test(0, new int[] {0, 0, 1, 1, 2, 3, 4, 3, 2, 1});
    test(0, new int[] {0, 0, 1, 1, 2, 3, 4, 3, 2, 2, 2});
  }

  @Test
  public void testOne() {
    test(1, new int[] {1, 0, 1});
    test(1, new int[] {1, 0, 1, 0});
    test(1, new int[] {1, 0, 1, 1});
    test(1, new int[] {2, 1, 2});
    test(1, new int[] {3, 3, 2, 3});

    test(1, new int[] {3, 10, 9, 10});
    test(1, new int[] {3, 10, 9, 11, 10});
  }

  @Test
  public void testHard() {
    test(6, new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
    test(9, new int[] {4, 2, 0, 3, 2, 5});
    test(1, new int[] {5, 4, 1, 2});
    test(
        83,
        new int[] {6, 4, 2, 0, 3, 2, 0, 3, 1, 4, 5, 3, 2, 7, 5, 3, 0, 1, 2, 1, 3, 4, 6, 8, 1, 3});
  }
}
