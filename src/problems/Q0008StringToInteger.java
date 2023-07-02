package problems;

public class Q0008StringToInteger {
    public int myAtoi(String s) {
        boolean positive = true;
        int result = 0;
        int index = 0;
        while (index < s.length() && s.charAt(index) == ' ') index += 1;
        if (index < s.length() && s.charAt(index) == '-') {
            positive = false;
            index += 1;
        }
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            result = (result * 10) + s.charAt(index) - '0';
            index += 1;
        }

        return result * (positive ? 1 : -1);
    }
}
