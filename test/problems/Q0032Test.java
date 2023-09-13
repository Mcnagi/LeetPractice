package problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q0032Test {
  public void test(int expected, String input) {
    var q = new Q0032LongestValidParentheses();
    var actual = q.longestValidParentheses(input);
    Assertions.assertEquals(
        expected,
        actual,
        String.format("Expect to have %s but got %s with input: %s", expected, actual, input));
  }

  @Test
  public void testZero() {
    test(0, "");
    test(0, "(");
    test(0, ")");
    test(0, ")");
    test(0, ")((");
    test(0, "))((");
    test(0, "))((");
    test(0, "((((((");
  }

  @Test
  public void testFlat() {
    test(2, "()");
    test(2, "()((");
    test(2, "()(()");
    test(2, ")()");
    test(2, ")()((");

    test(4, "()()");
    test(4, ")()())(");
    test(4, ")()())()");
  }

  @Test
  public void testNested() {
    test(4, "(())");
    test(4, "))(())");
    test(4, "())(())");
    test(4, "))(())(()");

    test(6, "((()))");
    test(6, "(())()");
    test(6, "()(())");
    test(6, "))(()(())");

    test(8, "(()()())");
    test(8, "))(())(())");
    String left = "(";
    String right = ")";
    test(100 * 2, left.repeat(100) + right.repeat(101));
  }
}
