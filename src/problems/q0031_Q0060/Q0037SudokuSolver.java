package problems.q0031_Q0060;

public class Q0037SudokuSolver {
  final int n = 9;

  public void solveSudoku(char[][] board) {
    solverHelper(board, 0, 0);
  }

  private boolean solverHelper(char[][] board, int row, int column) {
    if (row + 1 == n && column + 1 == n) return true;
    for (; row < n; row++) {
      for (; column < n; column++) {
        if (board[row][column] != '.') continue;
        for (int d = 1; d <= n; d++) {
          char digit = (char) ('0' + d);
          if (validPlacement(board, row, column, digit)) {
            board[row][column] = digit;
            if (solverHelper(board, row, column)) return true;
            else board[row][column] = '.';
          }
        }
        return false;
      }
      column = 0;
    }
    return true;
  }

  private boolean validPlacement(char[][] board, int row, int column, char digit) {
    for (int i = 0; i < n; i++) {
      if (board[row][i] == digit) return false;
      if (board[i][column] == digit) return false;
      int rowBlock = row / 3 * 3 + i / 3;
      int colBlock = column / 3 * 3 + i % 3;
      if (board[rowBlock][colBlock] == digit) return false;
    }
    return true;
  }
}
