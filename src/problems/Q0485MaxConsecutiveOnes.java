package problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Q0485MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count ++;
            }
            else {
                if (count > max) max = count;
                count = 0;
            }
        }
        return Math.max(max, count);
    }

    public static class Q0023MergeKSortedLists {
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

            public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
                ListNode result = new ListNode(-1, null);
                ListNode current = result;
                while (list1 != null && list2 != null) {
                    if (list1.val < list2.val) {
                        current.next = list1;
                        list1 = list1.next;
                    } else {
                        current.next = list2;
                        list2 = list2.next;
                    }
                    current = current.next;
                }
                if (list1 != null) current.next = list1;
                else if (list2 != null) current.next = list2;
                return result.next;
            }
        }
    }
}
