package problems;

public class Q0206ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prevNode = head;
        ListNode currentNode = head.next;
        head.next = null;
        while (currentNode.next != null) {
            ListNode nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        currentNode.next = prevNode;
        return currentNode;
    }
}
