package problems.other;

import java.util.*;

public class Q0264UglyNumberII {
  //    1, 2, 3, 4, 5,
  //    6, 8, 9, 10, 12,
  //    15, 16, 18, 20, 24,
  //    25, 27, 30, 32, 36,
  //    40, 45, 48, 50, 54,
  //    60, 64

  //    1,   2,       3,     2*2,     5,
  //    2*3, 2*2*2,   3*3,   2*5,     2*2*3,
  //    3*5, 2*2*2*2, 2*3*3, 2*2*5,   2*2*2*3
  //    5*5, 3*3*3,   2*3*5, 2*2*2*2*2, 2*2*3*3
  //    40, 45, 48, 50, 54,
  //    60, 64

  // implemented based on the solution from leetcode.
  private static int[] uglies = new int[1690];

  static {
    uglies[0] = 1;
  }

  private static int size = 1;
  private static int i2, i3, i5 = 0;

  public int nthUglyNumber(int n) {
    while (size < n) {
      int tmp = Math.min(Math.min(uglies[i2] * 2, uglies[i3] * 3), uglies[i5] * 5);
      if (tmp == uglies[i2] * 2) i2++;
      if (tmp == uglies[i3] * 3) i3++;
      if (tmp == uglies[i5] * 5) i5++;
      uglies[size] = tmp;
      size += 1;
    }
    return uglies[n - 1];
  }

  //    static Set<Integer> uglies = new HashSet<>(Set.of(1,2,3,4,5,6,8,9,10,12,15,16));
  //    static List<Integer> ugliesList = new ArrayList<>(List.of(1,2,3,4,5,6,8,9,10,12,15,16));
  //    public int nthUglyNumber(int n) {
  //        while (uglies.size()  < Math.min(1691, n * Math.log(n))) {
  //            multiply(2);
  //            multiply(3);
  //            multiply(5);
  //            multiply(2);
  //        }
  //        return ugliesList.get(n - 1);
  //    }
  //    public void multiply(int x) {
  //        int size = uglies.size();
  //        for (int i = (int) Math.log(size); i < size; i++) {
  //            long tmp = ((long) ugliesList.get(i)) * ((long)x);
  //            if (tmp > Integer.MAX_VALUE) continue;
  //            int tmp2 = (int) tmp;
  //            if (!uglies.contains(tmp2)) {
  //                uglies.add(tmp2);
  //                ugliesList.add(tmp2);
  //            }
  //        }
  //
  //        ugliesList.sort(Integer::compareTo);
  //    }
}
