package problems.other;

public class Q0224BasicCalculator {
  int current = 0;

  public int calculate(String s) {
    return helper(s);
  }

  public int helper(String s) {
    int result = 0, sign = 1, num = 0;
    while (current < s.length()) {
      char c = s.charAt(current);
      if (c == ' ') {
        current++;
        continue;
      }
      if (Character.isDigit(c)) {
        num = num * 10 + c - '0';
      } else if (c == '(') {
        current++;
        result += sign * helper(s);
      } else if (c == ')') {
        return result + sign * num;
      } else {
        result += sign * num;
        num = 0;
        sign = c == '-' ? -1 : 1;
      }
      current++;
    }
    return result + sign * num;
  }

  //    public int calculate(String s) {
  //        Stack<Stack<Integer>> numbers = new Stack<>();
  //        Stack<Integer> currentNumbers = new Stack<>();
  //        Stack<Stack<Character>> signs = new Stack<>();
  //        Stack<Character> currentSigns = new Stack<>();
  //
  //        int num = 0;
  //        for (char c : s.toCharArray()) {
  //            if (c == ' ') continue;
  //            if (Character.isDigit(c)) {
  //                num = num * 10 + c - '0';
  //            }
  //            else if (c == '(') {
  //                numbers.push(currentNumbers);
  //                signs.push(currentSigns);
  //                currentNumbers = new Stack<>();
  //                currentSigns = new Stack<>();
  //
  //            } else if (c == ')') {
  //                if (currentSigns.size() > 0) {
  //                    calculate(currentNumbers, currentSigns, num);
  //                    num = currentNumbers.pop();
  //                }
  //                // go out of the bracket
  //                currentNumbers = numbers.pop();
  //                currentSigns = signs.pop();
  //
  //            } else {
  //                // c is plus or minus
  //                if (currentNumbers.size() > 0) {
  //                    calculate(currentNumbers, currentSigns, num);
  //                }
  //                else {
  //                    currentNumbers.push(num);
  //                }
  //                num = 0;
  //                currentSigns.add(c);
  //            }
  //        }
  //        if (currentSigns.size() > 0) calculate(currentNumbers, currentSigns, num);
  //        return currentNumbers.size() == 0 ? num : currentNumbers.pop();
  //    }
  //    public void calculate(Stack<Integer> numbers, Stack<Character> signs, int right) {
  //        int left = numbers.pop();
  //        char op = signs.pop();
  //        left = switch(op) {
  //            case '+' -> left + right;
  //            case '-' -> left - right;
  //            default -> 0;
  //        };
  //        numbers.push(left);
  //    }
}
