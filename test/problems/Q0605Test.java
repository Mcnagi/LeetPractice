package problems;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import problems.other.Q0605CanPlaceFlowers;

public class Q0605Test {
  public void testTrue(int[] array, int n) {
    var q = new Q0605CanPlaceFlowers();
    var actual = q.canPlaceFlowers(array, n);
    Assertions.assertTrue(
        actual,
        String.format("Expect to be true with input: %s and %s", Arrays.toString(array), n));
  }

  public void testFalse(int[] array, int n) {
    var q = new Q0605CanPlaceFlowers();
    var actual = q.canPlaceFlowers(array, n);
    Assertions.assertFalse(
        actual,
        String.format("Expect to be false with input: %s and %s", Arrays.toString(array), n));
  }

  @Test
  public void testInBetween() {
    testTrue(new int[] {1, 0, 1}, 0);
    for (int i = 1; i < 5; i++) testFalse(new int[] {1, 0, 1, 0, 1}, i);

    testTrue(new int[] {1, 0, 0, 1}, 0);
    testTrue(new int[] {1, 0, 0, 0, 1}, 0);
    testTrue(new int[] {1, 0, 0, 0, 1}, 1);

    testTrue(new int[] {1, 0, 0, 0, 0, 0, 1}, 2);
    testFalse(new int[] {1, 0, 0, 0, 0, 0, 1}, 3);

    testTrue(new int[] {1, 0, 0, 0, 0, 0, 0, 1}, 2);
    testFalse(new int[] {1, 0, 0, 0, 0, 0, 0, 1}, 3);

    testTrue(new int[] {1, 0, 0, 0, 0, 0, 0, 0, 1}, 3);
    testFalse(new int[] {1, 0, 0, 0, 0, 0, 0, 0, 1}, 4);
  }

  @Test
  public void testOnEnds() {
    testTrue(new int[] {0, 0, 1}, 0);
    testTrue(new int[] {0, 0, 1}, 1);
    testTrue(new int[] {1, 0, 0}, 1);

    testTrue(new int[] {0, 0, 1, 0, 0}, 2);
    testTrue(new int[] {0, 0, 1, 0, 0}, 2);
    testFalse(new int[] {0, 0, 1, 0, 0}, 3);

    testTrue(new int[] {0, 0, 0, 1, 0, 0}, 2);
    testFalse(new int[] {0, 0, 0, 1, 0, 0}, 3);

    testTrue(new int[] {0, 0, 0, 0, 1, 0, 0}, 3);
  }

  @Test
  public void testEmptyFlowerbed() {
    testTrue(new int[] {0}, 1);
    testTrue(new int[] {0, 0}, 1);
    testTrue(new int[] {0, 0, 0}, 2);
    testTrue(new int[] {0, 0, 0, 0}, 2);
    testTrue(new int[] {0, 0, 0, 0, 0}, 3);

    testFalse(new int[] {0}, 1 + 1);
    testFalse(new int[] {0, 0}, 1 + 1);
    testFalse(new int[] {0, 0, 0}, 2 + 1);
    testFalse(new int[] {0, 0, 0, 0}, 2 + 1);
    testFalse(new int[] {0, 0, 0, 0, 0}, 3 + 1);
  }
}
