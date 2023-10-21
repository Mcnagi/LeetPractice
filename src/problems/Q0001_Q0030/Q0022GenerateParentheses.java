package problems.Q0001_Q0030;

import java.util.ArrayList;
import java.util.List;

public class Q0022GenerateParentheses {
  String[] right =
      new String[] {"", ")", "))", ")))", "))))", ")))))", "))))))", ")))))))", "))))))))"};

  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    String[] parenthesis = new String[n * 2];
    for (int i = 0; i < n; i++) {
      parenthesis[i * 2] = "(";
    }
    fillRight(result, n, parenthesis, 0, 0);
    return result;
  }

  public void fillRight(List<String> result, int n, String[] parenthesis, int current, int used) {
    if (current == n - 1) {
      parenthesis[current * 2 + 1] = right[n - used];
      result.add(String.join("", parenthesis));
      return;
    }
    int maxToHave = current + 1 - used;
    for (int i = 0; i <= maxToHave; i++) {
      parenthesis[current * 2 + 1] = right[i];
      fillRight(result, n, parenthesis, current + 1, used + i);
    }
  }
}
