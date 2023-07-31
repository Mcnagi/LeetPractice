package problems;

public class Q0125ValidPalindrome {
    String string;
    public boolean isPalindrome(String s) {
        string = s;
        int left = 0, right = s.length() - 1;
        while (left < right) {
            int leftChar = s.charAt(left);
            int rightChar = s.charAt(right);
            if (skip(leftChar)) {
                left ++;
            } else if (skip(rightChar)) {
                right --;
            } else {
                if (leftChar > 96) leftChar -= 32;
                if (rightChar > 96) rightChar -= 32;
                if (leftChar != rightChar) return false;
                left += 1;
                right -= 1;
            }
        }
        return true;
    }
    boolean skip(int x) {
        return x < 48 || (x > 57 && x < 65)
                || (x > 90 && x < 97)
                || x > 122;
    }

    public static void main(String[] args) {
        var q = new Q0125ValidPalindrome();
        System.out.println(q.isPalindrome("race a car"));
    }
}
