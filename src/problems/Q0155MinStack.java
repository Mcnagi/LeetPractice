package problems;

import java.util.ArrayList;
import java.util.List;

public class Q0155MinStack {
    class MinStack {
        private List<Integer> stack;
        private List<Integer> minStack;
        public MinStack() {
            this.stack = new ArrayList<>();
            this.minStack = new ArrayList<>();
            minStack.add(Integer.MAX_VALUE);
        }

        public void push(int val) {
            this.stack.add(val);
            if (val < minStack.get(minStack.size() - 1)) minStack.add(val);
            else minStack.add(minStack.get(minStack.size() - 1));
        }

        public void pop() {
            stack.remove(stack.size() - 1);
            minStack.remove(minStack.size() - 1);
        }

        public int top() {
            return stack.get(stack.size() - 1);
        }

        public int getMin() {
            return minStack.get(minStack.size() - 1);
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
