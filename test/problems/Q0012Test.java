package problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q0012Test {

    public void test(String expected, int input) {
        var q = new Q0012IntegerToRoman();
        Assertions.assertEquals(expected, q.intToRoman(input),
                String.format("Expect to have %s with input: %s", expected, input));
    }

    @Test
    public void testOneToNine() {
        String[] answers = new String[]{"I", "II", "III", "IV", "V",
                "VI", "VII", "VIII", "IX"
        };
        for (int i = 0; i < 9; i++) {
            test(answers[i], i + 1);
        }
    }

    @Test
    public void testMedian() {
        int[] inputs = new int[]{58, };
        String[] answers = new String[]{"LVIII", };
        for (int i = 0; i < inputs.length; i++) {
            test(answers[i], inputs[i]);
        }

    }

    @Test
    public void testHard() {
        int[] inputs = new int[]{1994, 1999};
        String[] answers = new String[]{"MCMXCIV", "MCMXCIX" };
        for (int i = 0; i < inputs.length; i++) {
            test(answers[i], inputs[i]);
        }
    }
}
