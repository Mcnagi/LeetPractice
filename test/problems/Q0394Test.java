package problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q0394Test {
  public void test(String expected, String input) {
    var q = new Q0394DecodeString();
    var actual = q.decodeString(input);
    Assertions.assertEquals(
        expected,
        actual,
        String.format("Expect to have %s but got %s with input: %s", expected, actual, input));
  }

  @Test
  public void testLetters() {
    test("a", "a");
    test("bc", "bc");
    test("xyz", "xyz");
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < 26; i++) {
      builder.append((char) ('a' + i));
    }
    test(builder.toString(), builder.toString());
  }

  @Test
  public void testFlat() {
    String[] inputs = {
      "1[a]",
      "2[a]",
      "1[a]1[b]",
      "2[ab]3[cd]",
      "2[ab]1[g]3[z]",
      "2[ab]3[zxc]1[qwe]",
      "10[z]",
      "15[z]"
    };
    String[] answers = {
      "a", "aa", "ab", "ababcdcdcd", "ababgzzz", "ababzxczxczxcqwe", "zzzzzzzzzz", "zzzzzzzzzzzzzzz"
    };
    for (int i = 0; i < inputs.length; i++) {
      test(answers[i], inputs[i]);
    }
  }

  @Test
  public void testNested() {
    String[] inputs = {
      "1[a1[c]]",
      "1[a2[c]]",
      "3[a2[c1[d]]]",
      "3[ab2[c1[d]]ab]",
      "3[ab2[c1[d]c]ab]",
      "abc3[ddq2[xyz]1[a]]1[z]",
      "3[z]2[2[y]pq4[2[jk]e1[f]]]ef"
    };
    String[] answers = {
      "ac",
      "acc",
      "acdcdacdcdacdcd",
      "abcdcdababcdcdababcdcdab",
      "abcdccdcababcdccdcababcdccdcab",
      "abcddqxyzxyzaddqxyzxyzaddqxyzxyzaz",
      "zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef"
    };
    for (int i = 0; i < inputs.length; i++) {
      test(answers[i], inputs[i]);
    }
  }
}
