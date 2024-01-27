package problems.Q0031_Q0060;

public class Q0060PermutationSequence {

    private static Integer[] factorials = new Integer[11];

    /**
     * n <= 9
     */
    public String getPermutation(int n, int k) {

        return "";

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
