package problems.Q0001_Q0030;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
Given an integer x, return true if x is a palindrome , and false otherwise.

        Example 1:
        Input: x = 121
        Output: true
        Explanation: 121 reads as 121 from left to right and from right to left.

        Example 2:
        Input: x = -121
        Output: false
        Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

        Example 3:
        Input: x = 10
        Output: false
        Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

        Constraints: -231 <= x <= 231 - 1
        Follow up: Could you solve it without converting the integer to a string?

 */
public class Q0009Test {
  private void testTrue(int input) {
    var q9 = new Q0009PalindromeNumber();
    Assertions.assertTrue(q9.isPalindrome(input));
  }

  private void testFalse(int input) {
    var q9 = new Q0009PalindromeNumber();
    Assertions.assertFalse(q9.isPalindrome(input));
  }

  @Test
  public void testSmall() {
    // test one digit
    for (int i = 0; i < 10; i++) {
      testTrue(i);
    }
    // test palindrome
    int[] inputTrue = new int[] {121, 11, 99, 929, 505, 111, 737, 373};
    for (int input : inputTrue) {
      testTrue(input);
    }

    // test false
    int[] inputFalse = new int[] {-121, 10, 500, 908, -1, 34};
    for (int input : inputFalse) {
      testFalse(input);
    }
  }

  @Test
  public void testMedium() {
    // test palindrome
    int[] inputTrue = new int[] {111111, 1122211, 112211, 10101, 934439};
    for (int input : inputTrue) {
      testTrue(input);
    }

    // test false
    int[] inputFalse = new int[] {123456, 189089, 23443, -11111, -1234321, 1000021};
    for (int input : inputFalse) {
      testFalse(input);
    }
  }
}
