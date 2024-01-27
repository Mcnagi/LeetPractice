package problems.other;

public class Q0328OddEvenLinkedList {

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

  public ListNode oddEvenList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode second = head.next;
    ListNode odd = head;
    ListNode even = head.next;
    while (odd != null && even != null) {
      if (odd != null && odd.next != null) {
        odd.next = odd.next.next;
        odd = odd.next;
        if (odd.next != null) odd = odd.next;
      }
      if (even != null && even.next != null) {
        even.next = even.next.next;
        even = even.next;
      }
    }
    odd.next = second;
    return head;
  }
}
