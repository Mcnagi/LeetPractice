package problems;

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:
string convert(string s, int numRows);

Example 1:
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

Example 2:
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I

Example 3:
Input: s = "A", numRows = 1
Output: "A"

Constraints:
1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000
 */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import problems.Q0001_Q0030.Q0006ZigzagConversion;

public class Q0006Test {

  @Test
  public void testOneRow() {
    var q6 = new Q0006ZigzagConversion();
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < 52; i++) {
      char next = (char) ('A' + i);
      Assertions.assertEquals(String.valueOf(next), q6.convert(String.valueOf(next), 1));
      builder.append(next);
      String actual = q6.convert(builder.toString(), 1);
      Assertions.assertEquals(builder.toString(), actual);
    }
  }

  @Test
  public void testTwoRows() {
    var q6 = new Q0006ZigzagConversion();
    String[] tests = new String[] {"abcdefg", "321123", "121212", "ABCDEFG", "gfedcba", "1ah3z.2"};
    String[] answers =
        new String[] {"acegbdf", "312213", "111222", "ACEGBDF", "gecafdb", "1hz2a3."};
    for (int i = 0; i < tests.length; i++) {
      Assertions.assertEquals(answers[i], q6.convert(tests[i], 2));
    }
  }

  @Test
  public void testThreeRows() {
    var q6 = new Q0006ZigzagConversion();
    String[] tests = new String[] {"PAYPALISHIRING", "ABCDEFG", "abcdefg", "15C627D839EA4BF"};

    String[] answers = new String[] {"PAHNAPLSIIGYIR", "AEBDFCG", "aebdfcg", "123456789ABCDEF"};

    for (int i = 0; i < tests.length; i++) {
      Assertions.assertEquals(answers[i], q6.convert(tests[i], 3));
    }
  }

  @Test
  public void testFourRows() {
    var q6 = new Q0006ZigzagConversion();
    String[] tests = new String[] {"PAYPALISHIRING", "abcdefghIJKL"};
    String[] answers = new String[] {"PINALSIGYAHRPI", "agbfhLceIKdJ"};
    for (int i = 0; i < tests.length; i++) {
      Assertions.assertEquals(answers[i], q6.convert(tests[i], 4));
    }
  }

  @Test
  public void testOneColumn() {
    var q6 = new Q0006ZigzagConversion();
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < 50; i++) {
      builder.append((char) ('a' + i));
      var s = builder.toString();
      Assertions.assertEquals(s, q6.convert(s, s.length()));
    }
  }

  // hahah not a good test case
  //    @Test
  //    public void testTwoColumns() {
  //        var q6 = new Q006ZigzagConversion();
  ////        Assertions.assertEquals("aebcd", q6.convert("abcde", 4) );
  //        Assertions.assertEquals("aebfcd", q6.convert("abcdef", 4) );
  //        Assertions.assertEquals("aebfcgd", q6.convert("abcdefg", 4) );
  //        Assertions.assertEquals("aebfcgdh", q6.convert("abcdefgh", 4) );
  //    }

}
