package problems.q0031_Q0060;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import problems.q0031_Q0060.Q0035SearchInsertPosition;

public class Q0035Test {
  public void test(int expected, int[] array, int target) {
    var q = new Q0035SearchInsertPosition();
    var actual = q.searchInsert(array, target);
    Assertions.assertEquals(
        expected,
        actual,
        String.format(
            "Expect to have %s but got %s with input: %s",
            expected, actual, Arrays.toString(array) + target));
  }

  @Test
  public void testOne() {
    test(0, new int[] {1}, 0);
    test(0, new int[] {1}, -1);
    test(0, new int[] {1}, -10);
    test(0, new int[] {10}, -10);
    test(0, new int[] {-100}, -101);

    test(1, new int[] {1}, 2);
    test(1, new int[] {1}, 2);
    test(1, new int[] {1}, 10);
    test(1, new int[] {10}, 11);
    test(1, new int[] {-100}, -99);
  }

  @Test
  public void testTwo() {
    test(0, new int[] {1, 2}, -1);
    test(0, new int[] {1, 2}, 0);
    test(0, new int[] {1, 2}, 1);
    test(1, new int[] {1, 2}, 2);
    test(2, new int[] {1, 2}, 10);
  }

  @Test
  public void testThree() {
    test(0, new int[] {1, 2, 3}, 0);
    test(0, new int[] {1, 2, 3}, 1);
    test(0, new int[] {1, 2, 3}, 1);
    test(1, new int[] {1, 2, 3}, 2);
    test(2, new int[] {1, 2, 3}, 3);
    test(3, new int[] {1, 2, 3}, 4);

    test(0, new int[] {-5, 5, 10}, -6);
    test(0, new int[] {-5, 5, 10}, -5);
    test(1, new int[] {-5, 5, 10}, -4);
    test(1, new int[] {-5, 5, 10}, 0);
    test(1, new int[] {-5, 5, 10}, 5);
    test(2, new int[] {-5, 5, 10}, 6);
    test(2, new int[] {-5, 5, 10}, 10);
    test(3, new int[] {-5, 5, 10}, 100);

    test(0, new int[] {-5, -4, -1}, -6);
    test(0, new int[] {-5, -4, -1}, -5);
    test(1, new int[] {-5, -4, -1}, -4);
    test(2, new int[] {-5, -4, -1}, -3);
    test(2, new int[] {-5, -4, -1}, -2);
    test(2, new int[] {-5, -4, -1}, -1);
    test(3, new int[] {-5, -4, -1}, 0);
  }

  @Test
  public void testMultiple() {
    test(2, new int[] {1, 3, 5, 6}, 5);
    test(1, new int[] {1, 3, 5, 6}, 2);
    test(4, new int[] {1, 3, 5, 6}, 7);
  }
}
