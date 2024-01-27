package problems.other;

public class Q1588SumAllOddLengthSubarrays {
  public int sumOddLengthSubarrays(int[] arr) {
    int[] count = new int[arr.length];
    for (int i = 0; i < count.length; i++) {
      count[i] += (arr.length - i) / 2;
      int offset = 1;
    }
    int result = 0;
    for (int i = 0; i < arr.length; i++) {
      result += arr[i] * ((arr.length - i) / 2 + (arr.length - i) % 2);
    }
    return result;
  }
}
