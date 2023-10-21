package problems.Q0001_Q0030;

public class Q0024SwapNodesInPairs {
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

  public ListNode swapPairs(ListNode head) {
    // head is null or head.next is null
    if (head == null) return null;
    if (head.next == null) return head;
    ListNode first = head;
    ListNode newHead = head.next;
    while (first != null) {
      ListNode second = first.next;
      if (second != null) {
        ListNode third = second.next;
        if (third != null && third.next != null) {
          first.next = third.next;
        } else first.next = third;
        second.next = first;
        first = third;
      } else break;
    }
    return newHead;
  }
}
