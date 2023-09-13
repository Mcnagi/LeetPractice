package problems;

import java.util.ArrayList;
import java.util.List;

public class Q0019RemoveNthNodeFromEndOfList {
  public class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  // sacrifice memory for time.
  public ListNode removeNthFromEnd(ListNode head, int n) {
    List<ListNode> list = new ArrayList<>();
    ListNode current = head;
    while (current != null) {
      list.add(current);
      current = current.next;
    }
    int rmIndex = list.size() - n;
    if (rmIndex == 0) {
      if (list.size() == 1) return null;
      else return head.next;
    }
    if (rmIndex == list.size() - 1) {
      list.get(rmIndex - 1).next = null;
    } else list.get(rmIndex - 1).next = list.get(rmIndex + 1);
    return head;
  }
}
