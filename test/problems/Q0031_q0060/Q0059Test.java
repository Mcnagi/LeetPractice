package problems.Q0031_q0060;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import problems.Q0031_Q0060.Q0059SpiralMatrixII;

public class Q0059Test {

    public void test(int[][] expected, int input) {
        var q = new Q0059SpiralMatrixII();
        var actual = q.generateMatrix(input);
        Assertions.assertArrayEquals(expected, actual,
                String.format("Expect to have %s but got %s with input: %s", printMatrix(expected), printMatrix(actual), input));
    }

    @Test
    public void testOne() {
        test(new int[][]{new int[]{1}}, 1);
    }

    @Test
    public void testTwo() {
        test(new int[][]{
                new int[]{1, 2},
                new int[]{4, 3}}, 2);
    }

    @Test
    public void testThree() {
        test(new int[][]{
                new int[]{1, 2, 3},
                new int[]{8, 9, 4},
                new int[]{7, 6, 5}},
                3);
    }

    @Test
    public void testFour() {
        test(new int[][]{
                        new int[]{1, 2, 3 ,4},
                        new int[]{12, 13, 14, 5},
                        new int[]{11, 16, 15, 6},
                        new int[]{10, 9, 8, 7}},
                4);
    }

    private String printMatrix(int[][] matrix) {
        int nRow = matrix.length;
        int nCol = matrix[0].length;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nCol; j++) {
                builder.append(matrix[i][j]);
                builder.append(" ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
