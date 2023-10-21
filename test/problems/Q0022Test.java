package problems;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import problems.Q0001_Q0030.Q0022GenerateParentheses;

public class Q0022Test {
  public void test(Set<String> expected, int input) {
    var q = new Q0022GenerateParentheses();
    var actual = q.generateParenthesis(input);
    Assertions.assertTrue(
        expected.containsAll(actual) && expected.size() == actual.size(),
        String.format("Expect to have %s but got %s with input: %s", expected, actual, input));
  }

  @Test
  public void testOne() {
    test(new HashSet<>(Set.of("()")), 1);
  }

  @Test
  public void testTwo() {
    test(new HashSet<>(Set.of("()()", "(())")), 2);
  }

  @Test
  public void testThree() {
    test(new HashSet<>(Set.of("()()()", "()(())", "(())()", "(()())", "((()))")), 3);
  }
}
