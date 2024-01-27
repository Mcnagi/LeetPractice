package problems.q0031_Q0060;

import java.util.ArrayList;
import java.util.List;

public class Q0046Permutations {
  int[] array;

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    this.array = nums;
    helper(result, new ArrayList<>());
    return result;
  }

  private void helper(List<List<Integer>> list, List<Integer> visited) {
    if (visited.size() == array.length) {
      list.add(visited);
      return;
    }
    for (int value : array) {
      if (visited.contains(value)) continue;
      List<Integer> next = new ArrayList<>(visited);
      next.add(value);
      helper(list, next);
    }
  }
}
