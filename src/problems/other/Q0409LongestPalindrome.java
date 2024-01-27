package problems.other;

public class Q0409LongestPalindrome {
  public int longestPalindrome(String s) {
    int result = 0;
    int[] count = new int[58];
    int singles = 0;
    for (char c : s.toCharArray()) {
      int index = c - 'A';
      if (count[index] > 0) {
        result += 2;
        count[index] -= 1;
        singles -= 1;
      } else {
        count[index] += 1;
        singles += 1;
      }
    }
    return result + (singles == 0 ? 0 : 1);
  }
}
