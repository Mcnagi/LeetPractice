package problems;

/**
 * @author user.name
 */
public class Q0005LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length() - 1; i++) {
            String tmp = findFixedLongest(s, i, result.length());
            if (tmp.length() > result.length()) result = tmp;
        }
        return result;
    }
    public String findFixedLongest(String s, int index, int currentMax) {
        // find aabaa
        int l = index - 1;
        int r = index + 1;
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                l --;
                r ++;
            }
            else break;
        }
        if (index + 1 == s.length() && s.charAt(index) != s.charAt(index + 1)) {
            if (l - r + 1 > currentMax) return s.substring(l + 1, r);
            else return "";
        }
        // find aabbaa, index and index + 1 have the same character
        int resultEven = 2;
        if (s.charAt(index) == s.charAt(index + 1)) {
            int l2 = index - 1;
            int r2 = index + 2;
            while (l2 >= 0 && r2 < s.length()) {
                if (s.charAt(l2) == s.charAt(r2)) {
                    resultEven += 2;
                    l2 --;
                    r2 ++;
                }
                else {
                    if (l2 - r2 > l - r) return s.substring(l2 + 1, r2);
                    break;
                };
            }
        }
        return s.substring(l + 1, r);
    }

}
