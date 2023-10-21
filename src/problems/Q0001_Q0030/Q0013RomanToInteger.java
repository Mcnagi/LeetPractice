package problems.Q0001_Q0030;

public class Q0013RomanToInteger {
  /** I 1 V 5 X 10 L 50 C 100 D 500 M 1000 */
  public enum Roman {
    I(1),
    V(5),
    X(10),
    L(50),
    C(100),
    D(500),
    M(1000);
    int value;

    Roman(int value) {
      this.value = value;
    }
  }

  private Roman getRoman(Character c) {
    return switch (c) {
      case 'I' -> Roman.I;
      case 'V' -> Roman.V;
      case 'X' -> Roman.X;
      case 'L' -> Roman.L;
      case 'C' -> Roman.C;
      case 'D' -> Roman.D;
      case 'M' -> Roman.M;
      default -> null;
    };
  }

  public int romanToInt(String s) {
    Roman prevRoman = getRoman(s.charAt(0));
    int result = 0;
    for (int i = 1; i < s.length(); i++) {
      Roman currentRoman = getRoman(s.charAt(i));
      if (prevRoman.value >= currentRoman.value) result += prevRoman.value;
      else result -= prevRoman.value;
      prevRoman = currentRoman;
    }
    result += prevRoman.value;
    return result;
  }
}
