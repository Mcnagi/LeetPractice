package problems.q0031_Q0060;

import java.util.ArrayList;
import java.util.List;

public class Q0054SpiralMatrix {

  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>(matrix.length * matrix[0].length);
    int n = Math.min(matrix.length, matrix[0].length);
    for (int i = 0; i <= n / 2; i++) {
      getSpiral(result, matrix, i);
    }
    return result;
  }

  private void getSpiral(List<Integer> result, int[][] matrix, int s) {
    int eRow = matrix.length - s, eColumn = matrix[0].length - s;
    // eRow and eColumn are exclusive
    if (s >= eRow || s >= eColumn) return;
    for (int i = s; i < eColumn; i++) result.add(matrix[s][i]);
    for (int i = s + 1; i < eRow; i++) result.add(matrix[i][eColumn - 1]);

    if (eRow - s > 1) {
      for (int i = eColumn - 2; i >= s; i--) {
        result.add(matrix[eRow - 1][i]);
      }
    }
    if (eColumn - s > 1) {
      for (int i = eRow - 2; i >= s + 1; i--) {
        result.add(matrix[i][s]);
      }
    }
  }

  // row = 3, col = 1
  // n = 0
  // 1
  // 2
  // 3
  public static void main(String[] args) {
    var q = new Q0054SpiralMatrix();
    int[][] matrix = new int[][] {{1, 2, 3}, {4, 5, 6}};
    System.out.println(q.spiralOrder(matrix));
  }
}
