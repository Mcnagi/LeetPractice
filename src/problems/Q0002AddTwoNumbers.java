package problems;

import java.util.ArrayList;
import java.util.Calendar;

public class Q0002AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int[] carryOn = {0};
            ListNode result = new ListNode();
            ListNode current = result;

            while (l1 != null || l2 != null) {
                current.next = add(l1, l2, carryOn);

                current = current.next;
                if (l1 != null) l1 = l1.next;
                if (l2 != null) l2 = l2.next;
            }
            if (carryOn[0] > 0) current.next = new ListNode(carryOn[0]);
            return result.next;
        }
        public ListNode add(ListNode l, ListNode r, int[] carryOn) {
            int val1 = 0;
            int val2 = 0;
            if (l != null) val1 = l.val;
            if (r != null) val2 = r.val;
            int tmp = val1 + val2 + carryOn[0];
            carryOn[0] = tmp / 10;
            return new ListNode(tmp % 10);
        }
    }
}
