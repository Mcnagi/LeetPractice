package problems.Q0001_Q0030;

public class Q0009PalindromeNumber {

  public boolean isPalindrome(int x) {
    if (x < 0) return false;
    String s = String.valueOf(x);
    for (int i = 0; i < s.length() / 2; i++) {
      if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
    }
    return true;
  }
  //    private boolean isPalindromeHelper(int x, int size) {
  //        if (x < 10) return true;
  //        while (x >= 10) {
  //            int powOfTen = (int) Math.pow(10, size - 1);
  //            int l = x / powOfTen;
  //            int r = x % 10;
  //            if (l != r) return false;
  //            x  -= l * powOfTen;
  //            x /= 10;
  //            return isPalindromeHelper(x, size - 2);
  //        }
  //        return true;
  //    }
  //
  //    private int getDigitsSize(int x) {
  //        int result = 0;
  //        while (x > 0) {
  //            x /= 10;
  //            result += 1;
  //        }
  //        return result;
  //    }
}
