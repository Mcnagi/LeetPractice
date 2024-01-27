package problems.q0031_Q0060;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import problems.q0031_Q0060.Q0060PermutationSequence;

public class Q0060TestFactorial {
    public void test(int expected, int input) {
        var actual = Q0060PermutationSequence.factorial(input);
        Assertions.assertEquals(expected, actual,
                String.format("Expect to have %s but got %s with input: %s", expected, actual, input));
    }

    private final int[] inputs = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private final int[] answers = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800};
    @Test
    public void testFactorial() {
        for (int i = 0; i < inputs.length; i++) {
            test(answers[i], inputs[i]);
        }
    }

}
