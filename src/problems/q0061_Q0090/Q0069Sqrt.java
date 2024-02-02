package problems.q0061_Q0090;

public class Q0069Sqrt {
    public int mySqrt(int x) {
        if (x <= 1) return x;
        int result = 1;
        int prev = 0;
        while (true) {
            Long sq = (long) result * result;
            if (sq == x) return result;
            if (sq < x) {
                if (sq + 2L * result + 1 > x) return result;
                prev = result;
                result = Math.min(Integer.MAX_VALUE, result * 2);
            } else {
                result = (prev + result) / 2;
            }
        }
    }

    public int mySqrt2(int x) {
        if (x == 0) return 0;
        int s = 1, e = x;
        while (s < e) {
            int m = (s + e) / 2;
            if (x / m > m) {
                if (s == m) return s;
                s = m;
            }
            else if (x / m < m) {
                e = m;
            }
            else return m;
        }
        return s;
    }

}
