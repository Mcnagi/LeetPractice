package problems;

public class Q0200NumberOfIslands {
    boolean[][] visited;
    int NUM_ROW;
    int NUM_COL;
    int count = 0;
    public int numIslands(char[][] grid) {
        NUM_COL = grid[0].length;
        NUM_ROW = grid.length;
        visited = new boolean[NUM_ROW][NUM_COL];

        for (int row = 0; row < NUM_ROW; row++) {
            for (int col = 0; col < NUM_COL; col++) {
                if (!visited[row][col]) {
                    visited[row][col] = true;
                    if (grid[row][col] == '1') {
                        visitNearby(grid, row, col);
                        count += 1;
                    }
                }

            }
        }
        return count;
    }
    public void visitNearby(char[][] grid, int row, int col) {
        if (row - 1 >= 0) tryVisit(grid, row - 1, col);
        if (row + 1 < NUM_ROW) tryVisit(grid, row + 1, col);
        if (col - 1 >= 0) tryVisit(grid, row, col - 1);
        if (col + 1 < NUM_COL) tryVisit(grid, row, col + 1);
    }
    public void tryVisit(char[][]grid, int row, int col) {
        if (!visited[row][col]) {
            visited[row][col] = true;
            if (grid[row][col] == '1') visitNearby(grid, row, col);
        }
    }
}
