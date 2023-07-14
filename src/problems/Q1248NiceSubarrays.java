package problems;

import java.util.Deque;
import java.util.LinkedList;

public class Q1248NiceSubarrays {
//    int[] count;
//    int odd = 0;
    Deque<Integer> deque = new LinkedList<>();
    int i = 0;
    public int numberOfSubarrays(int[] nums, int k) {
        if (k > nums.length) return 0;
        int count = 0;
        int tmp = 1;
        while (i < nums.length) {
            if (nums[i] % 2 == 0) tmp += 1;
            else {
                deque.add(tmp);
                tmp = 1;
            }
            i += 1;
            if (deque.size() == k + 1) {
                count += deque.removeFirst() * deque.peekLast();
            }
        }
        if (deque.size() == k) count += deque.getFirst() * tmp;
        return count;
    }
//    public void add(int value) {
//        if (odd == count.length) {
//            int[] tmp = new int[count.length * 2];
//            System.arraycopy(count, 0, tmp, 0, count.length);
//        }
//        count[odd] = value;q1+```
//        odd += 1;
//    }
}
