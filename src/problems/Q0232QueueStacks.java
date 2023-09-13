package problems;

import java.util.Stack;

public class Q0232QueueStacks {
  Stack<Integer> in = new Stack<>();
  Stack<Integer> out = new Stack<>();
  int size = 0;

  //    public MyQueue() {
  //
  //    }

  public void push(int x) {
    in.push(x);
    size += 1;
  }

  public int pop() {
    if (out.isEmpty()) {
      while (!in.isEmpty()) out.push(in.pop());
    }
    size -= 1;
    return out.pop();
  }

  public int peek() {
    if (out.isEmpty()) {
      while (!in.isEmpty()) out.push(in.pop());
    }
    return out.peek();
  }

  public boolean empty() {
    return size == 0;
  }
}
