package problems;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q0881Test {
  public void test(int expected, int[] array, int limit) {
    var q = new Q0881BoatsToSavePeople();
    var actual = q.numRescueBoats(array, limit);
    Assertions.assertEquals(
        expected,
        actual,
        String.format(
            "Expect to have %s but got %s with input: %s",
            expected, actual, Arrays.toString(array) + limit));
  }

  @Test
  public void testTwoOrLess() {
    test(1, new int[] {1}, 3);
    test(1, new int[] {10}, 10);

    test(1, new int[] {1, 1}, 3);
    test(1, new int[] {1, 2}, 3);
    test(2, new int[] {2, 2}, 3);
    test(2, new int[] {3, 1}, 3);

    test(1, new int[] {99, 1}, 100);
  }

  @Test
  public void testLinear() {
    test(3, new int[] {3, 2, 2, 1}, 3);
    test(4, new int[] {3, 5, 3, 4}, 5);
  }

  @Test
  public void testHard() {
    test(2, new int[] {4, 3, 4, 5}, 8);

    test(3, new int[] {6, 5, 4, 4, 3}, 10);
  }
}
