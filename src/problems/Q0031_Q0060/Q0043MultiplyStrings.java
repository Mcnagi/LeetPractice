package problems.Q0031_Q0060;

public class Q0043MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.length() == 0 || num2.length() == 0) return null;
        int[] digits = new int[num1.length() + num2.length()];
        // calculate
        for (int i = num1.length() - 1; i >= 0; i --) {
            for (int j = num2.length() - 1; j >= 0; j --) {
                int index = i + j + 1;
                int p = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                while (p > 0) {
                    int tmp = digits[index] + p;
                    digits[index] = tmp % 10;
                    p = tmp / 10;
                    index -= 1;
                }
            }
        }
        // concat
        int i = 0;
        while (i < digits.length && digits[i] == 0) i++;
        if (i >= digits.length) return "0";
        StringBuilder builder = new StringBuilder();
        for (; i < digits.length; i++) builder.append(digits[i]);
        return builder.toString();
    }
}
