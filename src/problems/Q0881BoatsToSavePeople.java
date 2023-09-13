package problems;

import java.util.Arrays;
import java.util.Stack;

public class Q0881BoatsToSavePeople {
  public int numRescueBoats(int[] people, int limit) {
    Arrays.sort(people);
    Stack<Integer> stack = new Stack<>();
    int result = 0;
    for (int i = people.length - 1; i >= 0; i--) {
      if (stack.isEmpty() || stack.peek() + people[i] > limit) stack.push(people[i]);
      else {
        stack.pop();
        result += 1;
      }
    }
    while (!stack.isEmpty()) {
      stack.pop();
      result += 1;
    }
    return result;
  }
}
