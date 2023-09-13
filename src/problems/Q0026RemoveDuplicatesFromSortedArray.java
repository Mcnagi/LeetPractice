package problems;

public class Q0026RemoveDuplicatesFromSortedArray {
  int[] array;

  public Q0026RemoveDuplicatesFromSortedArray(int[] array) {
    this.array = array;
  }

  public int removeDuplicates() {
    int size = 0;
    int prev = Integer.MIN_VALUE;
    for (int i = 0; i < array.length; i++) {
      if (array[i] != prev) {
        prev = array[i];
        array[size] = array[i];
        size++;
      }
    }
    return size;
  }
}
