package problems;

import java.util.ArrayList;
import java.util.List;

public class Q0025ReverseNodesInKGroup {

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

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        List<ListNode> tmp = new ArrayList<>();
        int count = 0;
        ListNode current = head;
        while (current != null && count < k) {
            tmp.add(current);
            count++;
            current = current.next;
        }
        if (count == k) {
            for (int i = 0; i < k - 1; i++) {
                tmp.get(k - 1 - i).next = tmp.get(k - 2 - i);
            }
            tmp.get(0).next = reverseKGroup(current, k);
        } else return head;
        return tmp.get(tmp.size() - 1);
    }

}
