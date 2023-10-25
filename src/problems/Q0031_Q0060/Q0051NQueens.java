package problems.Q0031_Q0060;

import java.util.ArrayList;
import java.util.List;

public class Q0051NQueens {
  /*
      . . Q . .
      . x x x .
      x . x . x
  */
  public List<List<String>> solveNQueens(int n) {
    List<List<String>> result = new ArrayList<>();
    helper(result, new ArrayList<>(), n);
    return result;
  }

  private void helper(List<List<String>> result, List<Integer> visited, int n) {
    // plan : visited takes column index of Q
    if (visited.size() == n) {
      List<String> tmp = new ArrayList<>();
      for (int value : visited) tmp.add(toBoardString(n, value));
      result.add(tmp);
      return;
    }

    // recursive call
    int row = visited.size();
    List<Integer> columns = nextVisit(visited, row, n);
    if (columns.isEmpty()) return;
    for (int value : columns) {
      visited.add(value);
      helper(result, visited, n);
      visited.remove(visited.size() - 1);
    }
  }

  private String toBoardString(int n, int queen) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < n; i++) {
      if (i == queen) builder.append("Q");
      else builder.append(".");
    }
    return builder.toString();
  }

  private List<Integer> nextVisit(List<Integer> visited, int row, int n) {
    List<Integer> nextVisitList = new ArrayList<>();
    if (visited.isEmpty()) {
      for (int i = 0; i < n; i++) {
        nextVisitList.add(i);
      }
    } else {
      for (int column = 0; column < n; column++) {
        if (contains(visited, column, row)) continue;
        nextVisitList.add(column);
      }
    }
    return nextVisitList;
  }

  private boolean contains(List<Integer> visited, int column, int row) {
    if (row == 0) return false;
    for (int i = 1; i <= visited.size(); i++) {
      int prevColumn = visited.get(row - i);
      if (column == prevColumn || column - i == prevColumn || column + i == prevColumn) return true;
    }
    return false;
  }

  public static void main(String[] args) {
    var q = new Q0051NQueens();
    for (int i = 1; i < 10; i++) {
      System.out.println(q.solveNQueens(i).size());
    }
  }
}
