package problems.q0031_Q0060;

import java.util.Stack;

public class Q0032LongestValidParentheses {
  int index = 0;
  Stack<Integer> prevLefts = new Stack<>();
  Stack<Integer> prevRights = new Stack<>();
  int max = 0;

  public int longestValidParentheses(String s) {
    int left = 0;
    int right = 0;
    while (index < s.length()) {
      char c = s.charAt(index);
      if (c == '(') left++;
      else break;
      index++;
    }
    while (index < s.length()) {
      char c = s.charAt(index);
      if (c == ')') right++;
      else break;
      index++;
    }
    if (left > 0) {
      int count = 0;
      if (left <= right) { // i.e. "()))))))", or "((()))"
        while (!prevLefts.isEmpty()) {
          left += prevLefts.pop();
          right += prevRights.pop();
          if (left > right) break;
        }
        if (left < right) { // too much ")" disconnected.
          prevLefts.clear();
          prevRights.clear();
          count = left * 2;
        } else {
          prevLefts.push(left);
          prevRights.push(right);
          count = right * 2;
        }

      } else { // left > right
        prevLefts.push(left);
        prevRights.push(right);
        count = right * 2;
      }
      if (count > max) max = count;
    }
    if (index < s.length()) longestValidParentheses(s);
    return max;
  }
  //    public int solver(String s) {
  //        while (index < s.length()) {
  //            char c = s.charAt(index ++);
  //            if (c == '(') left++;
  //            else break;
  //        }
  //        if (left > 0) {
  //            while (index < s.length()) {
  //                char c = s.charAt(index ++);
  //                if (c == ')') right++;
  //                else break;
  //            }
  //        }
  //        return  -1;
  //    }
  //    public Pair<Integer, Integer> solver(String s) {
  //        int left = 0;
  //        while (index < s.length()) {
  //            char c = s.charAt(index ++);
  //            if (c == '(') left ++;
  //            else break;
  //        }
  //        int right = 0;
  //        while (index < s.length()) {
  //            char c = s.charAt(index++);
  //            if (c == ')') right ++;
  //            else break;
  //        }
  //        int closes = Math.min(left, right);
  //
  //        Pair<Integer, Integer> current = new Pair<>(left, right);
  //        if (closes > max) max = closes;
  //        return ;
  //    }

}
