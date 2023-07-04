package problems;

public class Q0303RangeSumQueryImmutable {
    NumArray numArray;

    public Q0303RangeSumQueryImmutable(int[] array) {
        this.numArray = new NumArray(array);
    }

    class NumArray{
        int[] array;
        int[] sums;
        boolean[] filled;
        public NumArray(int[] nums) {
            this.array = nums;
            this.sums = new int[100];
            this.filled = new boolean[100];
        }

        public int sumRange(int left, int right) {
            if (left > right) return 0;
            int result = 0;
            if (left / 100 == right / 100) {
                for (int i = left; i <= right; i++) {
                    result += array[i];
                }
                return result;
            }
            while (left % 100 != 0 && left <= right) {
                result += array[left];
                left += 1;
            }
            while (left + 99 <= right) {
                int leftGroup = left / 100;
                if (!filled[leftGroup]){
                    for (int i = 0; i < 100; i++) {
                        sums[leftGroup] += array[left];
                        left += 1;
                    }
                    filled[leftGroup] = true;
                } else {
                    left += 100;
                }
                result += sums[leftGroup];
            }
            return result + sumRange(left, right);
        }
    }

}
