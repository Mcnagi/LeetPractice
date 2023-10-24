package problems.Q0031_Q0060;

import java.util.*;

public class Q0047PermutationsII {
  int[] array;

  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    this.array = nums;
    helper(result, 0);
    return result;
  }

  private void helper(List<List<Integer>> result, int index) {
    if (index == array.length) {
      List<Integer> list = new ArrayList<>();
      for (int value : array) list.add(value);
      result.add(list);
    }
    Set<Integer> swapped = new HashSet<>();
    for (int i = index; i < array.length; i++) {
      if (swapped.contains(array[i])) continue;
      swapped.add(array[i]);
      swap(i, index);
      helper(result, index + 1);
      swap(i, index);
    }
  }

  private void swap(int i, int j) {
    int tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }
}
