package problems;

import java.util.HashSet;
import java.util.Set;

public class Q0150EvaluateReversePolishNotation {

  static final Set<String> OPERATORS = new HashSet<>(Set.of("+", "-", "*", "/"));

  public static int calculate(int l, int r, String operator) {
    return switch (operator) {
      case "*":
        yield l * r;
      case "+":
        yield l + r;
      case "/":
        yield l / r;
      case "-":
        yield l - r;
      default:
        yield 0;
    };
  }

  public static class ListNode {
    String s;
    Integer val;
    ListNode prev;
    ListNode next;

    public ListNode(String s, ListNode prev, ListNode next) {
      this.s = s;
      this.prev = prev;
      this.next = next;
    }

    public ListNode(String s) {
      this.s = s;
      this.prev = null;
      this.next = null;
    }

    public boolean isOperator() {
      return OPERATORS.contains(this.s);
    }

    public int getInt() {
      if (val == null && !isOperator()) val = Integer.parseInt(s);
      return val;
    }
  }

  public int evalRPN(String[] tokens) {
    ListNode head = new ListNode(null, null, null);
    ListNode current = head;
    for (String token : tokens) {
      ListNode tmp = new ListNode(token, current, null);
      current.next = tmp;
      if (tmp.isOperator()) {
        ListNode right = tmp.prev;
        ListNode left = right.prev;
        left.val = calculate(left.getInt(), right.getInt(), tmp.s);
        left.next = null;
        current = left;
      } else current = tmp;
    }
    return head.next.getInt();
  }
}
