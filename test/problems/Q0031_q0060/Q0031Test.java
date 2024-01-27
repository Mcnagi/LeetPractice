package problems.Q0031_q0060;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import problems.Q0031_Q0060.Q0031NextPermutation;

public class Q0031Test {
  public void test(int[] expected, int[] input) {
    int[] original = input.clone();

    var q = new Q0031NextPermutation();
    q.nextPermutation(input);

    Assertions.assertArrayEquals(
        expected,
        input,
        String.format(
            "Expect to have %s but got %s with input: %s",
            Arrays.toString(expected), Arrays.toString(input), Arrays.toString(original)));
  }

  @Test
  public void testShort() {
    test(new int[] {1}, new int[] {1});
    test(new int[] {2}, new int[] {2});

    test(new int[] {2, 3}, new int[] {3, 2});
    test(new int[] {21, 3}, new int[] {3, 21});
  }

  @Test
  public void testThree() {
    test(new int[] {10, 3, 21}, new int[] {3, 21, 10});
    test(new int[] {10, 21, 3}, new int[] {10, 3, 21});
    test(new int[] {21, 3, 10}, new int[] {10, 21, 3});
    test(new int[] {21, 10, 3}, new int[] {21, 3, 10});
    test(new int[] {3, 10, 21}, new int[] {21, 10, 3});
    test(new int[] {3, 21, 10}, new int[] {3, 10, 21});
  }

  @Test
  public void testFive() {
    test(new int[] {1, 2, 3, 5, 4}, new int[] {1, 2, 3, 4, 5});
    test(new int[] {5, 2, 3, 4, 1}, new int[] {5, 2, 3, 1, 4});
    test(new int[] {5, 2, 4, 1, 3}, new int[] {5, 2, 3, 4, 1});
    test(new int[] {5, 3, 1, 2, 4}, new int[] {5, 2, 4, 3, 1});
    test(new int[] {1, 2, 3, 4, 5}, new int[] {5, 4, 3, 2, 1});
  }

  @Test
  public void testSameValue() {
    test(new int[] {1, 1, 5, 1}, new int[] {1, 1, 1, 5});
    test(new int[] {1, 5, 1, 1}, new int[] {1, 1, 5, 1});
    test(new int[] {5, 1, 1, 1}, new int[] {1, 5, 1, 1});
    test(new int[] {1, 1, 1, 5}, new int[] {5, 1, 1, 1});

    // leetcode test case
    test(new int[] {2, 3, 1, 2, 2, 2, 4, 5, 7}, new int[] {2, 2, 7, 5, 4, 3, 2, 2, 1});
  }
}
