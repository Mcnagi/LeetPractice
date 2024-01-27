package problems.q0031_Q0060;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q0039CombinationSum {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> result = new ArrayList<>();
    helper(new ArrayList<>(), 0, result, candidates, target, 0);
    return result;
  }

  public void helper(
      List<Integer> current,
      int sum,
      List<List<Integer>> result,
      int[] candidates,
      int target,
      int minIndex) {
    for (int i = minIndex; i < candidates.length; i++) {
      sum += candidates[i];
      if (sum == target) {
        List<Integer> good = new ArrayList<>(current);
        good.add(candidates[i]);
        result.add(good);
      } else if (sum < target) {
        current.add(candidates[i]);
        helper(current, sum, result, candidates, target, i);
        current.remove(current.size() - 1);
      }
      sum -= candidates[i];
    }
  }
}
