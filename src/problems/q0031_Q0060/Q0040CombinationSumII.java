package problems.q0031_Q0060;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q0040CombinationSumII {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> result = new ArrayList<>();
    int prev = -1;
    for (int i = 0; i < candidates.length; i++) {
      if (prev == candidates[i]) continue;
      helper(
          new ArrayList<>(List.of(candidates[i])),
          candidates[i],
          result,
          candidates,
          target,
          i + 1);
      prev = candidates[i];
    }
    return result;
  }

  private void helper(
      List<Integer> current,
      int sum,
      List<List<Integer>> result,
      int[] candidates,
      int target,
      int minIndex) {
    if (sum > target) return;
    if (sum == target) {
      List<Integer> good = new ArrayList<>(current);
      result.add(good);
      return;
    }
    for (int i = minIndex; i < candidates.length; i++) {
      if (i > minIndex && candidates[i] == candidates[i - 1]) continue;
      sum += candidates[i];
      current.add(candidates[i]);
      helper(current, sum, result, candidates, target, i + 1);
      current.remove(current.size() - 1);
      sum -= candidates[i];
    }
  }

  public static void main(String[] args) {
    int[] testcase = new int[] {2, 5, 2, 1, 2};
    var q = new Q0040CombinationSumII();
    System.out.println(q.combinationSum2(testcase, 5));
  }
}
