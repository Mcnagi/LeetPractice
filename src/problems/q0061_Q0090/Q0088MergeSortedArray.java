package problems.q0061_Q0090;

public class Q0088MergeSortedArray {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    if (n == 0) return;
    else if (m == 0) {
      System.arraycopy(nums2, 0, nums1, 0, n);
      return;
    }

    int[] copied = new int[m];
    System.arraycopy(nums1, 0, copied, 0, m);

    int size = 0, i = 0, j = 0, tmp = 0;
    while (i < m || j < n) {
      if (j == n || (i < m && copied[i] < nums2[j])) {
        nums1[size] = copied[i];
        i++;
      } else {
        nums1[size] = nums2[j];
        j++;
      }
      size++;
    }
  }
}
