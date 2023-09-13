package problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

Example 1:
Input: x = 123
Output: 321

Example 2:
Input: x = -123
Output: -321

Example 3:
Input: x = 120
Output: 21

Constraints: -231 <= x <= 231 - 1
 */
public class Q0007Test {

  public void test(int expected, int input) {
    var q7 = new Q0007ReverseInteger();
    Assertions.assertEquals(expected, q7.reverse(input));
  }

  @Test
  public void testTrivial() {
    for (int i = 0; i < 10; i++) {
      test(i, i);
    }
  }

  @Test
  public void testShort() {
    int[] tests = new int[] {123, 11, -11, 112, -12, 91, 19, -19};
    int[] answers = new int[] {321, 11, -11, 211, -21, 19, 91, -91};
    for (int i = 0; i < tests.length; i++) {
      test(answers[i], tests[i]);
    }
    tests = new int[] {1254, 4356, 571, 175, -1759, -9040};
    answers = new int[] {4521, 6534, 175, 571, -9571, -409};
    for (int i = 0; i < tests.length; i++) {
      test(answers[i], tests[i]);
    }
  }

  @Test
  public void testLong() {
    int[] tests = new int[] {2_147_483_647, -2_147_483_647, -2_147_483_648, 2147483, 2_100_000_000};
    int[] answers = new int[] {0, 0, 0, 3847412, 12};
    for (int i = 0; i < tests.length; i++) {
      test(answers[i], tests[i]);
    }
  }
}
