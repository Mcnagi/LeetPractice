package problems.Q0031_Q0060;

public class Q0048RotateImage {
  public void rotate(int[][] matrix) {
    for (int i = 0; i < matrix.length / 2; i++) {
      rotate(matrix, i);
    }
  }

  private void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
    int tmp = matrix[x1][y1];
    matrix[x1][y1] = matrix[x2][y2];
    matrix[x2][y2] = tmp;
  }

  private void rotate(int[][] matrix, int s) {
    int n = matrix.length - 2 * s;
    int e = matrix.length - s - 1;
    for (int i = 0; i < n - 1; i++) {
      swap(matrix, s, s + i, s + i, e);
      swap(matrix, e, e - i, e - i, s);
    }
    for (int i = 0; i < n - 1; i++) {
      swap(matrix, s, s + i, e, e - i);
    }
  }
}
