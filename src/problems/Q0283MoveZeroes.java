package problems;

public class Q0283MoveZeroes {
  public void moveZeroes(int[] nums) {
    int size = 0;
    int countZeros = 0;
    for (int i = 0; size + countZeros < nums.length; i++) {
      if (nums[i] != 0) {
        nums[size] = nums[i];
        size += 1;
      } else {
        countZeros += 1;
      }
    }
    for (int i = 0; i < countZeros; i++) {
      nums[size + i] = 0;
    }
  }
}
