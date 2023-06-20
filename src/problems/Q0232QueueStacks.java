package problems;

import java.util.Stack;

public class Q0232QueueStacks {
    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();

//    public MyQueue() {
//
//    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        int tmp = 0;
        while (!in.isEmpty()) {
            tmp = in.pop();
            out.push(tmp);
        }
        out.pop();
        while (!out.isEmpty()) {
            int tmp2 = out.pop();
            in.push(tmp2);
        }
        return tmp;
    }

    public int peek() {
        int tmp = 0;
        while (!in.isEmpty()) {
            tmp = in.pop();
            out.push(tmp);
        }
        while (!out.isEmpty()) {
            int tmp2 = out.pop();
            in.push(tmp2);
        }
        return tmp;
    }

    public boolean empty() {
        return in.isEmpty();
    }
}
