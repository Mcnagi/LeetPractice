package problems;

import java.util.HashSet;
import java.util.Set;

public class Q0142LinkedListCycleII {
  public ListNode detectCycle(ListNode head) {
    if (head == null) return head;
    Set<ListNode> set = new HashSet<>();
    set.add(head);
    while (head.next != null) {
      head = head.next;
      if (set.contains(head)) return head;
      set.add(head);
    }
    return null;
  }
}
