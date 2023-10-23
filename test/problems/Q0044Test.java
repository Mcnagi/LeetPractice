package problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import problems.Q0031_Q0060.Q0044WildcardMatching;

public class Q0044Test {
  public void testTrue(String s, String p) {
    var q = new Q0044WildcardMatching();
    var actual = q.isMatch(s, p);
    Assertions.assertTrue(
        actual,
        String.format("Expect to have be true but got %s with input: %s", actual, s + " and " + p));
  }

  public void testFalse(String s, String p) {
    var q = new Q0044WildcardMatching();
    var actual = q.isMatch(s, p);
    Assertions.assertFalse(
        actual,
        String.format(
            "Expect to have be false but got %s with input: %s", actual, s + " and " + p));
  }

  @Test
  public void testExact() {
    testTrue("abc", "abc");
    testTrue("zka", "zka");
    testTrue("", "");
    testTrue("zxcvbnm", "zxcvbnm");

    testFalse("abc", "abcd");
    testFalse("zka", "zk");
    testFalse("", "a");
    testFalse("xzcvbnm", "zxcvbnm");
  }

  @Test
  public void testStar() {
    testTrue("abcsadf", "*");
    testTrue("abcsadf", "*adf");
    testTrue("abcsadf", "a*");
    testTrue("abcsadf", "a*f");
    testTrue("abcsadf", "a*adf");
    testTrue("abcsadf", "abcs*adf");
    testTrue("abcsadf", "*abcsadf");
    testTrue("abcsadf", "abcsadf*");

    testFalse("abcsadf", "abcsadf*a");
    testFalse("aabcsadf", "abcsadf*");
    testFalse("aabcsadf", "a*a");
  }

  @Test
  public void testQuestionMark() {
    testTrue("abc", "ab?");
    testTrue("abcd", "a??d");
    testTrue("abcd", "????");
    testFalse("ab", "ab?");
    testFalse("ab", "???");
  }

  @Test
  public void testMixed() {
    testTrue("abc", "?*");
    testTrue("abc", "*?*");
    testTrue("abc", "**?*");
    testTrue("abc", "**???**");
    testTrue("abc", "a?*c");
    testTrue("abc", "?*b*");

    testFalse("abc", "a?*b");
    testFalse("abc", "?*b");
  }
}
