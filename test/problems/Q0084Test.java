package problems;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import problems.Q0061_Q0090.Q0084LargestRectangleInHistogram;

public class Q0084Test {

  public void test(int expected, int[] input) {
    var q = new Q0084LargestRectangleInHistogram();
    var actual = q.largestRectangleArea(input);
    Assertions.assertEquals(
        expected,
        actual,
        String.format(
            "Expect to have %s but got %s with input: %s",
            expected, actual, Arrays.toString(input)));
  }

  @Test
  public void testSingle() {
    for (int i = 1; i < 100; i++) {
      test(i, new int[] {i});
    }
  }

  @Test
  public void testTwo() {
    test(2, new int[] {1, 2});
    test(2, new int[] {2, 1});

    test(3, new int[] {1, 3});

    test(4, new int[] {2, 4});
    test(4, new int[] {4, 2});

    test(20, new int[] {10, 10});
    test(20, new int[] {10, 11});
    test(20, new int[] {12, 10});
  }

  @Test
  public void testLong() {
    test(10, new int[] {2, 1, 5, 6, 2, 3});
    test(8, new int[] {2, 1, 5, 2, 6, 3});

    test(12, new int[] {2, 2, 2, 2, 2, 2});
    test(12, new int[] {2, 2, 2, 5, 2, 2});
    test(12, new int[] {2, 2, 2, 7, 2, 2});

    test(12, new int[] {1, 2, 3, 3, 5, 6});
    test(15, new int[] {1, 2, 3, 5, 5, 6});

    test(10, new int[] {5, 2, 2, 2, 2});
  }
}
