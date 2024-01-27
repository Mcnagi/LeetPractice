package problems.Q0031_q0060;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import problems.Q0031_Q0060.Q0060PermutationSequence;

public class Q0060Test {
    public void test(String expected, int n, int k) {
        var q = new Q0060PermutationSequence();
        var actual = q.getPermutation(n, k);
        Assertions.assertEquals(expected, actual,
                String.format("Expect to have %s but got %s with input: %s",
                        expected,
                        actual,
                        "n: " + n + " and k: " + k));
    }

    @Test
    public void testThree() {
        test("123", 3, 1);
        test("132", 3, 2);
        test("213", 3, 3);
        test("321", 3, 6);
    }

    @Test
    public void testFour() {
        test("1234", 4, 1);
        test("2314", 4, 9);
        test("2413", 4, 11);
        test("4312", 4, 23);
        test("4321", 4, 24);
    }

}
