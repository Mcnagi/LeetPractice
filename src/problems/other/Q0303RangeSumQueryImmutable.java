package problems.other;

public class Q0303RangeSumQueryImmutable {
  public NumArray numArray;

  public Q0303RangeSumQueryImmutable(int[] array) {
    this.numArray = new NumArray(array);
  }

  public class NumArray {
    int[] array;
    int[] sums;

    public NumArray(int[] nums) {
      this.array = nums;
      this.sums = new int[array.length];
      int sum = 0;
      for (int i = 0; i < sums.length; i++) {
        sum += array[i];
        sums[i] = sum;
      }
    }

    public int sumRange(int left, int right) {
      if (left == 0) return sums[right];
      return sums[right] - sums[left - 1];
    }
  }

  //    class NumArray{
  //        int[] array;
  //        int[] sumsHundred;
  //        boolean[] filledHundred;
  //        int[] sumsThousand;
  //        boolean[] filledThousand;
  //        public NumArray(int[] nums) {
  //            this.array = nums;
  //            this.sumsHundred = new int[100];
  //            this.filledHundred = new boolean[100];
  //            this.sumsThousand = new int[10];
  //            this.filledThousand = new boolean[10];
  //        }
  //
  //        public int sumRange(int left, int right) {
  //            if (left > right) return 0;
  //            int result = 0;
  //            if (left / 100 == right / 100) {
  //                for (int i = left; i <= right; i++) {
  //                    result += array[i];
  //                }
  //                return result;
  //            }
  //            while (left % 100 != 0 && left <= right) {
  //                result += array[left];
  //                left += 1;
  //            }
  //            while (left + 999 <= right) {
  //                int leftGroup = left / 1000;
  //                if (!filledHundred[leftGroup]){
  //                    for (int i = 0; i < 1000; i++) {
  //                        sumsHundred[leftGroup] += array[left];
  //                        left += 1;
  //                    }
  //                    filledHundred[leftGroup] = true;
  //                } else {
  //                    left += 1000;
  //                }
  //                result += sumsHundred[leftGroup];
  //            }
  //            while (left + 99 <= right) {
  //                int leftGroup = left / 100;
  //                if (!filledHundred[leftGroup]){
  //                    for (int i = 0; i < 100; i++) {
  //                        sumsHundred[leftGroup] += array[left];
  //                        left += 1;
  //                    }
  //                    filledHundred[leftGroup] = true;
  //                } else {
  //                    left += 100;
  //                }
  //                result += sumsHundred[leftGroup];
  //            }
  //            return result + sumRange(left, right);
  //        }
  //        public int getSumHundred(int left) {
  //            int result = 0;
  //            int leftGroup = left / 100;
  //            if (!filledHundred[leftGroup]){
  //                for (int i = 0; i < 100; i++) {
  //                    sumsHundred[leftGroup] += array[left];
  //                    left += 1;
  //                }
  //                filledHundred[leftGroup] = true;
  //            } else {
  //                left += 100;
  //            }
  //            result += sumsHundred[leftGroup];
  //            return result;
  //        }

}
