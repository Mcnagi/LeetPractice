package problems.Q0031_Q0060;

import java.util.Arrays;

public class Q0059SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int i = 0;
        int[] digit = {1};
        while (n > 0) {
            fillMatrix(matrix, i, digit, n);
            i += 1;
            n -= 2;
        }
        return matrix;
    }

    private void fillMatrix(int[][] matrix, int startPosition, int[] startDigit, int size) {
        if (size < 1) return;
        if (size == 1) matrix[startPosition][startPosition] = startDigit[0]++;
        int n = matrix.length;  // assume square matrix
        for (int i = startPosition; i < n - startPosition - 1; i ++)
            matrix[startPosition][i] = startDigit[0] ++;
        for (int i = startPosition; i < n- startPosition - 1; i ++)
            matrix[i][n - startPosition - 1] = startDigit[0] ++;
        for (int i = n - startPosition - 1; i > startPosition; i --)
            matrix[n - startPosition - 1][i] = startDigit[0] ++;
        for (int i = n - startPosition - 1; i > startPosition; i --)
            matrix[i][startPosition] = startDigit[0] ++;
    }
}
