package problems.q0061_Q0090;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class Q0069Test {
    public void test(int expected, int input) {
        var q = new Q0069Sqrt();
        var actual = q.mySqrt2(input);
        Assertions.assertEquals(expected, actual,
                String.format("Expect to have %s but got %s with input: %s", expected, actual, input));
    }

    @Test
    public void testSimple() {
        test(0, 0);
        test(1, 1);

        test(2, 4);
        test(2, 5);
        test(2, 8);

        test(3, 9);
        test(3, 10);
        test(3, 11);
        test(3, 15);
    }

    @Test
    public void testLarge() {
        test(10, 100);
        test(10, 120);
        test(11, 121);

        test((int)Math.sqrt(Integer.MAX_VALUE), Integer.MAX_VALUE);
        test((int)Math.sqrt(Integer.MAX_VALUE - 1), Integer.MAX_VALUE - 1);
    }

    @Test
    public void testHard() {

    }
}
