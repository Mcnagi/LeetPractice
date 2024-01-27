package problems.q0061_Q0090;

public class Q0063UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int r = obstacleGrid.length, c = obstacleGrid[0].length;
        int[][] matrix = new int[r][c];

        for (int i = 1; i < c; i++) {
            if (obstacleGrid[0][i] == 1) break;
            matrix[0][i] = 1;
        }
        for (int i = 1; i < r; i++) {
            if (obstacleGrid[i][0] == 1) break;
            matrix[i][0] = 1;
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (obstacleGrid[i][j] == 0) matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
            }
        }
        return matrix[r - 1][c - 1];
    }
}
