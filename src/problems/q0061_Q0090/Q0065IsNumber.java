package problems.q0061_Q0090;

public class Q0065IsNumber {
    public boolean isNumber(String s) {
        if (s.length() == 0) return false;
        int i = 0;
        boolean hasDecimal = false;

        // problematic leading character
        if (isSign(s.charAt(i))) {
            i += 1;
            if (i == s.length()) return false;
        }
        if (s.charAt(i) == '.') {
            i += 1;   // can have exactly one decimal point
            hasDecimal = true;
        }
        if (i == s.length() || !Character.isDigit(s.charAt(i))) return false;

        i = parseInteger(s, i);
        if (i == -1) return false;   // -1 means invalid integer substring
        if (i >= s.length()) return true;  // the substring satisfy being a proper integer
        if (s.charAt(i) == '.') {
            if (hasDecimal) return false;
            i += 1;   // can have exactly one decimal point
            hasDecimal = true;
        }

        i = parseInteger(s, i);
        if (i == -1) return false;
        if (i >= s.length()) return true;
        if (isLetterE(s.charAt(i))) {
            i += 1;
            if (i >= s.length()) return false;
            if (isSign(s.charAt(i))) i += 1;
            if (i >= s.length()) return false;
        }
        return parseInteger(s, i) >= s.length();
    }


    /**
     * No plus or minus sign ahead
     * @return -1 if not valid integer or the last digit position
     * that satisfies being an integer.
     */
    private int parseInteger(String s, int i) {
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) i ++;
            else if (c == '.' || isLetterE(c)) return i;
            else return -1;
        }
        return i;
    }

    private boolean isSign(char c) {
        return c == '+' || c == '-';
    }

    private boolean isLetterE(char c) {
        return Character.toLowerCase(c) == 'e';
    }
}
