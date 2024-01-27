package problems.q0001_Q0030;

public class Q0028FindFirstOccurrence {
  public int strStr(String haystack, String needle) {
    for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
      int j = 0;
      for (; j < needle.length(); j++) {
        if (needle.charAt(j) != haystack.charAt(i + j)) break;
      }
      if (j == needle.length()) return i;
    }
    return -1;
  }
}
