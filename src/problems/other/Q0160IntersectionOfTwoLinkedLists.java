package problems.other;

import java.util.ArrayList;
import java.util.List;

public class Q0160IntersectionOfTwoLinkedLists {

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      List<ListNode> listA = new ArrayList<>();
      List<ListNode> listB = new ArrayList<>();
      ListNode current = headA;
      while (current != null) {
        listA.add(current);
        current = current.next;
      }
      current = headB;
      while (current != null) {
        listB.add(current);
        current = current.next;
      }
      int indexA = listA.size() - 1;
      int indexB = listB.size() - 1;
      while (indexA >= 0 && indexB >= 0 && listA.get(indexA) == listB.get(indexB)) {
        indexA--;
        indexB--;
      }
      return indexA + 1 == listA.size() ? null : listA.get(indexA + 1);
    }
  }
}
