package problems.Q0031_Q0060;

public class Q0044WildcardMatching {

  public boolean isMatch(String s, String p) {
    boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
    dp[0][0] = true;
    if (p.length() == 0) {
      if (s.length() == 0) return true;
      else return false;
    } else if (s.length() == 0) {
      for (char c : p.toCharArray()) if (c != '*') return false;
    }

    // check first index of p;
    if (p.charAt(0) == '*') for (int i = 0; i <= s.length(); i++) dp[1][i] = true;
    else if (p.charAt(0) == '?' || p.charAt(0) == s.charAt(0)) dp[1][1] = true;
    else return false;

    for (int pIndex = 1; pIndex < p.length(); pIndex++) {
      char pattern = p.charAt(pIndex);
      if (pattern == '*') dp[pIndex + 1][0] = dp[pIndex][0];
      for (int sIndex = 0; sIndex < s.length(); sIndex++) {
        if (pattern == '*') {
          dp[pIndex + 1][sIndex + 1] =
              dp[pIndex + 1][sIndex] || dp[pIndex][sIndex] || dp[pIndex][sIndex + 1];
          continue;
        } else if (pattern == '?' || pattern == s.charAt(sIndex)) {
          dp[pIndex + 1][sIndex + 1] = true;
        } else dp[pIndex + 1][sIndex + 1] = false;
        dp[pIndex + 1][sIndex + 1] &= dp[pIndex][sIndex];
      }
    }
    return dp[p.length()][s.length()];
  }
}
