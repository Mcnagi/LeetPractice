package problems;

public class Q0680ValidPalindromeII {
  public boolean validPalindrome(String s) {
    boolean deleted = false;
    return validHelper(s, false, 0, s.length() - 1);
  }

  boolean validHelper(String s, boolean deleted, int left, int right) {
    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        if (deleted) return false;
        return validHelper(s, true, left + 1, right) || validHelper(s, true, left, right - 1);
      }
      left += 1;
      right -= 1;
    }
    return true;
  }
}
