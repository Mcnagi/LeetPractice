package problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q020Test {

    public void testTrue(String s) {
        var q20 = new Q020ValidParentheses();
        Assertions.assertTrue(q20.isValid(s));
    }
    public void testFalse(String s) {
        var q20 = new Q020ValidParentheses();
        Assertions.assertFalse(q20.isValid(s));
    }

    @Test
    public void testSimple() {
        String[] testTrueSample = new String[]{
                "()", "[]", "{}", "()[]", "[]()", "{}()",
                "()()", "[][]", "{}{}", "()[][]", "[](){}", "{}(){}",
        };
        for (int i = 0; i < testTrueSample.length; i++) {
            testTrue(testTrueSample[i]);
        }

        String[] testFalseSample = new String[]{
                "(", ")", "[", "]", "{", "}", "({", "([", "(]", "(}",
                "(){", "{}}", "[]}", "[}]", "{)}", "{(}", "{}{}]", "([}])"
        };
        for (int i = 0; i < testTrueSample.length; i++) {
            testFalse(testFalseSample[i]);
        }


    }
}
