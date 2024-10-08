package problems.q0031_Q0060;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import problems.q0031_Q0060.Q0037SudokuSolver;

public class Q0037Test {
  public void test(char[][] expected, char[][] input) {
    var q = new Q0037SudokuSolver();
    q.solveSudoku(input);
    Assertions.assertArrayEquals(
        expected,
        input,
        String.format(
            "Expect to have %s but got %s", boardToString(expected), boardToString(input)));
  }

  private String boardToString(char[][] board) {
    StringBuilder builder = new StringBuilder();
    for (char[] chars : board) builder.append(Arrays.toString(chars)).append("\n");
    return builder.toString();
  }

  @Test
  public void testSimple() {
    var board =
        new char[][] {
          new char[] {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
          new char[] {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
          new char[] {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
          new char[] {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
          new char[] {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
          new char[] {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
          new char[] {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
          new char[] {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
          new char[] {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

    var expected =
        new char[][] {
          new char[] {'5', '3', '4', '6', '7', '8', '9', '1', '2'},
          new char[] {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
          new char[] {'1', '9', '8', '3', '4', '2', '5', '6', '7'},
          new char[] {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
          new char[] {'4', '2', '6', '8', '5', '3', '7', '9', '1'},
          new char[] {'7', '1', '3', '9', '2', '4', '8', '5', '6'},
          new char[] {'9', '6', '1', '5', '3', '7', '2', '8', '4'},
          new char[] {'2', '8', '7', '4', '1', '9', '6', '3', '5'},
          new char[] {'3', '4', '5', '2', '8', '6', '1', '7', '9'}
        };
    test(expected, board);
  }

  @Test
  public void testMedian() {}

  @Test
  public void testHard() {}
}
