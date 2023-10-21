package problems.Q0001_Q0030;

public class Q0007ReverseInteger {

  public int reverse(int x) {
    if (x == 0) return 0;
    Long result = 0L;
    int abs = Math.abs(x);
    while (abs > 0) {
      result = (result * 10) + abs % 10;
      abs /= 10;
      if (result > Integer.MAX_VALUE) return 0;
    }
    return Math.toIntExact(result) * ((x < 0) ? -1 : 1);
  }
}
