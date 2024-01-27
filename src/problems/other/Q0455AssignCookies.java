package problems.other;

import java.util.Arrays;

public class Q0455AssignCookies {
  public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int result = 0;
    int i = 0, j = 0;
    while (i < g.length && j < s.length) {
      if (g[i] <= s[j]) {
        result += 1;
        i += 1;
      }
      j += 1;
    }
    return result;
  }
}
