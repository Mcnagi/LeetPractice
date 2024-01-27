package problems.other;

public class Q0394DecodeString {

  public String decodeString(String s) {
    return solver(s, new Index(0), 1, 0).toString();
  }

  public StringBuilder repeat(StringBuilder s, int n) {
    if (n == 0) return new StringBuilder();
    if (n == 1) return s;
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < n; i++) {
      result.append(s);
    }
    return result;
  }

  public class Index {
    int val;

    public Index(int val) {
      this.val = val;
    }

    public void plusOne() {
      val += 1;
    }

    public int getVal() {
      return val;
    }
  }

  public boolean isLetter(String s, Index start) {
    return Character.isLetter(s.charAt(start.getVal()));
  }

  public boolean isDigit(String s, Index start) {
    return Character.isDigit(s.charAt(start.getVal()));
  }

  public StringBuilder solver(String s, Index index, int n, int leftBracket) { // end is inclusive
    StringBuilder letters = new StringBuilder();
    while (index.val < s.length()) {
      if (s.charAt(index.val) == '[') {
        leftBracket += 1;
        index.plusOne();
      } else if (s.charAt(index.val) == ']') {
        letters = repeat(letters, n);
        index.plusOne();
        leftBracket -= 1;
        if (leftBracket > 0) return letters;
      } else if (isDigit(s, index)) {
        int num = 0;
        do {
          num = num * 10 + Integer.parseInt(s.substring(index.val, index.val + 1));
          index.plusOne();
        } while (isDigit(s, index));
        letters.append(solver(s, index, num, leftBracket));
      } else {
        while (index.val < s.length() && isLetter(s, index)) {
          letters.append(s.charAt(index.val));
          index.plusOne();
        }
      }
    }
    return letters;
  }
}
