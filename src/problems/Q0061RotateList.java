package problems;

public class Q0061RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode current = head;

        ListNode[] nodes = new ListNode[500];
        nodes[0] = head;
        int size = 1;

        while (current.next != null) {
            current = current.next;
            nodes[size] = current;
            size += 1;
        }
        k %= size;
        if (k == 0) return head;
        nodes[size - 1].next = nodes[0];
        nodes[(size - k - 1 + size) % size].next = null;
        return nodes[size - k];
    }

}
