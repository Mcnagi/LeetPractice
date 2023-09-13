package problems;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q0229Test {
  public void test(List<Integer> expected, int[] input) {
    var q = new Q0229MajorityElementII();
    var actual = q.majorityElement(input);
    Assertions.assertEquals(
        expected,
        actual,
        String.format("Expect to have %s but got %s with input: %s", expected, actual, input));
  }

  @Test
  public void testEmpty() {
    test(List.of(), new int[] {1, 2, 3});
    test(List.of(), new int[] {1, 2, 3, 4});
    test(List.of(), new int[] {1, 2, 3, 4, 5});

    test(List.of(), new int[] {-1, 2, 1, 4, 5});
    test(List.of(), new int[] {-1, 2, 1, 4, 5, 1});
    test(List.of(), new int[] {1, 2, -1});

    int[] testCase = new int[50];
    for (int i = 0; i < testCase.length; i++) testCase[i] = i;
    test(List.of(), testCase);
  }

  @Test
  public void testOne() {
    test(List.of(1), new int[] {1, 1, 2});
    test(List.of(1), new int[] {1, 1, 2, 1});
    test(List.of(1), new int[] {1, 1, 2, 1, 1, -1});

    test(List.of(2), new int[] {2});
    test(List.of(-10), new int[] {-10, -10});

    int[] testCase = new int[50];
    for (int i = 0; i < testCase.length / 3 + 1; i++) testCase[i] = 13;
    for (int i = testCase.length / 3 + 1; i < testCase.length; i++) testCase[i] = i;
    test(List.of(13), testCase);

    test(List.of(3), new int[] {1, 3, 3, 4});
  }

  @Test
  public void testTwo() {
    test(List.of(1, 2), new int[] {1, 2});
    test(List.of(1, 2), new int[] {1, 1, 2, 2});

    test(List.of(-1, 2), new int[] {-1, -1, -1, 2, 2});
    test(List.of(-1, 3), new int[] {-1, -1, -1, 3, 3, 3});
  }
}
