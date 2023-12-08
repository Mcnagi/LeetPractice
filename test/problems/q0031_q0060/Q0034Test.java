package problems.q0031_q0060;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import problems.Q0031_Q0060.Q0034FindFirstLast;

public class Q0034Test {
  public void test(int[] expected, int[] array, int target) {
    var q = new Q0034FindFirstLast();
    var actual = q.searchRange(array, target);
    Assertions.assertArrayEquals(
        expected,
        actual,
        String.format(
            "Expect to have %s but got %s with input: %s",
            Arrays.toString(expected), Arrays.toString(actual), Arrays.toString(array) + target));
  }

  @Test
  public void testSame() {
    test(new int[] {0, 0}, new int[] {1}, 1);
    test(new int[] {0, 1}, new int[] {1, 1}, 1);
    test(new int[] {0, 4}, new int[] {10, 10, 10, 10, 10}, 10);
    test(new int[] {-1, -1}, new int[] {10, 10, 10, 10, 10}, 1);
  }

  @Test
  public void testOneSide() {
    test(new int[] {0, 0}, new int[] {1, 2, 3}, 1);
    test(new int[] {0, 1}, new int[] {1, 1, 2, 3}, 1);
    test(new int[] {3, 3}, new int[] {1, 1, 2, 3}, 3);
    test(new int[] {3, 5}, new int[] {1, 1, 2, 6, 6, 6}, 6);
  }

  @Test
  public void testHard() {

    test(new int[] {2, 5}, new int[] {1, 2, 3, 3, 3, 3, 4, 5, 9}, 3);
    test(new int[] {8, 11}, new int[] {0, 0, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4}, 3);
  }
}
