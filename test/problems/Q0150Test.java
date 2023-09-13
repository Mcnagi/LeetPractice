package problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q0150Test {

  public void test(int expected, String[] input) {
    var q = new Q0150EvaluateReversePolishNotation();
    var actual = q.evalRPN(input);
    Assertions.assertEquals(
        expected,
        actual,
        String.format("Expect to have %s but got %s with input: %s", expected, actual, input));
  }

  @Test
  public void testSimple() {
    String[][] inputs =
        new String[][] {
          {"1", "2", "+"},
          {"1", "2", "-"},
          {"1", "2", "*"},
          {"1", "2", "/"},
          {"2", "1", "+"},
          {"2", "1", "-"},
          {"2", "1", "*"},
          {"2", "1", "/"},
          {"2", "2", "+"},
          {"2", "2", "-"},
          {"2", "2", "*"},
          {"2", "2", "/"}
        };
    int[] answers = {3, -1, 2, 0, 3, 1, 2, 2, 4, 0, 4, 1};
    for (int i = 0; i < inputs.length; i++) {
      test(answers[i], inputs[i]);
    }
  }

  @Test
  public void testMedian() {
    String[][] inputs =
        new String[][] {
          {"2", "1", "+", "3", "*"},
          {"4", "13", "5", "/", "+"}
        };
    int[] answers = {9, 6};
    for (int i = 0; i < inputs.length; i++) {
      test(answers[i], inputs[i]);
    }
  }

  @Test
  public void testHard() {
    String[][] inputs =
        new String[][] {{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}};
    int[] answers = {22};
    for (int i = 0; i < inputs.length; i++) {
      test(answers[i], inputs[i]);
    }
  }
}
