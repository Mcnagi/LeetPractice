package problems.Q0001_Q0030;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import problems.Q0001_Q0030.Q0018FourSum;

public class Q0018Test {
  public void test(List<List<Integer>> expected, int[] array, int target) {
    var q = new Q0018FourSum();
    var actual = q.fourSum(array, target);
    Assertions.assertTrue(
        expected.containsAll(actual) && expected.size() == actual.size(),
        String.format(
            "Expect to have %s but got %s with input: %s",
            expected, actual, Arrays.toString(array)));
  }

  @Test
  public void testSimple() {
    List<List<Integer>> answer = new ArrayList<>();
    answer.add(new ArrayList<>(List.of(2, 2, 2, 2)));
    test(answer, new int[] {2, 2, 2, 2}, 8);
  }

  @Test
  public void testMedian() {
    List<List<Integer>> answer = new ArrayList<>();
    answer.add(new ArrayList<>(List.of(-2, -1, 1, 2)));
    answer.add(new ArrayList<>(List.of(-2, 0, 0, 2)));
    answer.add(new ArrayList<>(List.of(-1, 0, 0, 1)));
    test(answer, new int[] {1, 0, -1, 0, -2, 2}, 0);

    answer.clear();
    answer.add(new ArrayList<>(List.of(-2, -1, 1, 2)));
    answer.add(new ArrayList<>(List.of(-1, -1, 1, 1)));
    test(answer, new int[] {-2, -1, -1, 1, 1, 2, 2}, 0);
  }

  @Test
  public void testHard() {
    List<List<Integer>> answer = new ArrayList<>();
    answer.add(new ArrayList<>(List.of(-5, 2, 2, 4)));
    answer.add(new ArrayList<>(List.of(-1, 0, 2, 2)));
    test(answer, new int[] {-1, 2, 2, -5, 0, -1, 4}, 3);

    answer.clear();
    answer.add(new ArrayList<>(List.of(-4, 5, 5, 5)));
    answer.add(new ArrayList<>(List.of(0, 1, 5, 5)));
    test(answer, new int[] {0, 1, 5, 0, 1, 5, 5, -4}, 11);

    answer.clear();
    answer.add(new ArrayList<>(List.of(0, 0, 0, 1_000_000_000)));
    test(
        answer,
        new int[] {0, 0, 0, 1_000_000_000, 1_000_000_000, 1_000_000_000, 1_000_000_000},
        1_000_000_000);
  }
}
