package problems;

import java.util.Random;

public class Q0382LinkedListRandomNode{
    class Solution {
        ListNode[] listNodes = new ListNode[8];
        int size = 0;
        public Solution(ListNode head) {
            ListNode current = head;
            while (current != null) {
                addNode(current);
                current = current.next;
            }
        }
        void addNode(ListNode node) {
            if (size == listNodes.length) {
                ListNode[] tmp = new ListNode[size * 2];
                System.arraycopy(listNodes, 0, tmp, 0, size);
                listNodes = tmp;
            }
            listNodes[size ++] = node;
        }
        public int getRandom() {
            var rand = new Random();
            return listNodes[rand.nextInt(size)].val;
        }
    }

}
