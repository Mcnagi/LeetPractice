package problems.q0061_Q0090;

public class Q0064MinimumPath {
    public int minPathSum(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        int[][] cost = new int[r][c];
        cost[0][0] = grid[0][0];
        for (int i = 1; i < c; i++) cost[0][i] = grid[0][i] + cost[0][i - 1];
        for (int i = 1; i < r; i++) cost[i][0] = grid[i][0] + cost[i - 1][0];

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                cost[i][j] = grid[i][j] + Math.min(cost[i - 1][j], cost[i][j - 1]);
            }
        }

        return cost[r - 1][c - 1];
    }
}
