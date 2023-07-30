package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q1124LongestWPI {
    class Node{
        int nonTired;
        int tired;
        Node prev;
        Node next;

        public Node(int nonTired, int tired) {
            this.nonTired = nonTired;
            this.tired = tired;
        }
    }
    public int longestWPI(int[] hours) {
        int result = 0;
        Node head = new Node(0,0);
        Node current = head;
        for (int value : hours) {
            if (value > 8) {
                current.tired += 1;
                result = Math.max(result, current.tired + current.nonTired);
            }
            else {

            }
        }

        return result;
    }
//    int[] tiredCumulative;
//    public int longestWPI(int[] hours) {
//        int result = 0;
//
//        tiredCumulative = new int[hours.length + 1];
//        List<Integer> tiredIndex = new ArrayList<>(hours.length / 4);
//        boolean tired = false;
//        for (int i = 0; i < hours.length; i++) {
//            if (hours[i] > 8) {
//                tiredCumulative[i + 1] = tiredCumulative[i] + 1;
//                if (!tired) {
//                    tiredIndex.add(i);
//                    tired = true;
//                }
//            }
//            else {
//                tiredCumulative[i + 1] = tiredCumulative[i];
//                tired = false;
//            }
//            // never tired -> tiredIndex.size() would be zero.
//            int j = 0;
//            while (j < tiredIndex.size()) {
//                int start = tiredIndex.get(j); // inclusive
//                int tmp = exceedingTiredDays(start, i);
//                if (tmp < 1) {
//                    j ++;
//                    continue;
//                }
//                if (tmp > 1) {
//                    if (j > 0 && exceedingTiredDays(tiredIndex.get(j - 1), i) >= 1) {
//                        j -= 1;
//                        continue;
//                    }
//                    else start -= Math.min(tmp - 1, start);
//                }
//                result = Math.max(result, i - start + 1);
//                break;
//            }
//        }
//        return result;
//    }
//    int exceedingTiredDays(int start, int end) {
//        int days = end - start + 1;
//        int tiredDays = tiredCumulative[end + 1] - tiredCumulative[start];
//        return tiredDays * 2 - days;
//    }
}
