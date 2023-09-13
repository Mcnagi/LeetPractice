package problems;

public class Q0036ValidSudoku {

  public boolean isValidSudoku(char[][] board) {
    final int SIZE = 9;

    for (int row = 0; row < SIZE; row++) {
      int[] count = new int[SIZE];
      for (int i = 0; i < SIZE; i++) {
        char c = board[row][i];
        if (c == '.') continue;
        if (count[c - '1'] == 1) return false;
        count[c - '1'] = 1;
      }
    }
    for (int column = 0; column < SIZE; column++) {
      int[] count = new int[SIZE];
      for (int i = 0; i < SIZE; i++) {
        char c = board[i][column];
        if (c == '.') continue;
        if (count[c - '1'] == 1) return false;
        count[c - '1'] = 1;
      }
    }
    for (int grid = 0; grid < SIZE; grid++) {
      int[] count = new int[SIZE];
      for (int i = 0; i < SIZE; i++) {
        int row = (grid / 3) * 3 + i / 3;
        int column = (grid % 3) * 3 + i % 3;
        char c = board[row][column];
        if (c == '.') continue;
        if (count[c - '1'] == 1) return false;
        count[c - '1'] = 1;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    var q = new Q0036ValidSudoku();
    char[][] board = {
      new char[] {'.', '9', '.', '.', '4', '.', '.', '.', '.'},
      new char[] {'1', '.', '.', '.', '.', '.', '6', '.', '.'},
      new char[] {'.', '.', '3', '.', '.', '.', '.', '.', '.'},
      new char[] {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
      new char[] {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
      new char[] {'3', '.', '.', '.', '5', '.', '.', '.', '.'},
      new char[] {'.', '.', '7', '.', '.', '4', '.', '.', '.'},
      new char[] {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
      new char[] {'.', '.', '.', '.', '7', '.', '.', '.', '.'}
    };

    System.out.println(q.isValidSudoku(board));
  }
}
