package problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import problems.Q0001_Q0030.Q0020ValidParentheses;

public class Q0020Test {

  public void testTrue(String s) {
    var q20 = new Q0020ValidParentheses();
    Assertions.assertTrue(q20.isValid(s));
  }

  public void testFalse(String s) {
    var q20 = new Q0020ValidParentheses();
    Assertions.assertFalse(q20.isValid(s));
  }

  @Disabled
  @Test
  public void testSimple() {
    String[] testTrueSample =
        new String[] {
          "()", "[]", "{}", "()[]", "[]()", "{}()",
          "()()", "[][]", "{}{}", "()[][]", "[](){}", "{}(){}",
        };
    for (int i = 0; i < testTrueSample.length; i++) {
      testTrue(testTrueSample[i]);
    }

    String[] testFalseSample =
        new String[] {
          "(", ")", "[", "]", "{", "}", "({", "([", "(]", "(}", "(){", "{}}", "[]}", "[}]", "{)}",
          "{(}", "{}{}]", "([}])"
        };
    for (int i = 0; i < testTrueSample.length; i++) {
      testFalse(testFalseSample[i]);
    }
  }
}
