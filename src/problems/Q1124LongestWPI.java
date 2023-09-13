package problems;

import java.util.ArrayList;
import java.util.List;

public class Q1124LongestWPI {

  // seems to be no good using linked node
  //    class Node{
  //        int nonTired;
  //        int tired;
  //        int cumulativeNonTired;
  //        int cumulativeTired;
  //        Node prev;
  //        Node next;
  //
  //        public Node(int nonTired, int tired) {
  //            this.nonTired = nonTired;
  //            this.tired = tired;
  //            cumulativeNonTired = this.nonTired;
  //            cumulativeTired = this.tired;
  //        }
  //    }
  //    public int longestWPI(int[] hours) {
  //        int result = 0;
  //        Node head = new Node(0,0);
  //        Node current = head;
  //        boolean prevTired = false;
  //        for (int value : hours) {
  //            if (value > 8) {
  //                if (prevTired) {
  //                    current.tired += 1;
  //                    while ()
  //                } else {
  //                    Node prevNode = current;
  //                    current.next = new Node(0,1);
  //                    current = current.next;
  //                    current.prev = prevNode;
  //                }
  //                int tmp = current.cumulativeNonTired + current.cumulativeTired;
  //
  //                result = Math.max(result, );
  //                prevTired = true;
  //            }
  //            else {
  //                if (current.tired - current.nonTired > 1) {
  //                    current.nonTired += 1;
  //                } else {
  //                    Node prevNode = current;
  //                    current.next = new Node(1, 0);
  //                    current = current.next;
  //                    current.prev = prevNode;
  //                }
  //                prevTired = false;
  //            }
  //        }
  //
  //        return result;
  //    }
  int[] tiredCumulative;

  public int longestWPI(int[] hours) {
    int result = 0;

    tiredCumulative = new int[hours.length + 1];
    List<Integer> tiredIndex = new ArrayList<>(hours.length / 4);
    boolean tired = false;
    for (int i = 0; i < hours.length; i++) {
      if (hours[i] > 8) {
        tiredCumulative[i + 1] = tiredCumulative[i] + 1;
        if (!tired) {
          tiredIndex.add(i);
          tired = true;
        }
      } else {
        tiredCumulative[i + 1] = tiredCumulative[i];
        tired = false;
      }
      // never tired -> tiredIndex.size() would be zero.
      int j = 0;
      while (j < tiredIndex.size()) {
        int start = tiredIndex.get(j); // inclusive
        int tmp = exceedingTiredDays(start, i);
        if (tmp < 1) {
          j++;
          continue;
        }
        if (tmp > 1) {
          if (j > 0 && exceedingTiredDays(tiredIndex.get(j - 1), i) >= 1) {
            j -= 1;
            continue;
          } else start -= Math.min(tmp - 1, start);
        }
        result = Math.max(result, i - start + 1);
        break;
      }
    }
    return result;
  }

  int exceedingTiredDays(int start, int end) {
    int days = end - start + 1;
    int tiredDays = tiredCumulative[end + 1] - tiredCumulative[start];
    return tiredDays * 2 - days;
  }
}
