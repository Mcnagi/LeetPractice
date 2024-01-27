package problems.q0001_Q0030;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q0011Test {
  public void test(int expected, int[] input) {
    var q = new Q0011ContainerWithMostWater();
    Assertions.assertEquals(
        expected,
        q.maxArea(input),
        String.format("Expect to have %s with input: %s", expected, Arrays.toString(input)));
  }

  @Test
  public void testSimple() {
    int[][] array =
        new int[][] {
          new int[] {1, 0},
          new int[] {0, 1},
          new int[] {1, 1},
          new int[] {1, 2},
          new int[] {2, 1},
          new int[] {5, 5},
          new int[] {1, 10}
        };
    int[] answers = new int[] {0, 0, 1, 1, 1, 5, 1};
    for (int i = 0; i < answers.length; i++) {
      test(answers[i], array[i]);
    }
  }

  @Test
  public void testMedian() {
    test(49, new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7});
    test(3, new int[] {1, 1, 1, 1});
    test(3, new int[] {1, 2, 1, 1});
    test(6, new int[] {2, 2, 1, 2});
    test(8, new int[] {2, 3, 2, 2, 2});
    test(9, new int[] {2, 3, 2, 2, 3});
    test(12, new int[] {3, 3, 3, 3, 3});
    test(12, new int[] {3, 4, 3, 3, 4});
    test(16, new int[] {4, 5, 4, 4, 5});
  }

  //    @Test
  //    public void testHard() {
  //
  //   }
}
