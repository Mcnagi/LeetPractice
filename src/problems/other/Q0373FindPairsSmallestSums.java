package problems.other;

import java.util.*;

public class Q0373FindPairsSmallestSums {
  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    List<List<Integer>> result = new ArrayList<>();
    int index1 = 0, index2 = 0;
    Map<Integer, Integer> map = new HashMap<>();
    while (index1 < nums1.length && index2 < nums2.length && k > 0) {
      int i = index1;
      int j = index2;
      result.add(new ArrayList<>(List.of(nums1[i], nums2[j])));

      map.put(index1, index2 + 1);
      k -= 1;
    }

    return result;
  }

  //    nums1 =
  //            [-10,-4,0,0,6]
  //    nums2 =
  //            [3,5,6,7,8,100]
  //    k =
  //            10
  //    Output
  // [[-10,3],[-10,5],[-10,6],[-10,7],[-10,8],[-4,3],[-4,5],[-4,6],[-4,7],[-4,8]]
  //    Expected
  // [[-10,3],[-10,5],[-10,6],[-10,7],[-10,8],[-4,3],[-4,5],[-4,6],[0,3],[0,3]]

  //    nums1 =
  //            [-10,-4,0,0,6]
  //    nums2 =
  //            [1,5,6,7,8,100]
  //    k =
  //            10
  //    Output
  // [[-10,1],[-10,5],[-10,6],[-10,7],[-10,8],[-4,1],[-4,5],[-4,6],[-4,7],[-4,8]]
  //    Expected
  // [[-10,1],[-10,5],[-10,6],[-4,1],[-10,7],[-10,8],[0,1],[0,1],[-4,5],[-4,6]]
}
