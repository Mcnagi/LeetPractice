package problems;

public class Q0304RangeSum2DImmutable {
    NumMatrix numMatrix;

    public Q0304RangeSum2DImmutable(int[][] matrix) {
        this.numMatrix = new NumMatrix(matrix);
    }

    class NumMatrix {

        int[][] cumulative;
        final int ROW_NUMBER;
        final int COLUMN_NUMBER;

        public NumMatrix(int[][] matrix) {
            this.ROW_NUMBER = matrix.length;
            this.COLUMN_NUMBER = matrix[0].length;
            this.cumulative = new int[ROW_NUMBER][COLUMN_NUMBER];

            this.cumulative[0][0] = matrix[0][0];
            // first row
            for (int column = 1; column < COLUMN_NUMBER; column++)
                this.cumulative[0][column] = this.cumulative[0][column - 1] + matrix[0][column];
            // first column
            for (int row = 1; row < ROW_NUMBER; row++)
                this.cumulative[row][0] = this.cumulative[row - 1][0] + matrix[row][0];

            for (int row = 1; row < ROW_NUMBER; row++) {
                for (int column = 1; column < COLUMN_NUMBER; column++) {
                    this.cumulative[row][column] = this.cumulative[row - 1][column]
                            + this.cumulative[row][column - 1]
                            - this.cumulative[row - 1][column - 1]
                            + matrix[row][column];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int result = this.cumulative[row2][col2];
            if (row1 > 0) {
                result -= this.cumulative[row1 - 1][col2];
            }
            if (col1 > 0) result -= this.cumulative[row2][col1 - 1];
            if (row1 * col1 > 0)  result += this.cumulative[row1 - 1][col1 - 1];
            return result;
        }
    }

    public static void main(String[] args) {

        int[][] matrix = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        var q = new Q0304RangeSum2DImmutable(matrix);
        System.out.println(q.numMatrix.sumRegion(2, 1, 4, 3));
        System.out.println(q.numMatrix.sumRegion(1, 1, 2, 2));
        System.out.println(q.numMatrix.sumRegion(1, 2, 2, 4));

        matrix = new int[][]{{-4, -5}};
        q = new Q0304RangeSum2DImmutable(matrix);
        System.out.println(q.numMatrix.sumRegion(0, 0, 0, 0));
        System.out.println(q.numMatrix.sumRegion(0, 0, 0, 1));
        System.out.println(q.numMatrix.sumRegion(0, 1, 0, 1));

    }
}
