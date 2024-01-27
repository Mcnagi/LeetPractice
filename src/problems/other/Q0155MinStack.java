package problems.other;

public class Q0155MinStack {
  class MinStack {
    private final int INITIAL_SIZE = 32;
    private final int GROWTH_FACTOR = 2;
    private Integer[] array;
    private Integer[] minStack;
    private int size;

    public MinStack() {
      array = new Integer[INITIAL_SIZE];
      minStack = new Integer[INITIAL_SIZE];
      size = 0;
      minStack[0] = Integer.MAX_VALUE;
    }

    public void push(int val) {
      if (size == array.length) {
        Integer[] tmp = new Integer[array.length * GROWTH_FACTOR];
        System.arraycopy(array, 0, tmp, 0, array.length);
        array = tmp;
      }
      if (size + 1 == minStack.length) {
        Integer[] tmp = new Integer[minStack.length * GROWTH_FACTOR];
        System.arraycopy(minStack, 0, tmp, 0, minStack.length);
        minStack = tmp;
      }
      array[size] = val;
      if (val < minStack[size]) minStack[size + 1] = val;
      else minStack[size + 1] = minStack[size];
      size += 1;
    }

    public void pop() {
      array[size - 1] = null;
      minStack[size] = null;
      size -= 1;
    }

    public int top() {
      return array[size - 1];
    }

    public int getMin() {
      return minStack[size];
    }
  }

  /**
   * Your MinStack object will be instantiated and called as such: MinStack obj = new MinStack();
   * obj.push(val); obj.pop(); int param_3 = obj.top(); int param_4 = obj.getMin();
   */
}
