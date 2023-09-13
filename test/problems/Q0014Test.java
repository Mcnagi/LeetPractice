package problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
14. Longest Common Prefix
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.


Constraints:
    1 <= strs.length <= 200
    0 <= strs[i].length <= 200
    strs[i] consists of only lowercase English letters.
 */
public class Q0014Test {
  public void test(String expected, String[] input) {
    var q14 = new Q0014LongestCommonPrefix();
    Assertions.assertEquals(expected, q14.longestCommonPrefix(input));
  }

  @Test
  public void testEmpty() {
    String[][] inputs =
        new String[][] {
          new String[] {"", "", ""},
          new String[] {"", "1", "2"},
          new String[] {"a", "", "acb"},
          new String[] {"a", "b", "acb"},
          new String[] {"dog", "racecar", "car"}
        };
    for (int i = 0; i < inputs.length; i++) {
      test("", inputs[i]);
    }
  }

  @Test
  public void testShort() {
    String[][] inputs =
        new String[][] {
          new String[] {"a", "a", "a"},
          new String[] {"a", "a1", "a2a"},
          new String[] {"aca", "aaa", "acb"},
          new String[] {"ac", "ac1", "acb"},
          new String[] {"dog", "dogOfTheYear", "dogAndCat"}
        };
    String[] answers = new String[] {"a", "a", "a", "ac", "dog"};
    for (int i = 0; i < inputs.length; i++) {
      test(answers[i], inputs[i]);
    }
  }
}
