package problems.q0001_Q0030;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q0016Test {

  public void test(int expected, int[] array, int target) {
    var q = new Q0016ThreeSumClosest();
    Assertions.assertEquals(
        expected,
        q.threeSumClosest(array, target),
        String.format(
            "Expect to have %s with input: %s, %s", expected, Arrays.toString(array), target));
  }

  @Test
  public void testShortArray() {
    test(0, new int[] {0, 0, 0}, 1);
    test(0, new int[] {0, 0, 0}, 0);
    test(0, new int[] {0, 0, 0}, 3);
    test(1, new int[] {0, 0, 1, 0}, 1);
    test(0, new int[] {0, 0, 1, 0}, 0);
    test(3, new int[] {0, 1, 2, 3}, 1);
    test(3, new int[] {0, 1, 2, 3}, 3);
    test(4, new int[] {0, 1, 2, 3}, 4);
    test(5, new int[] {0, 1, 2, 3}, 5);
    test(6, new int[] {0, 1, 2, 3}, 6);
  }

  @Test
  public void testMedian() {
    test(2, new int[] {-1, 2, 1, -4}, 1);
    test(2, new int[] {-1, 2, 1, -4}, 2);
    test(-1, new int[] {-1, 2, 1, -4}, 0);
    test(-4, new int[] {-1, 2, 1, -4}, -4);
    test(2, new int[] {-1, 2, 1, -4}, 3);
    for (int i = 0; i < 9; i++) {
      test(i, new int[] {-1, 2, 1, -4, 0, 5}, i);
    }
  }

  @Test
  public void testHard() {
    int[] array = new int[] {1, 4, -5, 10, -23, 33, 40, 100, -55, 0, 0};
    int[] targets = new int[] {10, 120, 12, 30, 55, 60, 73, 130};
    int[] answers = new int[] {10, 117, 12, 29, 55, 55, 73, 128};
    for (int i = 0; i < targets.length; i++) {
      test(answers[i], array, targets[i]);
    }
  }
}
