package problems;

public class Q0008StringToInteger {
    public int myAtoi(String s) {
        boolean positive = true;
        long result = 0;
        int index = 0;
        while (index < s.length() && s.charAt(index) == ' ') index += 1;
        if (index < s.length()) {
            char c = s.charAt(index);
            if (c == '-') {
                positive = false;
                index += 1;
            } else if (c == '+') index += 1;
        }
        if (positive) {
            while (index < s.length() && Character.isDigit(s.charAt(index))) {
                result = (result * 10) + s.charAt(index) - '0';
                if (result >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
                index += 1;
            }
        } else {
            while (index < s.length() && Character.isDigit(s.charAt(index))) {
                result = (result * 10) - s.charAt(index) + '0';
                if (result <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
                index += 1;
            }
        }
        return (int) result;
    }

}
