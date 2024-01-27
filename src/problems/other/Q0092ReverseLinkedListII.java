package problems.other;

public class Q0092ReverseLinkedListII {
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

  public ListNode reverseBetween(ListNode head, int left, int right) {
    if (head == null || head.next == null || left == right) return head;
    ListNode prev = null;
    ListNode current = head; // left == 1, left is head
    int count = 0;
    while (count < left - 1) {
      prev = current;
      current = current.next;
      count++;
    }
    ListNode leftPrev = prev;
    ListNode leftNode = current;
    prev = current;
    current = current.next;
    count = 0;
    while (count < right - left) { // guarantee right > left
      ListNode next = current.next;
      current.next = prev; // reverse the links
      prev = current;
      current = next; // move to next one
      count++;
    } // current is rightNode
    leftNode.next = current;
    if (leftPrev != null) leftPrev.next = prev;
    else return prev;
    return head;
  }
}
