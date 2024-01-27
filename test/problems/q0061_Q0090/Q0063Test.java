package problems.q0061_Q0090;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Q0063Test {
    public void test(int expected, int[][] input) {
        var q = new Q0063UniquePathsII();
        var actual = q.uniquePathsWithObstacles(input);
        Assertions.assertEquals(expected, actual,
                String.format("Expect to have %s but got %s with input: %s", expected, actual, Arrays.toString(input)));
    }

    @Test
    public void testThreeByThree() {
        int[][] input = new int[][] {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        test(2, input);
    }
}
