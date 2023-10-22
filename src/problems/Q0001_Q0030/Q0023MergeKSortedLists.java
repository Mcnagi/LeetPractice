package problems.Q0001_Q0030;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import problems.ListNode;

public class Q0023MergeKSortedLists {

  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) return null;
    List<ListNode> array = new ArrayList<>();
    for (int i = 0; i < lists.length; i++) {
      ListNode current = lists[i];
      while (current != null) {
        array.add(current);
        current = current.next;
      }
    }
    if (array.size() == 0) return null;
    array.sort(Comparator.comparingInt(x -> x.val));
    for (int i = 0; i < array.size() - 1; i++) {
      array.get(i).next = array.get(i + 1);
    }
    return array.get(0);
  }
}
