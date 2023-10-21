package problems.Q0031_Q0060;

import java.util.function.Predicate;

public class Q0034FindFirstLast {
  int[] array;
  int target;

  public int[] searchRange(int[] nums, int target) {
    if (nums.length == 0) return new int[] {-1, -1};

    this.array = nums;
    this.target = target;
    int k = binarySearch(0, array.length - 1, x -> array[x] == target, x -> array[x] < target);
    if (k == -1) return new int[] {-1, -1};

    int left =
        binarySearch(
            0,
            k,
            x -> array[x] == target && (x == 0 || array[x - 1] < target),
            x -> array[x] < target);
    if (array[left] < target) left += 1;

    int right =
        binarySearch(
            k,
            array.length - 1,
            x -> array[x] == target && (x == array.length - 1 || array[x + 1] > target),
            x -> array[x] == target);
    if (array[right] > target) right -= 1;

    return new int[] {left, right};
  }

  private int binarySearch(int s, int e, Predicate<Integer> pred, Predicate<Integer> pred2) {
    int i = (s + e) / 2;
    while (s < e) {
      if (pred.test(i)) {
        return i;
      }
      if (pred2.test(i)) s = i + 1;
      else e = i - 1;
      i = (s + e) / 2;
    }
    if (pred.test(i)) return i;
    return -1;
  }
}
