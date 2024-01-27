package problems.Q0031_Q0060;

import java.util.LinkedList;
import java.util.List;

public class Q0060PermutationSequence {

    private static Integer[] factorials = new Integer[11];

    private List<Integer> digits;
    /**
     * n <= 9
     */
    public String getPermutation(int n, int k) {
        this.digits = new LinkedList<>();
        for (int i = 0; i < n; i++) digits.add(i + 1);
        StringBuilder builder = new StringBuilder();

        while (k > 0 && digits.size() > 0) {
            int tmp = factorial(digits.size() - 1);
            int i = 0;
            while (tmp < k) {
                i += 1;
                k -= tmp;
            }
            builder.append(digits.remove(i));
        }

        return builder.toString();
    }

    public static int factorial(int n) {
        if (n <= 0) return 1;
        if (factorials[n - 1] == null) {
            int ans = factorial(n - 1) * n;
            factorials[n - 1] = ans;
        }
        return factorials[n - 1];
    }
}
