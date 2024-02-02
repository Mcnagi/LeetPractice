package problems.q0061_Q0090;

public class Q0067AddBinary {
    public String addBinary(String a, String b) {
        int carryOn = 0;
        int[] digits = new int[Math.max(a.length() , b.length()) + 1];
        int size = digits.length - 1;

        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >=0) {
            int cin = carryOn;
            char iChar = '0', jChar = '0';
            if (i >= 0) iChar = a.charAt(i--);
            if (j >= 0) jChar = b.charAt(j--);

            int digit = (iChar ^ jChar) & 1;

            carryOn = (1 & iChar & jChar) | (1 & digit & carryOn);
            digit = (digit ^ cin) & 1;
            digits[size --] = digit;
        }
        StringBuilder result = new StringBuilder();
        if (carryOn == 1)result.append(1);
        for (int k = 1; k < digits.length; k++) result.append(digits[k]);
        return result.toString();
    }
}
