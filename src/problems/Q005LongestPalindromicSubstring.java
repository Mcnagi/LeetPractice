package problems;

/**
 * @author user.name
 */
public class Q005LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int left = 0;
        int right = 1;
        findPalindrome(s, left, right);
        return s.substring(left, right);
    }

    public void findPalindrome(String s, int left, int right) {

    }
}
